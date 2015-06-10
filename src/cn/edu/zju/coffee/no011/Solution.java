package cn.edu.zju.coffee.no011;

public class Solution {
    public int maxArea(int[] height) {
        if(height == null || height.length == 0) return 0;
        
        int max = 0;
        for(int i = 0; i < height.length; i++){
        	int minH = height[i];
        	int len = 0;
        	for(int j = i; j >= 0; j--){
        		len ++;
        		if(minH > height[j])
        			minH = height[j];
        		
        		if(minH == 0)
        			break;
        		
        		int cap = minH * len;
        		if(max < cap)
        			max = cap;
        	}
        }
        
        return max;
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().maxArea(new int[]{0,1,2,2}));
	}
}