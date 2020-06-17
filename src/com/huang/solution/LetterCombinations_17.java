package com.huang.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*17. 电话号码的字母组合
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。



示例:

输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
说明:
尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。

* */

// 用一个Map存储各个数字对字母的映射。
//
// 输入23，先截取2，然后获得abc。
// 遍历abc{
//     截取3...
//         }
public class LetterCombinations_17 {
    HashMap<String, String> hm = new HashMap(){{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    List <String> list = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        helper("", digits);
        return list;
    }

    private void helper(String combination, String nextDigits){
        if(nextDigits.length() == 0){
            list.add(combination);
            return;
        }

        String digit = nextDigits.substring(0,1);

        String letters = hm.get(digit);

        for(int i = 0; i < letters.length(); i++){
            String letter = letters.substring(i, i+1);
            helper(combination + letter, nextDigits.substring(1));
        }
    }

    public static void main(String[] args) {
        String digits = "23";

        List<String> strings = new LetterCombinations_17().letterCombinations(digits);

        String out = stringListToString(strings);

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
