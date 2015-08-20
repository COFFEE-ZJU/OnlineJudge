package cn.edu.zju.coffee.leetcode.no085;

public class Solution {
	private int[][] sol;
	private int max = 0;
	
    public int maximalRectangle(char[][] matrix) {
    	if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
    		return 0;
        int col = matrix.length;
        int row = matrix[0].length;
        sol = new int[row][row];
        for(int c=0; c<col; c++){
        	int startIdx = -1;
        	for(int r=0; r<row; r++){
        		if(matrix[c][r] == '0')
        			startIdx = -1;
        		else if(startIdx == -1)
        			startIdx = r;
        		
        		for(int i=0; i<= r; i++){
        			if(i < startIdx || startIdx == -1){
        				sol[i][r] = 0;
        				continue;
        			}
        			
        			sol[i][r] ++;
        			int cur = sol[i][r] * (r-i+1);
        			if(cur > max)
        				max = cur;
        		}
        	}
        }
        
        return max;
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().maximalRectangle(new char[][]{
						"10111".toCharArray(),
						"01010".toCharArray(),
						"11011".toCharArray(),
						"11011".toCharArray(),
						"01111".toCharArray(),}));
	}
}
