package com.huang.solution;
/*50. Pow(x, n)
实现 pow(x, n) ，即计算 x 的 n 次幂函数。

示例 1:

输入: 2.00000, 10
输出: 1024.00000
示例 2:

输入: 2.10000, 3
输出: 9.26100
示例 3:

输入: 2.00000, -2
输出: 0.25000
解释: 2-2 = 1/22 = 1/4 = 0.25
说明:

-100.0 < x < 100.0
n 是 32 位有符号整数，其数值范围是 [−2^31, 2^31 − 1] 。
*/

import java.text.DecimalFormat;

// 这题每日一题出现好多次了。。。还是佩服一下大佬的思路 half * half * rest
public class MyPow_50 {
    public double myPow(double x, int n) {
        if(n == 1) return x;
        if(n == 0) return 1;
        if(n == -1) return 1/x;
        double half = myPow(x, n / 2);
        double rest = myPow(x, n % 2);
        return half * half * rest;
    }

    public static void main(String[] args) {
        double x = 2.00000;
        int n = -2;

        double ret = new MyPow_50().myPow(x,n);
        System.out.println(new DecimalFormat("0.00000").format(ret));
    }
}
