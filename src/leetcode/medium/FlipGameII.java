package leetcode.medium;

// Flip Game 2 (LC # 294) - Locked

import java.util.ArrayList;
import java.util.List;

public class FlipGameII {

    public boolean canWin(String s) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) == '+' && s.charAt(i + 1) == '+')
                list.add(s.substring(0, i) + "--" + s.substring(i + 2, s.length()));         // generate all possible sequence after every attempt
        }

        for(String str : list){
            if(!canWin(str))             // if there is any one way the next player can't win, take it and you'll win
                return true;
        }
        return false;
    }

}
