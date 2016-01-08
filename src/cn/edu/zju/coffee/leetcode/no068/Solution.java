package cn.edu.zju.coffee.leetcode.no068;

import java.util.LinkedList;
import java.util.List;

public class Solution {
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> list = new LinkedList<>();
		if (words == null || words.length == 0)
			return list;

		int idx = 0;
		StringBuilder sb;
		while (idx < words.length){
			sb = new StringBuilder();
			sb.append(words[idx]);
			int len = maxWidth - words[idx++].length();
			while (true){
				String w = words[idx];
				if (len >= w.length() + 1){
					len -= (w.length() + 1);
					idx++;
				}
				else break;
			}
		}
	}

    public static void main(String[] args) {
		Solution sol = new Solution();
		int[][] grid = new int[][]{
				new int[]{0,0,0},
				new int[]{1,1,2},
				new int[]{0,0,0},
		};

	}
}