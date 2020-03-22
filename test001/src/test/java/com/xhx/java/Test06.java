package com.xhx.java;

import java.util.concurrent.ConcurrentHashMap;

public class Test06 {

    public static void main(String[] args) {
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 200000; i++) {
            map.put(i, "bbbbbbbb");
        }

    }
}
