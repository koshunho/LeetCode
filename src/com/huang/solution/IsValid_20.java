package com.huang.solution;

import java.util.HashMap;
import java.util.Stack;

/*20. 有效的括号
* 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true
* */

// 让左括号入栈。
// 遇到右括号的时候，弹出栈顶元素，看看是不是和当前的右括号成对
public class IsValid_20 {
    public boolean isValid(String s) {
        HashMap <Character,Character> hm = new HashMap(){{
            put(')','(');
            put(']','[');
            put('}','{');
        }};

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(!hm.containsKey(c)){
                stack.push(c);
            }
            else{
                char topElement = stack.isEmpty()? '*' : stack.pop();
                if(topElement != hm.get(c)) return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(}";
        String s4 = "([)]";
        String s5 = "{[]}";

        IsValid_20 isValid_20 = new IsValid_20();

        boolean b1 = isValid_20.isValid(s1);
        boolean b2 = isValid_20.isValid(s2);
        boolean b3 = isValid_20.isValid(s3);
        boolean b4 = isValid_20.isValid(s4);
        boolean b5 = isValid_20.isValid(s5);

        System.out.println(b1 + " " + b2 + " " + b3 + " " + b4 + " " + b5);
    }

}
