package leetcode.no164;

public class Solution {
    public int maximumGap(int[] nums) {
    	int len = nums.length;
    	if(len < 2) return 0;
    	int minN = Integer.MAX_VALUE;
    	int maxN = Integer.MIN_VALUE;
    	int[] max = new int[len];
    	int[] min = new int[len];
    	for(int i = 0; i < len; i++){
    		max[i] = Integer.MIN_VALUE;
    		min[i] = Integer.MAX_VALUE;
    		if(nums[i] < minN) minN = nums[i];
    		if(nums[i] > maxN) maxN = nums[i]; 
        }
    	int gap = maxN - minN;
    	
    	for(int i = 0; i < len; i++){
    		int idx = (int)((long)(nums[i] - minN) * (long)len / (long)gap);
    		if(idx == len) idx --;
    		if(nums[i] > max[idx]) max[idx] = nums[i];
    		if(nums[i] < min[idx]) min[idx] = nums[i];
    	}
    	
    	gap = 0;
    	int prevMax = max[0];
    	for(int i = 1; i < len; i++){
    		if(min[i] == Integer.MAX_VALUE || prevMax == Integer.MIN_VALUE) continue;
    		int cur = min[i] - prevMax;
    		if(cur > gap) gap = cur;
    		prevMax = max[i];
    	}
    	
    	return gap;
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().maximumGap(new int[]{1,34,30,32,23,4}));
	}
}
