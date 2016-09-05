package leetcode._1sttime.no345;

/**
 * Whiteboard coding!
 */
public class Solution {
    private boolean isVowels(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }

    public String reverseVowels(String s) {
        char[] cs = s.toCharArray();
        int l = 0, r = cs.length-1;
        while (l < r) {
            while (l < r && !isVowels(cs[l]))
                l++;
            while (l < r && !isVowels(cs[r]))
                r--;
            if (l < r) {
                char tmp = cs[l];
                cs[l] = cs[r];
                cs[r] = tmp;
                l++;
                r--;
            }
        }

        return new String(cs);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.reverseVowels("hello"));
    }
}
