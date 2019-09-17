package leetcode.medium;

// - https://leetcode.com/problems/word-search/

/*

79. Word Search

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.

 */

public class WordSearch {

    public boolean exist(char[][] board, String word) {
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

    public static void main(String[] args) {

        char[][] board = {
                {'A', 'B', 'C', 'E' },
                {'S', 'F', 'C', 'S' },
                {'A', 'D', 'E', 'E' }
        };

        WordSearch obj = new WordSearch();

        System.out.println(obj.exist(board, "ABCCED"));
        System.out.println(obj.exist(board, "SEE"));
        System.out.println(obj.exist(board, "ABCB"));
        System.out.println(obj.exist(board, "ASADFBCCEESE"));

    }
}
