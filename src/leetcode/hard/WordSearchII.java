package leetcode.hard;

// https://leetcode.com/problems/word-search-ii/

/*

212. Word Search II

Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.



Example:

Input:
board = [
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
words = ["oath","pea","eat","rain"]

Output: ["eat","oath"]

 */

// This is a purely DFS solution and accepted by leetcode.
// Some folks have solved it using Trie + DFS. Try that!

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> exists = new ArrayList<>();
        for (String word : words) {
            if (exists(board, word)) {
                exists.add(word);
            }
        }
        return exists;
    }

    public boolean exists(char[][] board, String word) {
        boolean ans;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    ans = checkString(board, i, j, word, 1, visited);
                    if (ans) {
                        return true;
                    } else {
                        visited[i][j] = false;
                    }
                }
            }
        }
        return false;
    }

    private boolean checkString(char[][] board, int i, int j, String word, int index, boolean[][] visited) {
        //System.out.println("Checking for String " + word + " at index a["+i+"]["+j+"]");
        if (word.length() == index) return true;
        boolean res;
        if (i < board.length - 1 && !visited[i + 1][j] && board[i + 1][j] == word.charAt(index)) {
            visited[i + 1][j] = true;
            res = checkString(board, i + 1, j, word, index + 1, visited);
            if (res) {
                return true;
            } else {
                visited[i + 1][j] = false;
            }
        }
        if (i > 0 && !visited[i - 1][j] && board[i - 1][j] == word.charAt(index)) {
            visited[i - 1][j] = true;
            res = checkString(board, i - 1, j, word, index + 1, visited);
            if (res) {
                return true;
            } else {
                visited[i - 1][j] = false;
            }
        }
        if (j < board[0].length - 1 && !visited[i][j + 1] && board[i][j + 1] == word.charAt(index)) {
            visited[i][j + 1] = true;
            res = checkString(board, i, j + 1, word, index + 1, visited);
            if (res) {
                return true;
            } else {
                visited[i][j + 1] = false;
            }
        }
        if (j > 0 && !visited[i][j - 1] && board[i][j - 1] == word.charAt(index)) {
            visited[i][j - 1] = true;
            res = checkString(board, i, j - 1, word, index + 1, visited);
            if (res) {
                return true;
            } else {
                visited[i][j - 1] = false;
            }
        }
        return false;
    }
}
