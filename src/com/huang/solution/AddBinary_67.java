package com.huang.solution;
/*67. 二进制求和
给你两个二进制字符串，返回它们的和（用二进制表示）。

输入为 非空 字符串且只包含数字 1 和 0。

 

示例 1:

输入: a = "11", b = "1"
输出: "100"
示例 2:

输入: a = "1010", b = "1011"
输出: "10101"
 

提示：

每个字符串仅由字符 '0' 或 '1' 组成。
1 <= a.length, b.length <= 10^4
字符串如果不是 "0" ，就都不含前导零。

。*/
public class AddBinary_67 {
    //第一反应就是调用API。先将a和b转换成十进制相加后，再输出和的二进制
    public String addBinary1(String a, String b) {
        int sum = Integer.valueOf(a,2) + Integer.valueOf(b,2);

        return Integer.toBinaryString(sum);
    }

    //上面的方法肯定不能AC。。。输入一个超长的字符串就不行了。想办法模拟这个过程
    public String addBinary2(String a, String b) {
        StringBuffer sb = new StringBuffer();

        int ca = 0; //进位

        for(int i = a.length()-1, j = b.length()-1; i >= 0 || j >= 0; i--, j--){
            int curSum = ca; //！！！！别忘记要初始化为上一次的进位！！！！！
            curSum += i >= 0 ? a.charAt(i) - '0' : 0;
            curSum += j >= 0 ? b.charAt(j) - '0' : 0;
            sb.append(curSum % 2);
            ca = curSum / 2;
        }
        sb.append(ca == 1 ? ca : "");

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "1010", b = "1011";

        String ret = new AddBinary_67().addBinary2(a,b);

        System.out.println(ret);
    }
}
