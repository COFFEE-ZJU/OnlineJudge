package leetcode.no054;

import java.util.LinkedList;
import java.util.List;

public class Solution {
	private List<Integer> list = new LinkedList<Integer>();
	int rows, cols;
	
	private void innerSpiral(int[][] matrix, 
			int srow, int erow, int scol, int ecol, int dir){
		if(erow == srow || ecol == scol)
			return;
		
		int i;
		switch (dir) {
		case 0:		//left to right
			for(i = scol; i < ecol; i++)
				list.add(matrix[srow][i]);
			innerSpiral(matrix, srow+1, erow, scol, ecol, dir+1);
			break;
		case 1:		//up to down
			for(i = srow; i < erow; i++)
				list.add(matrix[i][ecol-1]);
			innerSpiral(matrix, srow, erow, scol, ecol-1, dir+1);
			break;
		case 2:		//right to left
			for(i = ecol-1; i >= scol; i--)
				list.add(matrix[erow-1][i]);
			innerSpiral(matrix, srow, erow-1, scol, ecol, dir+1);
			break;
		case 3:		//down to up
			for(i = erow-1; i >= srow; i--)
				list.add(matrix[i][scol]);
			innerSpiral(matrix, srow, erow, scol+1, ecol, 0);
			break;

		default:
			break;
		}
		
	}
	
    public List<Integer> spiralOrder(int[][] matrix) {
    	list.clear();
    	if(matrix.length == 0 || matrix[0].length == 0)
    		return list;
    	
    	rows = matrix.length;
    	cols = matrix[0].length;
    	innerSpiral(matrix, 0, rows, 0, cols, 0);
    	
    	return list;
    }
    
    public static void main(String[] args) {
		List<Integer> list = new Solution().spiralOrder(new int[][]{
				new int[]{1, 2, 3},
				new int[]{4, 5, 6},
//				new int[]{7, 8, 9},
		});
		for(int i: list){
			System.out.print(i+"->");
		}
	}
}