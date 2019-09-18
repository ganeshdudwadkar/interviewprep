package leetcode.hard;

// https://leetcode.com/problems/word-squares/ - Locked

/*

425. Word Squares

Given a set of words (without duplicates), find all word squares you can build from them.

A sequence of words forms a valid word square if the kth row and column read the exact same string, where 0 ≤ k < max(numRows, numColumns).

For example, the word sequence ["ball","area","lead","lady"] forms a word square because each word reads the same both horizontally and vertically.

b a l l
a r e a
l e a d
l a d y

Note:

    There are at least 1 and at most 1000 words.
    All words will have the exact same length.
    Word length is at least 1 and at most 5.
    Each word contains only lowercase English alphabet a-z.

Example 1:

Input:
["area","lead","wall","lady","ball"]

Output:
[
  [ "wall",
    "area",
    "lead",
    "lady"
  ],
  [ "ball",
    "area",
    "lead",
    "lady"
  ]
]

Explanation:
The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).

Example 2:

Input:
["abat","baba","atan","atal"]

Output:
[
  [ "baba",
    "abat",
    "baba",
    "atan"
  ],
  [ "baba",
    "abat",
    "baba",
    "atal"
  ]
]

Explanation:
The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).

 */

import leetcode.medium.Trie;
import leetcode.medium.WordLadder;
import leetcode.medium.WordSearch;

import java.util.*;

public class WordSquares {

    public List<List<String>> wordSquares(String[] words) {
        // create a prefix map like Trie
        Map<String, List<String>> prefixMap = new HashMap<>();
        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                String prefix = word.substring(0, i);
                if (!prefixMap.containsKey(prefix)) prefixMap.put(prefix, new ArrayList<>());
                prefixMap.get(prefix).add(word);
            }
        }

        System.out.println(prefixMap);

        List<List<String>> resultList = new ArrayList<>();
        List<String> result = new ArrayList<>();

        // try each word now
        for (String word : words) {
            // System.out.println("Trying word " + word);
            result.add(word);
            find(resultList, 1, result, prefixMap);
            result.remove(word);
        }
        return resultList;
    }

    public void find(List<List<String>> resultList, int pos, List<String> result, Map<String, List<String>> map) {
        // found one valid word square when # of elements
        if (result.size() == result.get(0).length()) {
            resultList.add(new ArrayList<>(result));
            // System.out.println("Ans found: " + result);
            return;
        }

        String prefix = "";
        for (int i = 0; i < pos; i++) {
            prefix += result.get(i).charAt(pos);
        }
        // System.out.println("Looking for prefix " + prefix);
        if (!map.containsKey(prefix)) {
            return;
        }

        for (String word : map.get(prefix)) {
            result.add(word);
            find(resultList, pos + 1, result, map);
            result.remove(word);
        }
    }

    public static void main(String[] args){
        WordSquares obj = new WordSquares();
        String[] words = new String[]{"wall", "area", "lead", "lady", "ball"};
        String[] words2 = new String[]{"abat","baba","atan","atal"};

        System.out.println(obj.wordSquares(words));
        System.out.println(obj.wordSquares(words2));
        System.out.println(obj.wordSquares(new String[]{"xxxx"}));
    }
}
