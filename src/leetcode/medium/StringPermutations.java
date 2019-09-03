package leetcode.medium;

// Unable to find leetcode Q
// This one is for non repeating chars

import java.util.*;

public class StringPermutations {

    public List<String> getAllPerms(String s) {
        //System.out.println("Processing "+s);
        int len = s.length();
        if (len == 1) {
            return Arrays.asList(s);
        }
        char c = s.charAt(0);
        List<String> returnList = new ArrayList<>();
        List<String> remaining = getAllPerms(s.substring(1));
        for (String perm : remaining) {
            for (int i = 0; i < len; i++) {
                returnList.add(perm.substring(0, i) + c + perm.substring(i));
            }
        }
        //System.out.println("Return List for " + s + " is " + returnList);
        return returnList;
    }

    // Using Set
    public Set<String> getAllPermutations(String s) {
        int len = s.length();
        if (len == 1) {
            Set<String> single = new HashSet<>();
            single.add(s);
            return single;
        }
        char c = s.charAt(0);
        Set<String> returnSet = new HashSet<String>();
        Set<String> remaining = getAllPermutations(s.substring(1));
        for (String perm : remaining) {
            for (int i = 0; i < len; i++) {
                returnSet.add(perm.substring(0, i) + c + perm.substring(i));
            }
        }
        return returnSet;
    }

    public static void main(String[] args) {

        StringPermutations obj = new StringPermutations();
        System.out.println(obj.getAllPerms("abc"));
        System.out.println(obj.getAllPerms("abcd"));
    }
}
