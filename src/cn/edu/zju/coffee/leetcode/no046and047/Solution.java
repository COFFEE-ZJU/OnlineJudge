package cn.edu.zju.coffee.leetcode.no046and047;

import java.util.*;

/**
 * Created by zkf on 1/7/16.
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        return permute(nums);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        if (nums == null || nums.length == 0)
            return list;

        Arrays.sort(nums);
        list.add(toList(nums));

        while (nextPermutation(nums))
            list.add(toList(nums));

        return list;
    }

    private static List<Integer> toList(int[] nums){
        List<Integer> res = new ArrayList<>(nums.length);
        for (int n : nums)
            res.add(n);

        return res;
    }

    private boolean nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1)
            return false;

        int idx = nums.length - 2;
        while (idx >= 0){
            if (nums[idx] < nums[idx+1])
                break;
            idx --;
        }

        if (idx < 0) {
            return false;
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

        return true;
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
        System.out.println(new Solution().permute(new int[]{1,2,1}));
    }
}
