package leetcode.no132;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	private char[] cs;
	private boolean[][] dp;
	public int minCut(String s) {
        if(s == null || s.length() <= 1) return 0;

		cs = s.toCharArray();
		dp = new boolean[cs.length+1][cs.length+1];
		for (int i = 0; i < cs.length ; i++)
			dp[i][i] = dp[i][i+1] = true;

		for (int i = 1; i < cs.length; i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j+1][i] && cs[i] == cs[j])
					dp[j][i+1] = true;
			}
		}

		int[] len = new int[cs.length + 1];
		for (int i = 1; i < len.length; i++)
			len[i] = Integer.MAX_VALUE;
		List<Integer> list = new ArrayList<>(cs.length),
				tmp = new ArrayList<>(cs.length);
		list.add(0);
		while (!list.isEmpty()){
			tmp.clear();
			for (int idx : list){
				for (int i = 0; i < len.length; i++) {
					if (i != idx && dp[idx][i] && len[i] > len[idx] + 1) {
						len[i] = len[idx] + 1;
						if (i == cs.length)
							return len[i]-1;
						tmp.add(i);
					}
				}
			}
			List<Integer> t = tmp;
			tmp = list;
			list = t;
		}

		return -1;
	}
    
    public static void main(String[] args) {
		System.out.println(new Solution().minCut("aab"));
		System.out.println(new Solution().minCut("aab"));
	}
}