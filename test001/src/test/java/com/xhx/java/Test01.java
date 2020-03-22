package com.xhx.java;


public class Test01 {


    public static void printMatrix(int N) {


        int[][] a = new int[N][N];
        int i, j, tp = 1;
        for (i = 0; i < N / 2; i++)//最外层控制圈数
        {
            for (j = i; j < N - 1 - i; j++)
                if (a[i][j] == 0)
                    a[i][j] = tp++;
            for (j = i; j < N - 1 - i; j++)
                if (a[j][N - 1 - i] == 0)
                    a[j][N - 1 - i] = tp++;
            for (j = N - 1 - i; j > i; j--)
                if (a[N - 1 - i][j] == 0)
                    a[N - 1 - i][j] = tp++;
            for (j = N - 1 - i; j > i; j--)
                if (a[j][i] == 0)
                    a[j][i] = tp++;
        }
        if (N % 2 == 1)
            a[N / 2][N / 2] = tp;

        for (i = 0; i < N; i++) {
            for (j = 0; j < N; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        printMatrix(5);
    }

/**
 1
 1

 2
 1 2
 4 3

 3
 1 2 3
 8 9 4
 7 6 5
 **/
}
