package cn.edu.zju.coffee.leetcode.no059;

import java.util.LinkedList;
import java.util.List;

public class Solution {
	int rows, cols;
	int[][] matrix;
	
	private void innerSpiral(int[][] matrix, 
			int srow, int erow, int scol, int ecol, int dir, int cur){
		if(erow == srow || ecol == scol)
			return;
		
		int i;
		switch (dir) {
		case 0:		//left to right
			for(i = scol; i < ecol; i++)
				matrix[srow][i] = cur++;
			innerSpiral(matrix, srow+1, erow, scol, ecol, dir+1, cur);
			break;
		case 1:		//up to down
			for(i = srow; i < erow; i++)
				matrix[i][ecol-1] = cur++;
			innerSpiral(matrix, srow, erow, scol, ecol-1, dir+1, cur);
			break;
		case 2:		//right to left
			for(i = ecol-1; i >= scol; i--)
				matrix[erow-1][i] = cur++;
			innerSpiral(matrix, srow, erow-1, scol, ecol, dir+1, cur);
			break;
		case 3:		//down to up
			for(i = erow-1; i >= srow; i--)
				matrix[i][scol] = cur++;
			innerSpiral(matrix, srow, erow, scol+1, ecol, 0, cur);
			break;

		default:
			break;
		}
		
	}
	
	public int[][] generateMatrix(int n) {
    	if(n < 0) return null;
    	matrix = new int[n][n];
    	
    	rows = n;
    	cols = n;
    	innerSpiral(matrix, 0, rows, 0, cols, 0, 1);
    	
    	return matrix;
    }
    
}