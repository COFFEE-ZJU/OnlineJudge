package leetcode.no068;

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
			int start = idx;
			while (idx < words.length){
				String w = words[idx];
				if (len >= w.length() + 1){
					len -= (w.length() + 1);
					idx++;
				}
				else break;
			}

			int addSpace = 0, remain = 0;
			if (idx != words.length && idx != start){
				addSpace = len / (idx-start);
				remain = len % (idx-start);
			}
			StringBuffer tmp = new StringBuffer(addSpace + 1);
			for (int i = 0; i <= addSpace; i++)
				tmp.append(' ');
			for (int i = start; i < idx; i++){
				sb.append(tmp);
				if (i - start < remain)
					sb.append(' ');
				sb.append(words[i]);
			}
			if (idx == words.length || idx == start){
				int tail = maxWidth - sb.length();
				for (int i = 0; i < tail; i++)
					sb.append(' ');
			}
			list.add(sb.toString());
		}

		return list;
	}

    public static void main(String[] args) {
		Solution sol = new Solution();
		String[] strs = new String[]{
				"Thisjjjjjjjj", "ijjjjjs", "an", "example", "of", "text", "justify", "sp."
		};
		for (String s : sol.fullJustify(strs, 16))
			System.out.println(s);
	}
}