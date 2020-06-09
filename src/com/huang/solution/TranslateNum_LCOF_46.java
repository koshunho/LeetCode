package com.huang.solution;
/*面试题46. 把数字翻译成字符串
给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。

示例 1:

输入: 12258
输出: 5
解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
。*/

// https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/solution/mian-shi-ti-46-ba-shu-zi-fan-yi-cheng-zi-fu-chua-6/
// num = x1x2x3...x(n-2)x(n-1)x(n)
// 例如12258 = x1x2x3x4x5
// 设x(n-2)的翻译有f(n-2)种，x(n-1)的翻译有f(n-1)种
// 当单独翻译x(n)，则翻译方案为f(n-1)
// 如果x(n-1)x(n)可以视为一个整体，也就是10 <= x(n-1)x(n) <= 25，那么就有f(n-2)种方案
// 所以f(n) = f(n-1) _+__f(n-2)__(可选项，需要判断条件)
// 为什么dp[0] = 1，因为假设num = 12，显然方案有2种。dp[2] = dp[1] + dp[0]，而dp[1]显然为1，所以dp[0] = 1
public class TranslateNum_LCOF_46 {
    public int translateNum(int num) {
        char [] arr = String.valueOf(num).toCharArray();
        int len = arr.length;
        int [] dp = new int [len+1];
        dp[0] = 1;
        for(int i = 1; i <= len; i++){
            dp[i] += dp[i-1];
            if(i > 1){
                String str = String.valueOf(arr[i-2]) + String.valueOf(arr[i-1]);
                int combination = Integer.parseInt(str);
                if(combination >= 10 && combination <= 25){
                   dp[i] += dp[i-2];
                }
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        int num = 12258;
        int res = new TranslateNum_LCOF_46().translateNum(num);
        System.out.println(res);
    }
}
