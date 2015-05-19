package cn.edu.zju.coffee.no209;

public class Solution {
	public int minSubArrayLen(int s, int[] nums) {
		if(nums.length == 0) return 0;
		
        int sIdx = 0, eIdx = 1;
        int curSum = nums[0];
        int best = Integer.MAX_VALUE;
        while(true){
        	if(curSum >= s){
        		int len = eIdx - sIdx;
        		if(best > len) best = len;
        		if(best == 1) return best;
        		
        		curSum -= nums[sIdx];
        		sIdx ++;
        	} else {
        		if(eIdx >= nums.length) break;
        		curSum += nums[eIdx];
        		eIdx ++;
        	}
        }
        
        return (best == Integer.MAX_VALUE) ? 0 : best;
    }
	
	public static void main(String[] args) {
		System.out.println(new Solution().minSubArrayLen(9, new int[]{2,3,1,2,4,3}));
	}
}
