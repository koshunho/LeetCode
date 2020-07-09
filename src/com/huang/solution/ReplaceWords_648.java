package com.huang.solution;

import java.util.Arrays;
import java.util.List;

/*648. 单词替换
* 在英语中，我们有一个叫做 词根(root)的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。

现在，给定一个由许多词根组成的词典和一个句子。你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。

你需要输出替换之后的句子。

 

示例：

输入：dict(词典) = ["cat", "bat", "rat"] sentence(句子) = "the cattle was rattled by the battery"
输出："the cat was rat by the bat"
 

提示：

输入只包含小写字母。
1 <= dict.length <= 1000
1 <= dict[i].length <= 100
1 <= 句中词语数 <= 1000
1 <= 句中词语长度 <= 1000
*/

// 前缀树
public class ReplaceWords_648 {
    public String replaceWords(List<String> dict, String sentence) {
        Trie_648 trie = new Trie_648();

        for(int i = 0; i < dict.size(); i++){
            trie.insert(dict.get(i));
        }

        String [] split = sentence.split(" ");

        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < split.length; i++){
            sb.append(trie.startsWith(split[i]) + " ");
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String [] strs = new String [] {"cat","bat","rat"};

        List<String> dict = Arrays.asList(strs);

        String sentence = "the cattle was rattled by the battery";

        String s = new ReplaceWords_648().replaceWords(dict, sentence);

        System.out.println(s);
    }
}

class Trie_648{
    TrieNode_648 root;

    public Trie_648(){
        root = new TrieNode_648();
    }

    public void insert(String word){
        TrieNode_648 cur = root;
        for(int i = 0; i < word.length(); i++){
            int c = word.charAt(i) - 'a';
            if(cur.children[c] == null){
                cur.children[c] = new TrieNode_648();
            }
            cur = cur.children[c];
        }
        cur.isEnd = true;
    }

    public String startsWith(String word){
        TrieNode_648 cur = root;
        for(int i = 0; i < word.length(); i++){
            int c = word.charAt(i) - 'a';

            // 要先判断是否为空！！！
            if(cur.children[c] == null) return word;

            if(cur.children[c].isEnd == true){
                return word.substring(0, i+1);
            }
            cur = cur.children[c];
        }
        return word;
    }
}

class TrieNode_648{
    char val;

    TrieNode_648 [] children = new TrieNode_648[26];

    boolean isEnd;

    public TrieNode_648(){}
}
