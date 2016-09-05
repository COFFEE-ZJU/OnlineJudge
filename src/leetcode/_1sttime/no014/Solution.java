package leetcode._1sttime.no014;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        for (int i = 0; ; i++) {
            if (i >= strs[0].length()) return strs[0].substring(0, i);
            char c = strs[0].charAt(i);
            for (String str : strs)
                if (i >= str.length() || c != str.charAt(i)) return str.substring(0, i);
        }
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
    }
}
