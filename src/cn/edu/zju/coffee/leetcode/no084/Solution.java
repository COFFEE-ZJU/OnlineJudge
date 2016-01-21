package cn.edu.zju.coffee.leetcode.no084;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int maxArea = 0;
        int[] h = Arrays.copyOf(height, height.length + 1);
        while(i < h.length){
            if(stack.isEmpty() || h[stack.peek()] <= h[i]){
                stack.push(i++);
            }else {
                int t = stack.pop();
                maxArea = Math.max(maxArea, h[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }
        return maxArea;
    }

    public int largestRectangleAreaBad(int[] height) {
        if(height == null || height.length == 0)
        	return 0;
        
        int len = height.length;
        int max = 0;
        int[] ht = new int[len];
        for(int i=0; i<len; i++)
        	ht[i] = Integer.MAX_VALUE;
        for(int i=0; i<len; i++){
        	for(int j=0; j<=i; j++){
        		if(ht[j]>height[i])
        			ht[j] = height[i];
        		
        		int area = (i-j+1)*ht[j];
        		if(area > max)
        			max = area;
        	}
        }
        
        return max;
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().largestRectangleArea(new int[]{2,1,5,6,2,3}));
	}
}