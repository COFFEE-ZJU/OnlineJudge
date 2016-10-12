package leetcode._2ndtime.no233;

/**
 * Whiteboard coding!
 */

public class Solution {
    public int countDigitOne(int n) {
        long cnt = 0, prevCnt = 0, digitCnt = 1;
        while (n / digitCnt != 0) {
            int curDigit = (int)(n / digitCnt % 10);
            cnt += curDigit * prevCnt;
            if (curDigit > 1) cnt += digitCnt;
            else if (curDigit == 1) cnt += n % digitCnt;

            prevCnt = prevCnt * 10 + digitCnt;
            digitCnt *= 10;
        }
        return (int)cnt;
    }
}