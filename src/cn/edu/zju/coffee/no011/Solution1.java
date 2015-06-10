package cn.edu.zju.coffee.no011;

public class Solution1 {
    public int maxArea(int[] height) {
        if(height == null || height.length == 0) return 0;
        int maxH = 0;
        for(int i = 0; i < height.length; i++){
        	if(height[i] > maxH) maxH = height[i];
        }
        
        int[] prevCapWithH = new int[maxH+1];
        int max = 0, prevH = 0;
        for(int i = 0; i < height.length; i++){
        	for(int j = 1; j <= height[i]; j++){
        		if(j > prevH)
        			prevCapWithH[j] = j;
        		else
        			prevCapWithH[j] += j;
        		
        		if(max < prevCapWithH[j])
        			max = prevCapWithH[j];
        	}
        	prevH = height[i];
        }
        
        return max;
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution1().maxArea(new int[]{0,1,2,2}));
	}
}