package cn.edu.zju.coffee.leetcode.no154;

public class Solution {
	private int findMin(int s, int e, int[] nums){
		if(s == e || nums[s] < nums[e]) return nums[s];
		int mid = (s + e) / 2;
		if(nums[s] == nums[e] && nums[s] == nums[mid]){
			int r1 = findMin(s, mid, nums);
			int r2 = findMin(mid+1, e, nums);
			return r1>r2 ? r2 : r1;
		}
		else if(nums[mid] > nums[s] || nums[mid] > nums[e]) return findMin(mid+1, e, nums);
		else return findMin(s, mid, nums);
	}
	
    public int findMin(int[] nums) {
        return findMin(0, nums.length - 1, nums);
    }
    
    public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.findMin(new int[]{1, 2, 0, 1,1,1,1}));
	}
}
