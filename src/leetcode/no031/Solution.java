package leetcode.no031;

import java.util.Arrays;

/**
 * Created by zkf on 12/31/15.
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;

        int idx = nums.length - 2;
        while (idx >= 0){
            if (nums[idx] < nums[idx+1])
                break;
            idx --;
        }

        if (idx < 0) {
            reverse(nums, 0);
            return;
        }

        int idx2 = nums.length - 1;
        while (true){
            if (nums[idx] < nums[idx2])
                break;
            idx2 --;
        }

        //swap
        int tmp = nums[idx];
        nums[idx] = nums[idx2];
        nums[idx2] = tmp;

        reverse(nums, idx + 1);

    }

    private void reverse(int[] nums, int start){
        int i = start, j = nums.length - 1, tmp;
        while(i < j){
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,5};
        new Solution().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
