package leetcode._2ndtime.no075;

/**
 * Whiteboard coding!
 */
public class Solution {
    public void sortColors(int[] nums) {
        int[] cnts = new int[3];
        for (int i = 0; i < nums.length; i++) {
            cnts[nums[i]]++;
        }
        int pos = 0;
        for (int c = 0; c < 3; c++) {
            for (int i = 0; i < cnts[c]; i++) {
                nums[pos++] = c;
            }
        }
    }
}