package leetcode.medium;

// https://leetcode.com/problems/add-and-search-word-data-structure-design/

/*

Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

Example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true

Note:
You may assume that all words are consist of lowercase letters a-z.

 */

import java.util.HashMap;
import java.util.Map;

// My Solution : (Beats 0.34% java submissions - almost TLE)
public class AddAndSearchWord {

    class TrieNode {
        Map<Character,TrieNode> hm;
        boolean isEnd;
        // Initialize your data structure here.
        public TrieNode() {
            hm = new HashMap<>();
            isEnd = false;
        }
    }

    private TrieNode root;

    public AddAndSearchWord() {
        root = new TrieNode();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode iter = root;
        for(char c : word.toCharArray()){
            if(!iter.hm.containsKey(c)){
                iter.hm.put(c,new TrieNode());
            }
            iter = iter.hm.get(c);
        }
        iter.isEnd = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(word,root);
    }

    public boolean search(String word, TrieNode root) {
        if(root == null) { // reached the leafNode where hm is empty?
            return false;
        }
        TrieNode iter = root;
        //System.out.println("Searching " + word);
        if(word.length() == 0){
            return iter.isEnd;
        }
        char[] w = word.toCharArray();
        for(int i=0;i<w.length;i++){
            if(w[i] == '.'){
                boolean res = false;
                for(char c : iter.hm.keySet()){
                    res = search(word.substring(i+1),iter.hm.get(c)); //DFS search
                    if(res) {
                        return true;
                    }
                }
            }
            if(!iter.hm.containsKey(w[i])){
                return false;
            }
            iter = iter.hm.get(w[i]);
        }
        return iter.isEnd;
    }

    public static void main(String[] args){

        AddAndSearchWord obj = new AddAndSearchWord();
        obj.addWord("bad");
        obj.addWord("dad");
        obj.addWord("mad");
        System.out.println(obj.search("pad"));
        System.out.println(obj.search("bad"));
        System.out.println(obj.search(".ad"));
        System.out.println(obj.search("b.."));
    }
}
    /*

    Alternative fast Solution ->

    public class WordDictionary {
        Map<Integer, List<String>> map = new HashMap<>();

        public void addWord(String word) {
            int index = word.length();
            if (!map.containsKey(index)) {
                List<String> list = new ArrayList<>();
                list.add(word);
                map.put(index, list);
            } else {
                map.get(index).add(word);
            }
        }

        public boolean search(String word) {
            int index = word.length();
            if (!map.containsKey(index)) {
                return false;
            }

            List<String> list = map.get(index);
            for(String s : list) {
                if(isSame(s, word)) { // when word has '.'
                    return true;
                }
            }
            return false;
        }

        public boolean isSame(String s, String word) { // word has '.'
            for (int i = 0; i < s.length(); i++) {
                if (word.charAt(i) != '.' && s.charAt(i) != word.charAt(i)) {
                    return false;
                }
            }
            return true;
        }
    }
     */

