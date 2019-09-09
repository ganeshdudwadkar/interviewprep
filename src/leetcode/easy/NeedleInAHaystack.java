package leetcode.easy;

// https://leetcode.com/problems/implement-strstr/

/*

28. Implement strStr()

Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1

What should we return when needle is an empty string? This is a great question to ask during an interview.

 */

public class NeedleInAHaystack {

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null){
            return -1;
        }
        if (haystack.equals(needle)){
            return 0;
        }
        int hLength = haystack.length();
        int nLength = needle.length();
        if (nLength == 0){
            return 0;
        }
        if (hLength == 0){
            return -1;
        }
        boolean found;
        for(int i = 0;i < hLength ;i++){
            if(haystack.charAt(i)==needle.charAt(0) && (hLength-i)>=nLength){
                //System.out.println("First char matched " + haystack.charAt(i) + " at " + i);
                found = true; // assumption
                for(int j=1;j<nLength;j++){
                    //System.out.println("Checking " + haystack.charAt(i+j) + " and " + needle.charAt(j));
                    if(haystack.charAt(i+j)!=needle.charAt(j)){
                        //System.out.println(haystack.charAt(i+j) + " and " + needle.charAt(j) + " not matching.. ");
                        found = false;
                        break;
                    }
                }
                if(found){
                    return i;
                }
            }
        }
        System.out.println("Reached end");
        return -1;
    }

    // Another elegant solution :
    public int strStrII(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }

    public int strStrIII(String haystack, String needle) {
        if(haystack==null || needle==null) return -1;
        int hlen = haystack.length();
        int nlen = needle.length();
        for(int i=0;i+nlen<=hlen;i++){
            if(haystack.substring(i,i+nlen).equals(needle))
                return i;
        }
        return -1;
    }

    public static void main(String[] args){

        NeedleInAHaystack obj = new NeedleInAHaystack();
        System.out.println(obj.strStr("StrStrrrrStrrrrrrr","Strrrrrr"));
        System.out.println(obj.strStrII("StrStrrrrStrrrrrrr","Strrrrrr1"));
        System.out.println(obj.strStrIII("StrStrrrrStrrrrrrr","Strrrrrr"));

//        Another simplest one liners :
//        return haystack.indexOf(needle);
//        return haystack.substring(needle);
    }
}
