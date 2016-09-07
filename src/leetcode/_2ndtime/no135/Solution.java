package leetcode._2ndtime.no135;

/**
 * Whiteboard coding!
 */
public class Solution {
    public int candy(int[] ratings) {
        int len;
        if (ratings == null || (len=ratings.length) == 0) return 0;
        int[] candies = new int[len];
        candies[0] = 1;
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i-1]) {
                candies[i] = candies[i-1] + 1;
            } else {
                candies[i] = 1;
            }
        }
        for (int i = len-2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                candies[i] = Math.max(candies[i], candies[i+1] + 1);
            }
        }

        int cnt = 0;
        for (int i = 0; i < len; i++) {
            cnt += candies[i];
        }
        return cnt;
    }
}