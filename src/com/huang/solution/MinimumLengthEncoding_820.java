package com.huang.solution;

import java.util.Arrays;

/*820. 单词的压缩编码
* 给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。

例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。

对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。

那么成功对给定单词列表进行编码的最小字符串长度是多少呢？

 

示例：

输入: words = ["time", "me", "bell"]
输出: 10
说明: S = "time#bell#" ， indexes = [0, 2, 5] 。
 

提示：

1 <= words.length <= 2000
1 <= words[i].length <= 7
每个单词都是小写字母。*/

// 根据字符串长度降序排列，用indexOf()判断下一个字符串在不在就行
public class MinimumLengthEncoding_820 {
    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, (o1, o2) -> o2.length() - o1.length());
        StringBuffer sb = new StringBuffer(words[0] + "#");
        for(int i = 1; i < words.length; i++){
            if(sb.indexOf(words[i]) == -1){
                sb.append(words[i] + "#");
            }
        }
        return sb.length();
    }

    public static void main(String[] args) {
        String [] words = new String[]{"time", "me", "bell"};

        int i = new MinimumLengthEncoding_820().minimumLengthEncoding(words);

        System.out.println(i);
    }
}
