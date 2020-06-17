package com.huang.solution;
/*5. 最长回文子串
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"
*/

// new boolean [len+1][len+1] 是因为要记录的是下标
// for循环中，先r 再 l
// 判断当前字符串是否是回文： 先两个字符是否相同，再看 这个子串首位下标之差是否<=2 ，也就是长度是否<=3（长度为1的话，就是一个字符，当然是回文；长度为2，因为首尾相同，是回文；长度为3，首尾相同，中间剩下一个字符，整体也是回文），如果是 直接为true。
// 如果长度 >3的话，则判断dp[l+1][r-1]是否是回文
public class LongestPalindrome_5 {
    public String longestPalindrome(String s){
        int len = s.length();
        if(len == 0) return "";

        boolean [][] dp = new boolean [len+1][len+1];

        int maxLen = 1;
        String str = s.substring(0,1);

        for(int r = 0; r < len; r++){
            for(int l = 0; l <= r; l++){
                if(s.charAt(r) == s.charAt(l) && (r - l <= 2 || dp[l+1][r-1])){
                    dp[l][r] = true;
                    if(r - l + 1 > maxLen){
                        maxLen = r - l + 1;
                        str = s.substring(l, l + maxLen);
                    }
                }
            }
        }
        return str;
    }

    public static void main(String[] args) {
        String s = "wocaonimalegebixixixixxixihahahahawawawafuckyou";

        String ret = new LongestPalindrome_5().longestPalindrome(s);

        System.out.println(ret);
    }
}
