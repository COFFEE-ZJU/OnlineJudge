package leetcode._1sttime.no239;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    private Deque<Integer> deque = new LinkedList<>();
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length <= 1) return nums;

        deque.clear();
        int[] ret = new int[nums.length-k+1];
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i])
                deque.pollLast();
            deque.addLast(i);
            while (i - deque.peekFirst() > k-1)
                deque.pollFirst();
            if (i >= k-1)
                ret[i-k+1] = nums[deque.peekFirst()];
        }

        return ret;
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
    }
}
