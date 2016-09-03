package leetcode._2ndtime.no338;

/**
 * Whiteboard coding!
 */
public class Solution {
    public int[] countBits(int num) {
        if (num < 0) return null;
        int[] res = new int[num+1];
        int pow = 1;
        while (true) {
            for (int i = 0; i < pow; i++) {
                if (i+pow > num) return res;
                res[i+pow] = 1 + res[i];
            }
            pow = pow << 1;
        }
    }
}