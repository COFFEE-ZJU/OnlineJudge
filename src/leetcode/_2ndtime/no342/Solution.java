package leetcode._2ndtime.no342;

/**
 * Whiteboard coding!
 */
public class Solution {
    private static final int mask = 0x55555555;
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num-1)) == 0 && (num & mask) != 0;
    }
}