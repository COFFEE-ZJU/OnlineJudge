package leetcode._1sttime.no165;

public class Solution {
    public int compareVersion(String version1, String version2) {
        if (version1 == null || version2 == null ||
                version1.length() == 0 || version2.length() == 0)
            return 0;

        String[] vs1 = version1.split("\\."),
                vs2 = version2.split("\\.");
        int len1 = vs1.length, len2 = vs2.length;
        int i = 0;
        for (; ; i++) {
            if (i == len1 || i == len2)
                break;

            int i1 = Integer.parseInt(vs1[i]),
                    i2 = Integer.parseInt(vs2[i]);
            if (i1 > i2)
                return 1;
            else if (i1 < i2)
                return -1;
        }
        if (len1 == len2)
            return 0;

        if (i == len1){
            for (; i < len2; i++){
                if (Integer.parseInt(vs2[i]) != 0)
                    return -1;
            }
            return 0;
        }
        else {
            for (; i < len1; i++){
                if (Integer.parseInt(vs1[i]) != 0)
                    return 1;
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.compareVersion("1", "1.0"));
        System.out.println(sol.compareVersion("1", "1.1"));
    }
}
