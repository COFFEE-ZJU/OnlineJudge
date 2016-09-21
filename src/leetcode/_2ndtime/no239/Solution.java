package leetcode._2ndtime.no239;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * O(n) time!
 * Whiteboard coding!
 */
public class Solution {
    private Deque<Integer> deque = new ArrayDeque<>();
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len;
        if (nums == null || (len=nums.length) == 0 || k <= 0 || k > len) return new int[0];

        deque.clear();
        for (int i = 0; i < k-1; i++) {
            addToDeque(nums[i]);
        }

        int[] res = new int[len - k + 1];
        for (int i = k-1; i < len; i++) {
            addToDeque(nums[i]);
            res[i-k+1] = deque.peekFirst();
            removeFromDeque(nums[i-k+1]);
        }
        return res;
    }

    private void addToDeque(int n) {
        while (!deque.isEmpty() && deque.peekLast() < n) {
            deque.pollLast();
        }
        deque.addLast(n);
    }

    private void removeFromDeque(int n) {
        if (deque.peekFirst() == n) {
            deque.pollFirst();
        }
    }
}
