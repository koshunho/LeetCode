package com.huang.solution;

import java.util.Arrays;

/*820. 单词的压缩编码*/
// 前缀树
public class MinimumLengthEncoding_820_Trie {
    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, (o1, o2) -> o2.length() - o1.length());

        int len = 0;

        Trie trie = new Trie();

        for (String word : words) {
            len += trie.insert(word);
        }

        return len;
    }

    private class Trie{
        TrieNode root;

        public Trie(){
            root = new TrieNode();
        }

        // 其实这是后缀树
        public int insert(String word){
            TrieNode cur = root;
            boolean isNew = false;

            for(int i = word.length()-1; i >= 0; i--){
                int c = word.charAt(i) - 'a';
                if(cur.children[c] == null){
                    isNew = true;
                    cur.children[c] = new TrieNode();
                }
                cur = cur.children[c];
            }
            return isNew == true ? word.length()+1 : 0;
        }

    }

    private class TrieNode{
        char val;

        TrieNode[] children = new TrieNode[26];

        public TrieNode(){}
    }

    public static void main(String[] args) {
        String [] words = new String[]{"time", "me", "bell"};

        int i = new MinimumLengthEncoding_820_Trie().minimumLengthEncoding(words);

        System.out.println(i);
    }
}
