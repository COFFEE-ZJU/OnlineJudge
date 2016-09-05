package leetcode._1sttime.no365;

/**
 * Whiteboard coding!
 */
public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (z > x + y) return false;
        if (z == 0) return true;
        if (x == 0) return z == y;
        if (y == 0) return z == x;
        int gcd = gcd(x, y);
        return z % gcd == 0;
    }

    private int gcd(int x, int y) {
        if (y == 0) return x;
        return gcd(y, x % y);
    }
}