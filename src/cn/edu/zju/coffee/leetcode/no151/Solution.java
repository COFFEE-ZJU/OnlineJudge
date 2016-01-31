package cn.edu.zju.coffee.leetcode.no151;

public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0)
            return s;

        String[] ss = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (String wd : ss){
            if (wd.length() == 0) continue;
            sb.insert(0, wd);
            sb.insert(0, ' ');
        }

        if (sb.length() == 0) return "";
        return sb.substring(1);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.reverseWords("  23   3 "));
    }
}
