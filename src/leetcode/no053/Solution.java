package leetcode.no053;

public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int max = nums[0];
        int sum = nums[0];
        for(int i = 1; i < nums.length; i++){
        	if(sum <= 0)
        		sum = nums[i];
        	else
        		sum += nums[i];
        	
        	if(sum > max)
        		max = sum;
        }
        
        return max;
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
	}
}