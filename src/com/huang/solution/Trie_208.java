package com.huang.solution;

/*208. 实现 Trie (前缀树)
*
实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。

示例:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // 返回 true
trie.search("app");     // 返回 false
trie.startsWith("app"); // 返回 true
trie.insert("app");
trie.search("app");     // 返回 true
说明:

你可以假设所有的输入都是由小写字母 a-z 构成的。
保证所有输入均为非空字符串。
*
* /**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
public class Trie_208 {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}

class Trie {

    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;

        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if(cur.children[c] == null){
                cur.children[c] = new TrieNode();
            }
            cur = cur.children[c];
        }
        // 关键，要清楚知道cur指的是什么
        cur.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;

        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if(cur.children[c] == null){
                return false;
            }
            cur = cur.children[c];
        }
        return cur.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;

        for (int i = 0; i < prefix.length(); i++) {
            int c = prefix.charAt(i) - 'a';
            if(cur.children[c] == null){
                return false;
            }
            cur = cur.children[c];
        }
        return true;
    }
}

class TrieNode {
    char val;

    //判断当前TrieNode是否是一个词的结尾
    boolean isEnd;

    TrieNode [] children = new TrieNode[26];

    public TrieNode(){}
}