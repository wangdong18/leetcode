package com.mortal.leetcode.done;


/**
 * 2022. 将一维数组转变成二维数组
 * @author mortal
 * @create 2022/1/18 17:22
 */
public class Construct2DArray {
    public static int[][] construct2DArray(int[] original, int m, int n) {
        int[][] ints = new int[m][n];
        if(original.length!=m*n){
            return new int[][]{};
        }
        for (int i = 0; i < m; i++) {
            int[] row = new int[n];
            for (int j = 0; j < row.length; j++) {
                row[j] = original[i * n  + j];
            }
            ints[i] = row;
        }

        return ints;
    }

    public static void main(String[] args) {
        int[] original = new int[]{3};
        int m = 1;
        int n = 2;
        int[][] ints = construct2DArray(original, m, n);
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.err.println("aaaa"+i);
            }
        }
        System.err.println("bbbb"+ints);
    }
}
