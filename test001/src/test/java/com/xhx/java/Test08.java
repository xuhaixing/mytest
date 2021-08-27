package com.xhx.java;

import org.junit.Test;

public class Test08 {

    @Test
    public void test01(){
        int n = 7;
        System.out.println(method01(n));

    }
    public int method01(int n){
        if(n == 1){
            return 1;
        }
        int i = 1;
        int tem = 2<<i;
        while (tem <= n){
            i++;
            tem <<=1;
        }
        return n-(tem>>1)+1;
    }
}
