package leetcode.no357;

/**
 * Whiteboard coding!
 */
public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n < 0) return 0;
        if (n > 10) n = 10;
        int cnt = 1; // 0 is special
        for (int i = 1; i <= n; i++) {
            int tmp = 9;
            for (int j = 1; j < i; j++) {
                tmp *= (10-j);
            }
            cnt += tmp;
        }
        return cnt;
    }
}