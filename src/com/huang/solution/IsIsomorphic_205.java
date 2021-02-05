package com.huang.solution;

import java.util.HashMap;
import java.util.Map;

/*给定两个字符串s和t，判断它们是否是同构的。

如果s中的字符可以被替换得到t，那么这两个字符串是同构的。

所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。

示例 1:

输入: s = "egg", t = "add"
输出: true
示例 2:

输入: s = "foo", t = "bar"
输出: false
示例 3:

输入: s = "paper", t = "title"
输出: true
说明:
你可以假设 s 和 t 具有相同的长度。

*/
public class IsIsomorphic_205 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> hm1 = new HashMap<>();
        Map<Character, Character> hm2 = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char key = s.charAt(i), value = t.charAt(i);
            if(hm1.containsKey(key) && hm1.get(key).equals(value) && hm2.containsKey(value) && hm2.get(value).equals(key)) continue;
            if((hm1.containsKey(key) && !hm1.get(key).equals(value)) || (hm2.containsKey(value) && !hm2.get(value).equals(key))) return false;
            hm1.put(key, value);
            hm2.put(value, key);
        }
        return true;
    }
}
