package com.xhx.java;

import java.util.Arrays;

public class middleNum {
    public static void main(String[] args) {
        Person[] persons = new Person[]{
                new Person("a", "11", 0.02f),
                new Person("a", "11", 0.02f),
                new Person("a", "11", 0.03f),
                new Person("a", "11", 0.03f),
                new Person("a", "11", 0.04f),
                new Person("a", "11", 0.1f)
        };
        int[] middles = new middleNum().getHeightMedian(persons);
        System.out.println(Arrays.toString(middles));
    }


    int[] getHeightMedian(Person[] persions) {
        int[] temArray = new int[300];

        //计数
        for (int i = 0; i < persions.length; i++) {
            temArray[(int) (persions[i].height * 100)]++;
        }
        for (int i = 1; i < temArray.length; i++) {
            temArray[i] += temArray[i - 1];
        }
        int middle = persions.length / 2;
        int mod = persions.length % 2;
        int mid1 = 0, mid2 = 0;
        if(mod!=0){
            middle++;
        }
        for (int i = 0; i < 300; i++) {
            if (temArray[i] >= middle) {
                mid1 = i;
                break;
            }
        }
        //偶数
        if (mod == 0) {
            if (temArray[mid1] == middle) {
                int tem = mid1;
                while (temArray[tem]==temArray[mid1]){
                    tem++;
                    mid2 = tem;
                }
            }
        }
        return mid2 == 0?new int[]{mid1}:new int[]{mid1, mid2};

    }
}

class Person {
    String name;
    String id;
    Float height;

    public Person(String name, String id, Float height) {
        this.name = name;
        this.id = id;
        this.height = height;
    }
}
