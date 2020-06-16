package com.huang.solution;

import java.util.ArrayList;
import java.util.List;

/*
* 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

 

示例：

输入：n = 3
输出：[
       "((()))",
       "(()())",
       "(())()",
       "()(())",
       "()()()"
     ]
*/
public class GenerateParenthesis_22 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if(n == 0) return list;
        helper(list, n, n, "");
        return list;
    }
    private void helper(List<String> list, int left, int right, String str){
        if(left == 0 && right == 0) list.add(str);

        if(left > right) return; //*

        if(left > 0){
            helper(list, left-1, right, str + "(");
        }

        if(right > 0){
            helper(list, left, right-1, str + ")");
        }
    }

    public static void main(String[] args) {
        List <String> ret = new GenerateParenthesis_22().generateParenthesis(3);

        String out = stringListToString(ret);

        System.out.println(out);
    }

    public static String stringListToString(List<String> stringList) {
        StringBuilder sb = new StringBuilder("[");
        for (String item : stringList) {
            sb.append(item);
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }
}
