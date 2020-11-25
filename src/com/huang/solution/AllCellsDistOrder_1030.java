package com.huang.solution;

import java.util.Arrays;
import java.util.Comparator;

// 注意这个处理二维数组的方式
public class AllCellsDistOrder_1030 {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
            int [][] matrix = new int[R * C][];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    matrix[C * i + j] = new int [] {i, j};
                }
            }
            Arrays.sort(matrix, Comparator.comparingInt(o -> (Math.abs(o[0] - r0) + Math.abs(o[1] - c0))));
            return matrix;
    }
}
