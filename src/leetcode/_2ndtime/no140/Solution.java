package leetcode._2ndtime.no140;

import java.util.*;

public class Solution {
	private static class Trie {
		public Trie[] children = new Trie[26];
		public String word;

		public void addWord(String word) {
			Trie cur = this;
			for (int i = 0; i < word.length(); i++) {
				int pos = word.charAt(i) - 'a';
				if (cur.children[pos] == null)
					cur.children[pos] = new Trie();
				cur = cur.children[pos];
			}
			cur.word = word;
		}

		private List<String> getPossibleWords(String str, int idx) {
			Trie cur = this;
			List<String> res = new ArrayList<>();
			for (int i = idx; i < str.length(); i++) {
				cur = cur.children[str.charAt(i)-'a'];
				if (cur == null) break;
				if (cur.word != null) res.add(cur.word);
			}

			return res;
		}
	}

	private Trie root;
	private Map<Integer, List<String>> cache = new HashMap<>();

	public List<String> wordBreak(String s, Set<String> wordDict) {
		cache.clear();
		root = new Trie();
		for (String w : wordDict)
			root.addWord(w);

		int len = s.length();
		List<List<String>>[] dp = new List[len+1];
		dp[0] = Collections.singletonList(new ArrayList<>());
		for (int i = 0; i < len; i++) {
			if (dp[i] == null || dp[i].isEmpty()) continue;

			List<String> nexts = root.getPossibleWords(s, i);
			for (String next : nexts) {
				int ni = i + next.length();
				if (dp[ni] == null) {
					dp[ni] = new ArrayList<>();
				}
				List<List<String>> lists = dp[ni];
				for (List<String> curList : dp[i]) {
					List<String> nList = new ArrayList<>(curList);
					nList.add(next);
					lists.add(nList);
				}
			}
		}

		return genRes(dp[len]);
	}

	private List<String> genRes(List<List<String>> lists) {
		List<String> res = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for (List<String> list : lists) {
			sb.setLength(0);
			for (String str : list) {
				sb.append(' ').append(str);
			}
			res.add(sb.substring(1));
		}
		return res;
	}
}