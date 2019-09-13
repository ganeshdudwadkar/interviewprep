package leetcode.medium;

// https://leetcode.com/problems/word-ladder/

/*
127. Word Ladder

Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        Set<String> reached = new HashSet<>();
        reached.add(beginWord);
        wordDict.add(endWord);
        int distance = 1;
        while(!reached.contains(endWord)) {
            Set<String> toAdd = new HashSet<>();
            for(String each : reached) {
                for (int i = 0; i < each.length(); i++) {
                    char[] chars = each.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String word = new String(chars);
                        if(wordDict.contains(word)) {
                            toAdd.add(word);
                            wordDict.remove(word);
                        }
                    }
                }
            }
            distance ++;
            if(toAdd.size() == 0) return 0; //not possible to reach
            reached = toAdd;
        }
        return distance;

        /*

        Basically I keep two sets of words, one set reached that represents the borders that have been reached with "distance" steps;
        another set wordDict that has not been reached. In the while loop, for each word in the reached set, I give all variations and
        check if it matches anything from wordDict, if it has a match, I add that word into toAdd set, which will be my "reached" set
        in the next loop, and remove the word from wordDict because I already reached it in this step. And at the end of while loop,
        I check the size of toAdd, which means that if I can't reach any new String from wordDict, I won't be able to reach the endWord,
        then just return 0. Finally if the endWord is in reached set, I return the current steps "distance".

        The idea is that reached always contain only the ones we just reached in the last step, and wordDict always contain the ones
        that haven't been reached. This is pretty much what Dijkstra's algorithm does, or you can see this as some variation of BFS.
         */
    }

    public static void main(String[] args){
        String[] wordList = {"hot","dot","dog","lot","log","cog"};
        Set<String> wordDict = new HashSet<>(Arrays.asList(wordList));
        WordLadder obj = new WordLadder();
        System.out.println(obj.ladderLength("hit","cog", wordDict));
        System.out.println(obj.ladderLength("hot","cop", wordDict));

    }
}
