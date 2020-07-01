package com.huang.solution;
/*718. 最长重复子数组
给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。



示例：

输入：
A: [1,2,3,2,1]
B: [3,2,1,4,7]
输出：3
解释：
长度最长的公共子数组是 [3, 2, 1] 。


提示：

1 <= len(A), len(B) <= 1000
0 <= A[i], B[i] < 100
隐藏提示：运用动态规划的方法，dp[i][j] 就是是输入中 A [i:], B[j:] 所对应的答案。*/

// 按照隐藏提示写就行了。。比较简单的DP开启7月的每日一题555
public class FindLength_718 {
    public int findLength(int[] A, int[] B) {
        int lenA = A.length, lenB  = B.length;

        int [][] dp = new int [lenA][lenB];

        int max = 0;

        for(int i = 0; i < lenA; i++){
            for(int j = 0; j < lenB; j++){
                if(A[i] == B[j]){
                    if(i-1 < 0 || j-1 <0){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int [] A = {1,2,3,2,1};

        int [] B = {3,2,1,4,7};

        int ret = new FindLength_718().findLength(A, B);

        System.out.println(ret);
    }
}
