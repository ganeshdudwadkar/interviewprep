package interviews;

/*

Input :- "1?" Output => ["10" ,"11"]
Input :- "1?0" Output => ["100" ,"110"]
Input :- "1?1?" Output => ["1010" ,"1011", "1110", "1111"]

 */

import java.util.ArrayList;
import java.util.List;

public class StringCombinations {

    public List<String> getCombinations(String s) {
        // System.out.println("Processing " + s);
        List<String> ls = new ArrayList<>();
        if (s.length() == 0) {
            ls.add(s); // must return empty string as a combination otherwise it doesn't work
            return ls;
        }

        // find first occurrence of ?
        int i = s.indexOf('?'); // returns negative number if char not found
        if (i < 0) {
            ls.add(s);
            return ls;
        }

        List<String> subLs = getCombinations(s.substring(i + 1));
        for (String sub : subLs) {
            ls.add(s.substring(0, i) + "0" + sub);
            ls.add(s.substring(0, i) + "1" + sub);
        }

        return ls;
    }

    public static void main(String[] args) {

        System.out.println(new StringCombinations().getCombinations("1?1?"));
        System.out.println(new StringCombinations().getCombinations("1?1?0?1????"));

    }
}
