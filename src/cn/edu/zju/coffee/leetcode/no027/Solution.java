package cn.edu.zju.coffee.leetcode.no027;

public class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;

        int i = 0, j = nums.length-1;
        while (i < j) {
            while (i < j && nums[i] != val)
                i++;
            while (j > i && nums[j] == val)
                j--;
            if (i >= j)
                break;
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;

            i++; j--;
        }

        return nums[i] == val ? i : i + 1;
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
        System.out.println(sol.removeElement(new int[]{1,1,1}, 1));
        System.out.println(sol.removeElement(new int[]{1,1,1}, 2));
        System.out.println(sol.removeElement(new int[]{1,1,2}, 1));
        System.out.println(sol.removeElement(new int[]{1,1,2,1,4,5,6}, 1));
        System.out.println(sol.removeElement(new int[]{1,1,1,2,1,4,5,6}, 1));
    }
}
