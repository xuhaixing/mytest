package com.xhx.java;

import org.junit.Test;


public class Test02 {

    @Test
    public void test01() {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotate(matrix);
        for (int[] ints : matrix) {
            for (int i = 0; i < ints.length; i++) {
                System.out.print(ints[i] + "\t");
            }
            System.out.println();
        }
    }

    public void rotate(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        int length = matrix.length;

        //中间的纵轴对折
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length / 2; j++) {
                int tem = matrix[i][j];
                matrix[i][j] = matrix[i][length - 1 - j];
                matrix[i][length - 1 - j] = tem;
            }
        }

        //右上到左下角对角线对折
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                int tem = matrix[i][j];
                matrix[i][j] = matrix[length - 1 - j][length - 1 - i];
                matrix[length - 1 - j][length - 1 - i] = tem;
            }
        }

    }

}
