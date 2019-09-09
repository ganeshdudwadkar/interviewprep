package leetcode.medium;

// - https://leetcode.com/problems/implement-trie-prefix-tree/

/*

Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.

 */

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> hm;
    boolean isEnd;

    // Initialize your data structure here.
    public TrieNode() {
        hm = new HashMap<>();
        isEnd = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode iter = root;
        for (char c : word.toCharArray()) {
            if (!iter.hm.containsKey(c)) {
                iter.hm.put(c, new TrieNode());
            }
            iter = iter.hm.get(c);
        }
        iter.isEnd = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode iter = root;
        for (char c : word.toCharArray()) {
            if (!iter.hm.containsKey(c)) {
                return false;
            }
            iter = iter.hm.get(c);
        }
        return iter.isEnd;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode iter = root;
        for (char c : prefix.toCharArray()) {
            if (!iter.hm.containsKey(c)) {
                return false;
            }
            iter = iter.hm.get(c);
        }
        return true;
    }

    public static void main(String[] args){

        Trie trie = new Trie();

        trie.insert("apple");
        trie.search("apple");   // returns true
        trie.search("app");     // returns false
        trie.startsWith("app"); // returns true
        trie.insert("app");
        trie.search("app");     // returns true

    }
}
