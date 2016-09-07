package leetcode._2ndtime.no274;

import java.util.Arrays;

/**
 * Whiteboard coding!
 */
public class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;

        int h = 0;
        Arrays.sort(citations);
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] > h) {
                h++;
            } else {
                break;
            }
        }
        return h;
    }
}