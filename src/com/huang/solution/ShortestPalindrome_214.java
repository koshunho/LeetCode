package com.huang.solution;
/*214. 最短回文串
给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。

示例 1:

输入: "aacecaaa"
输出: "aaacecaaa"
示例 2:

输入: "abcd"
输出: "dcbabcd"
*/

// 这个最后一个测试用例过不了- - 面向测试用例编程
// 首先注意前提条件：字符串 前 面 添加字符
// 找到源字符串第一个字符为起始的最长的回文串后，然后截取掉剩余部分，reverse，然后拼接在原字符串的开头。
// 比如abbacd,下标为0开始的最长的子串是abba，那么截取cd，翻转成dc，拼接在开头，就是dcabbacd
// 比如abcd，下标为0开始的最长的子串是a，那么截取bcd，翻转成dcb，拼接在开头，就是dcbabcd
public class ShortestPalindrome_214 {
    public String shortestPalindrome(String s) {
        int len = s.length();

        if(len == 0 || isPalindrome(s)) return s;

        int index = -1, longestPalindromeLen = 1;

        for(int r = 0; r < len; r++){
            if(isPalindrome(s.substring(0, r)) && r + 1 > longestPalindromeLen){
                longestPalindromeLen = r + 1;
                index = r;
            }
        }
        String extra = s.substring(index, len);

        return new StringBuffer(extra).reverse().toString() + s;
    }

    private boolean isPalindrome(String s){
        int len = s.length();

        if(len == 0) return false;

        boolean [][] dp = new boolean[len][len];

        for(int r = 0; r < len; r++){
            for(int l = 0; l <= r; l++){
                if(s.charAt(r) == s.charAt(l) && (r - l <= 2 || dp[l+1][r-1])){
                    dp[l][r] = true;
                }
            }
        }
        return dp[0][len-1];
    }

    public static void main(String[] args) {
        String s = new ShortestPalindrome_214().shortestPalindrome("addadda");

        System.out.println(s);
    }
}
