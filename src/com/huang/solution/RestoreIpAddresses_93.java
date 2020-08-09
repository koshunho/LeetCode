package com.huang.solution;

import java.util.ArrayList;
import java.util.List;

/*93. 复原IP地址
给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。

有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。



示例:

输入: "25525511135"
输出: ["255.255.11.135", "255.255.111.35"]*/
public class RestoreIpAddresses_93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();

        helper(s, "", list, 0, 0);

        return list;
    }

    private void helper(String s, String curString, List<String> list, int depth, int index){
        if(index > s.length()) return;

        if(depth == 4 && index == s.length()){
            list.add(curString);
            return;
        }

        for (int i = 1; i <= 3 && (index + i) <= s.length(); i++) {
            String str = s.substring(index, index + i);
            int num = Integer.parseInt(str);

            //判断前导0，比如.01.不允许
            if (str.equals(num + "") && num <= 255) {
                // 注意必须创建一个新的字符串出来！！
                String newCurString = curString.equals("") ? str : curString + "." + str;
                helper(s, newCurString, list, depth + 1, index + i);
            }
        }
    }


    public static void main(String[] args) {
        String s = "25525511135";

        List<String> strings = new RestoreIpAddresses_93().restoreIpAddresses(s);

        for (String string : strings) {
            System.out.println(string);
        }
    }
}
