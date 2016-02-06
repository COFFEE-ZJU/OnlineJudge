package cn.edu.zju.coffee.leetcode.no217;

import java.util.*;

public class Solution {
    private Set<Integer> set = new HashSet<>();
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1)
            return false;

        set.clear();
        for (int num : nums){
            if (!set.add(num))
                return true;
        }
        return false;
    }
	
	public static void main(String[] args) {
		Solution sol = new Solution();
    }
}
