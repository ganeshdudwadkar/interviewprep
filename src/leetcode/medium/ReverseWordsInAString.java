package leetcode.medium;

// https://leetcode.com/problems/reverse-words-in-a-string/

/*

Given an input string, reverse the string word by word.

Example 1:

Input: "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: "  hello world!  "
Output: "world! hello"
Explanation: Your reversed string should not contain leading or trailing spaces.

 */

public class ReverseWordsInAString {

    public String reverseWords(String s) {
        String[] parts = s.trim().split("\\s+");
        String out = "";
        for (int i = parts.length - 1; i > 0; i--) {
            out += parts[i] + " ";
        }
        return out + parts[0];
    }

    public String reverseWordsOptimized(String s) {
        StringBuilder res = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if (s.charAt(i) == ' '){
                if(res.length()>0 && temp.length()>0){
                    res.insert(0," ");
                }
                if(temp.length()>0){
                    res.insert(0,temp);
                    temp.delete(0,temp.length()); // cleanup temp
                }
            } else {
                temp.append(s.charAt(i));
            }
        }
        if(res.length()>0 && temp.length()>0){
            res.insert(0," ");
            res.insert(0,temp);
        } else {
            res.insert(0,temp);
        }

        return res.toString();
    }

    // Another best solution : Could you do it in-place without allocating extra space?
    // First, reverse the whole string, then reverse each word.

    public String reverseWordsBest(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        // split to words by space
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; --i) {
            if (!arr[i].equals("")) {
                sb.append(arr[i]).append(" ");
            }
        }
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }

    // If we know for sure there is only one space as delimeter then use below :

    public String reverseWordsAlternate(String str) {
        char[] s = str.toCharArray();
        int i=0;
        for(int j=0; j<s.length; j++){
            if(s[j]==' '){
                reverse(s, i, j-1);
                i=j+1;
            }
        }

        reverse(s, i, s.length-1); // for last word

        reverse(s, 0, s.length-1);
        return new String(s);
    }

    private void reverse(char[] s, int i, int j){
        while(i<j){
            char temp = s[i];
            s[i]=s[j];
            s[j]=temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {

        ReverseWordsInAString example = new ReverseWordsInAString();
        System.out.println(example.reverseWords("the sky is blue"));
        System.out.println(example.reverseWordsOptimized("  hello world!  "));
        System.out.println(example.reverseWordsAlternate("the sky is blue"));
        System.out.println(example.reverseWordsBest("  hello world!  "));
    }
}
