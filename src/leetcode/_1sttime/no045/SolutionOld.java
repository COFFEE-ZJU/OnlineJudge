package leetcode._1sttime.no045;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Zhangkefei on 2016/1/6.
 */
public class SolutionOld {
    public int jumpOld(int[] nums) {
        if (nums == null || nums.length <= 1)
            return 0;

        int len = nums.length;
        int[] prevJumps = new int[len];

        for (int i = 1; i < len; i++)
            prevJumps[i] = Integer.MAX_VALUE;

        for (int i = 0; i < len - 1; i++) {
            for (int j = i+1; j <= i+nums[i]; j++) {
                if (j >= len)
                    break;

                if (prevJumps[i] + 1 < prevJumps[j])
                    prevJumps[j] = prevJumps[i] + 1;
            }
        }

        return prevJumps[len-1];
    }

    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1)
            return 0;

        int len = nums.length;
        int[] prevJumps = new int[len];

        for (int i = 1; i < len; i++)
            prevJumps[i] = Integer.MAX_VALUE;

        List<Integer> stack = new LinkedList<>();
        stack.add(0);
        while (!stack.isEmpty()){
            int curPos = stack.remove(0);
            if (prevJumps[curPos] >= prevJumps[nums.length - 1] - 1)
                continue;

            int maxPos = Math.min(curPos + nums[curPos], nums.length - 1);
            for (int i = maxPos; i > curPos; i--) {
                if (prevJumps[curPos] + 1 < prevJumps[i]) {
                    prevJumps[i] = prevJumps[curPos] + 1;
                    stack.add(0, i);
                }
            }
        }
//        jump(nums, prevJumps, 0);

        return prevJumps[len-1];
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
//        for (int i = 0; i < 25000; i++) {
//            nums[i] = 25000 - i;
//        }
//
//        nums[25000] = 1;

        for (int i = 0; i < nums.length; i++)
            nums[i] = 1;

        System.out.println(new SolutionOld().jump(nums));
//        System.out.println(new MinStack().jump(new int[]{2,3,1,1,4}));
//        System.out.println(new MinStack().jump(new int[]{7,8,4,2,0,6,4,1,8,7,1,7,4,1,4,1,2,8,2,7,3,7,8,2,4,4,5,3,5,6,8,5,4,4,7,4,3,4,8,1,1,9,0,8,2}));
    }
}
