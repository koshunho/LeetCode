package com.huang.solution;
/*861. 翻转矩阵后的得分
有一个二维矩阵A 其中每个元素的值为0或1。

移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。

在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。

返回尽可能高的分数。



示例：

输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
输出：39
解释：
转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39


提示：

1 <= A.length <= 20
1 <= A[0].length <= 20
A[i][j]是0 或1
*/

// 翻转策略：
// 1、行：首位是0，翻转当前行，否则不翻转；
// 2、列：0的数量多时，翻转当前列，否则不翻转；
public class MatrixScore_861 {
    public int matrixScore(int[][] A) {
        int ans = 0;
        rowOperation(A);
        colOperation(A);
        for (int[] ints : A) {
            int temp = 0;
            for (int i : ints) {
                temp *= 2;
                temp += i;
            }
            ans += temp;
        }
        return ans;
    }

    private void rowOperation(int[][] A){
        for (int[] ints : A) {
            if(ints[0] == 0){
                for (int i = 0; i < ints.length; i++) {
                    ints[i] = 1 - ints[i];
                }
            }
        }
    }

    private void colOperation(int[][] A){
        for (int i = 0; i < A[0].length; i++) {
            int count = 0;
            for (int j = 0; j < A.length; j++) {
                if(A[j][i] == 0) count++;
            }
            if(count > A.length - count){
                for (int j = 0; j < A.length; j++) {
                    A[j][i] = 1 - A[j][i];
                }
            }
        }
    }
}
