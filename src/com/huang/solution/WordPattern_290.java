package com.huang.solution;

import java.util.HashMap;
import java.util.Map;

/*290. 单词规律
给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。

这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。

示例1:

输入: pattern = "abba", str = "dog cat cat dog"
输出: true
示例 2:

输入:pattern = "abba", str = "dog cat cat fish"
输出: false
示例 3:

输入: pattern = "aaaa", str = "dog cat cat dog"
输出: false
示例 4:

输入: pattern = "abba", str = "dog dog dog dog"
输出: false
说明:
你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。*/
public class WordPattern_290 {
    public boolean wordPattern(String pattern, String s) {
        Map<String, Character> hm = new HashMap<>();
        Map<Character, String> hm1 = new HashMap<>();
        String[] arr = s.split(" ");
        if(pattern.length() != arr.length) return false;
        for (int i = 0; i < arr.length; i++) {
            if(!hm.containsKey(arr[i])){
                hm.put(arr[i], pattern.charAt(i));
                continue;
            }
            if(!hm.get(arr[i]).equals(pattern.charAt(i))) return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String str = arr[i];
            if(!hm1.containsKey(c)){
                hm1.put(c, str);
                continue;
            }
            if(!hm1.get(c).equals(str)) return false;
        }
        return true;
    }
}
