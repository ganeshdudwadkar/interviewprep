package leetcode.medium;

// https://leetcode.com/problems/compare-version-numbers/

/*

Compare two version numbers version1 and version2.
If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.

Input: version1 = "0.1", version2 = "1.1"
Output: -1

Input: version1 = "1.0.1", version2 = "1"
Output: 1

 */

public class CompareVersionNumbers {

    public int compareVersionOld(String version1, String version2) {
        String[] v1 = version1.split("\\.", -1);
        String[] v2 = version2.split("\\.", -1);
        int left, right;
        int i = 0;
        for (; i < v1.length && i < v2.length; i++) {
            left = Integer.parseInt(v1[i]);
            right = Integer.parseInt(v2[i]);
            if (left > right) {
                return 1;
            } else if (left < right) {
                return -1;
            }
        }
        if (v1.length > v2.length) {
            //below loop to parse the remaining numbers of longer string
            for (; i < v1.length; i++) {
                left = Integer.parseInt(v1[i]);
                if (left > 0) {
                    return 1;
                }
            }
            return 0;//v1 with zero paddings
        } else if (v2.length > v1.length) {
            //below loop to parse the remaining numbers of longer string
            for (; i < v2.length; i++) {
                right = Integer.parseInt(v2[i]);
                if (right > 0) {
                    return -1;
                }
            }
            return 0;//v2 with zero paddings
        }
        return 0;//exact same inputs
    }

    public int compareVersion(String version1, String version2) {
        String[] levels1 = version1.split("\\.");
        String[] levels2 = version2.split("\\.");

        int length = Math.max(levels1.length, levels2.length);
        for (int i = 0; i < length; i++) {
            Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
            Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
            int compare = v1.compareTo(v2);
            if (compare != 0) {
                return compare;
            }
        }

        return 0;
    }

    public static void main(String[] args){

        CompareVersionNumbers obj = new CompareVersionNumbers();
        System.out.println(obj.compareVersion("0.1", "1.1"));
        System.out.println(obj.compareVersion("1.0.1", "1"));
        System.out.println(obj.compareVersion("1.0.1.5", "1.0.1.5"));
    }

}
