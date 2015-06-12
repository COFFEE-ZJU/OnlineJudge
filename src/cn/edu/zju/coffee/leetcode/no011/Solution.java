package cn.edu.zju.coffee.leetcode.no011;

public class Solution {
    public int maxArea(int[] height) {
        if(height == null || height.length == 0) return 0;
        
        int max = 0;
        int i = 0, j = height.length - 1;
        while(i < j){
        	int cap;
        	if(height[i] < height[j]){
        		cap = height[i] * (j-i);
        		i++;
        	}
        	else{
        		cap = height[j] * (j-i);
        		j--;
        	}
        	if(max < cap)
        		max = cap;
        }
        
        return max;
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().maxArea(new int[]{0,1,2,2}));
	}
}