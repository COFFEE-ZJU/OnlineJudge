package cn.edu.zju.coffee.leetcode.no135;

public class Solution {
	private int sum;

	public int candy(int[] ratings) {
		if (ratings == null || ratings.length == 0)
			return 0;

		int len = ratings.length;
		sum = 0;
		int[] cnt = new int[len];
		cnt[0] = 1;
		for (int i = 1; i < len; i++) {
			if (ratings[i] > ratings[i-1])
				cnt[i] = cnt[i-1] + 1;
			else
				cnt[i] = 1;
		}
		for (int i = len-2; i >= 0 ; i--) {
			if (ratings[i] > ratings[i+1] && cnt[i] < cnt[i+1] + 1)
				cnt[i] = cnt[i+1] + 1;
		}

		for (int c : cnt)
			sum += c;
		return sum;
	}

    public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.candy(new int[]{2,2}));
		System.out.println(sol.candy(new int[]{1,2,2}));
	}
}