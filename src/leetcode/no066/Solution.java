package leetcode.no066;

public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) return digits;
        int carry = 1;
        for (int i = digits.length-1; i >= 0 ; i--) {
            if (carry == 0) break;
            digits[i] ++;
            carry = digits[i] / 10;
            digits[i] %= 10;
        }
        if (carry == 1) {
            int[] res = new int[digits.length+1];
            res[0] = 1;
            return res;
        }
        else
            return digits;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
    }
}
