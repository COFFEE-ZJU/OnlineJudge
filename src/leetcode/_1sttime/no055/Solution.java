package leetcode._1sttime.no055;

/**
 * Created by Zhangkefei on 2016/1/6.
 */
public class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 1)
            return true;

        for (int i = nums.length - 2; ;){
            while (i >= 0 && nums[i] != 0)
                i --;

            if (i < 0)
                return true;

            boolean found = false;
            for (int j = 0; j < i; j++) {
                if (j + nums[j] > i){
                    i = j;
                    found = true;
                    break;
                }
            }

            if (! found)
                return false;
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.canJump(new int[]{1,2,0,1}));
        System.out.println(sol.canJump(new int[]{1,2,0,0}));
        System.out.println(sol.canJump(new int[]{1,1,0,1}));
        System.out.println(sol.canJump(new int[]{0,2,0,1}));
        System.out.println(sol.canJump(new int[]{0}));
    }
}
