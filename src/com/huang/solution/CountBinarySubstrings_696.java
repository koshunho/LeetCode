package com.huang.solution;
/*696. 计数二进制子串
给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。

重复出现的子串要计算它们出现的次数。

示例 1 :

输入: "00110011"
输出: 6
解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。

请注意，一些重复出现的子串要计算它们出现的次数。

另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
示例 2 :

输入: "10101"
输出: 4
解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
注意：

s.length 在1到50,000之间。
s 只包含“0”或“1”字符。
*/

import java.util.ArrayList;
import java.util.List;

// 其实并不简单，代码写出来容易，思路并不容易想到。（这题的官方题解很好）
public class CountBinarySubstrings_696 {
    public int countBinarySubstrings(String s) {
        List<Integer> list = new ArrayList<>();

        // 注意不用i++了，下面i = index 已经确定下次开始的下标了
        for(int i = 0; i < s.length();){
            char c = s.charAt(i);
            int index = i, count = 0;
            while(index < s.length() && s.charAt(index) == c){
                count++;
                index++;
            }
            i = index;
            list.add(count);
        }

        int ans = 0;

        for(int i = 1; i < list.size(); i++){
            ans += Math.min(list.get(i), list.get(i-1));
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "00110011";

        int i = new CountBinarySubstrings_696().countBinarySubstrings(s);

        System.out.println(i);
    }
}
