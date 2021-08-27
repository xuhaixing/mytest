package com.java.xhx;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class MergeMain {


    public static void main(String[] args) throws Exception {

        String filePath = "C:\\Users\\xuhaixing\\Documents\\张掖-2018";
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        AtomicInteger atomicInteger = new AtomicInteger(0);

        File path = new File(filePath);
        File[] files = path.listFiles();
        for (File execelFile : files) {
            if (execelFile.getName().endsWith("xls")) {
                FileInputStream fis = new FileInputStream(execelFile);
                List<List<String>> dataList = read(fis);
                exportData(dataList, workbook, sheet, atomicInteger);
            }
        }
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\xuhaixing\\Documents\\temp.xlsx");
        workbook.write(fileOutputStream);
    }

    public static void exportData(List<List<String>> dataList, Workbook workbook, Sheet sheet, AtomicInteger atomicInteger) throws Exception{
        for (int i = 0; i < dataList.size(); i++) {
            List<String> columns = dataList.get(i);
            Row row = sheet.createRow(atomicInteger.getAndIncrement());
            row.setHeightInPoints(25.9f);
            for (int j = 0; j < columns.size(); j++) {
                Cell cell = row.createCell(j);
                cell.setCellStyle(getCellStyle(workbook));
                cell.setCellValue(columns.get(j));
            }
        }
    }

    public static List<List<String>> read(InputStream inputStream) throws Exception {
        HSSFWorkbook sheets = new HSSFWorkbook(inputStream);
        HSSFSheet sheet = sheets.getSheetAt(0);
        int rows = sheet.getPhysicalNumberOfRows();
        List<List<String>> dataList = new ArrayList<List<String>>(4000);
        for (int i = 3; i < rows; i++) {
            HSSFRow row = sheet.getRow(i);
            if (row == null) {
                continue;
            }
            List<String> rowList = new ArrayList<>(40);
            for (int c = 0; c < row.getPhysicalNumberOfCells(); c++) {
                HSSFCell cell = row.getCell(c);
                String cellValue = null;
                if (cell != null) {
                    switch (cell.getCellType()) {
                        case NUMERIC: // 数字
                            cellValue = cell.getNumericCellValue() + "";
                            break;
                        case STRING: // 字符串
                            cellValue = cell.getStringCellValue();
                            break;
                        case BOOLEAN: // Boolean
                            cellValue = cell.getBooleanCellValue() + "";
                            break;
                        case FORMULA: // 公式
                            cellValue = cell.getCellFormula() + "";
                            break;
                        case BLANK: // 空值
                            cellValue = "";
                            break;
                        case ERROR: // 故障
                            cellValue = "非法字符";
                            break;
                        default:
                            cellValue = "未知类型";
                            break;
                    }
                }
                rowList.add(cellValue);
            }
            dataList.add(rowList);
        }
        return dataList;
    }

    private static CellStyle style = null;
    public static CellStyle getCellStyle(Workbook workbook){
        if(style == null) {
            style = workbook.createCellStyle();
            Font font = workbook.createFont();
            font.setFontName("宋体");
            style.setFont(font);
        }

        return style;
    }
}
