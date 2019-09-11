package leetcode.medium;

// One Edit Distance

/*


 */

public class OneEditDistance {

    public boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null || s.equals(t)) {
            return false;
        }
        int sLen = s.length();
        int tLen = t.length();
        if (sLen < tLen) {
            return isOneEditDistance(t, s);
        }
        if (sLen - tLen > 1) {
            return false;
        }

        String newS;
        if (sLen - tLen == 1) {  // handle case like test1, test || tes1t,test
            for (int i = 0; i < sLen; i++) {
                newS = s.substring(0, i) + s.substring(i + 1, sLen);
                if (newS.equals(t)) {
                    return true;
                }
            }
            return false;
        }

        String newT;
        if (sLen == tLen) { // handle case like test,tedt
            for (int i = 0; i < sLen; i++) {
                newS = s.substring(0, i) + s.substring(i + 1, sLen);
                newT = t.substring(0, i) + t.substring(i + 1, sLen);
                if (newS.equals(newT)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args){

        OneEditDistance obj = new OneEditDistance();
        System.out.println(obj.isOneEditDistance("test", "best"));
        System.out.println(obj.isOneEditDistance("tear", "ear"));
        System.out.println(obj.isOneEditDistance("near", "neard"));
        System.out.println(obj.isOneEditDistance("near", "deary"));
    }
}
