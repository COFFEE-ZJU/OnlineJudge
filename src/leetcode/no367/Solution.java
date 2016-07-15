package leetcode.no367;

/**
 * Whiteboard coding!
 */
public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        long left = 1, right = num / 2;
        long lnum = num;
        while (left <= right) {
            long mid = (left + right) >>> 1;
            long tmp = mid * mid;
            if (tmp == lnum) return true;
            if (tmp < lnum) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}