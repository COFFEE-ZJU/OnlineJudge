package cn.edu.zju.coffee.leetcode.no229;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return Collections.emptyList();
        if (nums.length == 1)
            return Collections.singletonList(nums[0]);

        int c1 = nums[0], v1 = 1;
        int c2 = 0, v2 = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == c1)
                v1++;
            else if (nums[i] == c2)
                v2++;
            else if (v1 == 0){
                c1 = nums[i]; v1 = 1;
            }
            else if (v2 == 0){
                c2 = nums[i]; v2 = 1;
            }
            else {
                v1--; v2--;
            }
        }

        int cc = nums.length / 3;
        v1 = v2 = 0;
        for (int n : nums){
            if (n == c1)
                v1++;
            else if (n == c2)
                v2++;
        }

        List<Integer> list = new LinkedList<>();
        if (v1 > cc) list.add(c1);
        if (v2 > cc) list.add(c2);
        return list;
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
    }
}
