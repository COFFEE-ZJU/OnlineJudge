package cn.edu.zju.coffee.leetcode.no045;

import java.util.PriorityQueue;

/**
 * Created by Zhangkefei on 2016/1/6.
 */
public class Solution {

    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1)
            return 0;

        int len = nums.length;
        int[] prevJumps = new int[len];

        PriorityQueue<JumpInfo> heap = new PriorityQueue<>();
        heap.add(new JumpInfo(0, 0));

        for (int i = 1; i < len; i++)
            prevJumps[i] = Integer.MAX_VALUE;

        for (int i = 1; i < len; i++) {
            JumpInfo prev = heap.peek();
            for (; nums[prev.idx] + prev.idx < i; prev = heap.peek())
                heap.poll();

            prevJumps[i] = prev.prevJump + 1;
            heap.add(new JumpInfo(i, prevJumps[i]));
        }

        return prevJumps[len-1];
    }

    private static class JumpInfo implements Comparable<JumpInfo> {
        int idx, prevJump;

        public JumpInfo(int idx, int prevJump) {
            this.idx = idx;
            this.prevJump = prevJump;
        }

        @Override
        public int compareTo(JumpInfo o) {
            return Integer.compare(prevJump, o.prevJump);
        }
    }

    private void jump(int[] nums, int[] prevJumps, int curPos){
        if (prevJumps[curPos] >= prevJumps[nums.length - 1] - 1)
            return;

        int maxPos = Math.min(curPos + nums[curPos], nums.length - 1);
        for (int i = maxPos; i > curPos; i--) {
            if (prevJumps[curPos] + 1 < prevJumps[i]) {
                prevJumps[i] = prevJumps[curPos] + 1;
                jump(nums, prevJumps, i);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[25002];
        for (int i = 0; i < 25000; i++) {
            nums[i] = 25000 - i;
        }

        nums[25000] = 1;

        for (int i = 0; i < nums.length; i++)
            nums[i] = 1;

//        System.out.println(new Solution().jump(nums));
        System.out.println(new Solution().jump(new int[]{1,2,0,1}));
//        System.out.println(new Solution().jump(new int[]{2,3,1,1,4}));
//        System.out.println(new Solution().jump(new int[]{7,8,4,2,0,6,4,1,8,7,1,7,4,1,4,1,2,8,2,7,3,7,8,2,4,4,5,3,5,6,8,5,4,4,7,4,3,4,8,1,1,9,0,8,2}));
    }
}
