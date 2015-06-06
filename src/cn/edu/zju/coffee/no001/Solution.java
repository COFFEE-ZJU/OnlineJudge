package cn.edu.zju.coffee.no001;

import java.util.Arrays;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
    	
        if(nums.length <= 1) return null;
        
        int len = nums.length;
        int[] sortNums = new int[len];
        System.arraycopy(nums, 0, sortNums, 0, len);
        
    	Arrays.sort(sortNums);
        int i = 0, j = len - 1;
        
        while(i < j){
        	if(sortNums[i] + sortNums[j] == target)
        		break;
        	
        	if(sortNums[i] + sortNums[j] < target)
        		i ++;
        	else
        		j --;
        }
        
        if(i >= j) return null;
        
        int a = -1, b = -1;
        for(int k = 0; k < len; k ++){
        	if(sortNums[i] == nums[k] && a == -1)
        		a = k;
        	else if(sortNums[j] == nums[k])
        		b = k;
        	
        	if(a != -1 && b != -1){
        		if(a > b)
        			return new int[]{b+1, a+1};
        		else
        			return new int[]{a+1, b+1};
        	}
        }
        
        return null;
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().twoSum(new int[]{0,4,3,0}, 0));
	}
}