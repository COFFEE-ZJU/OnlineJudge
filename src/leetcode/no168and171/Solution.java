package leetcode.no168and171;

public class Solution {
    public String convertToTitle(int n) {
        if (n <= 0) return "";
        StringBuilder sb = new StringBuilder();
        do {
            int rem = n % 26;
            if (rem == 0) {
                n--;
                rem = 26;
            }
            sb.insert(0, (char)(rem - 1 + 'A'));
            n /= 26;
        } while (n != 0);
        return sb.toString();
    }

    public int titleToNumber(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int res = 0;
        for (char c : s.toCharArray())
            res = res * 26 + (c-'A'+1);
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.convertToTitle(1));
        System.out.println(sol.convertToTitle(25));
        System.out.println(sol.convertToTitle(26));
        System.out.println(sol.convertToTitle(27));
        System.out.println(sol.convertToTitle(52));
        System.out.println(sol.convertToTitle(53));
    }
}