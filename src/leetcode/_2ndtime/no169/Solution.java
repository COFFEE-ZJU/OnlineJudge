package leetcode._2ndtime.no169;

/**
 * Whiteboard coding!
 */
public class Solution {
    public int majorityElement(int[] nums) {
        int res = 0, cnt = 0;
        for (int n : nums) {
            if (res == n) cnt++;
            else if (cnt > 0) cnt--;
            else {
                res = n;
                cnt = 1;
            }
        }
        return res;
    }
}