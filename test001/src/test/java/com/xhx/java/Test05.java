package com.xhx.java;

import org.junit.Test;

public class Test05 {

    @Test
    public void test01(){
        System.out.println(new Test05().count("abcab", "ab"));
    }
    public int count(String str1, String str2){
        int c = 0;
        int index = str1.indexOf(str2);
        while (index!=-1){
            c++;
            index = str1.indexOf(str2, index+1);
        }
        return c;

    }
}
