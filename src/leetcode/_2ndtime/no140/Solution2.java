package leetcode._2ndtime.no140;

import leetcode.Trie;

import java.util.*;

public class Solution2 {

	private Trie root;
	private List<String>[] compWords;
	public List<String> wordBreak(String s, Set<String> wordDict) {
		root = new Trie();
		for (String w : wordDict)
			root.addWord(w);

		compWords = new List[s.length()];

		List<Trie> incomp = new LinkedList<>();
		List<Trie> tmp, next = new LinkedList<>();
		incomp.add(root);
		for (int i = 0; i < s.length(); i++) {
			next.clear();
			boolean comp = false;
			int pos = s.charAt(i) - 'a';
			for (Trie trie : incomp) {
				Trie nt = trie.children[pos];
				if (nt == null) continue;
				if (nt.word != null) {
					comp = true;
					if (compWords[i] == null)
						compWords[i] = new LinkedList<>();
					compWords[i].add(nt.word);
				}

				next.add(nt);
			}
			if (comp)
				next.add(root);

			tmp = next;
			next = incomp;
			incomp = tmp;
		}

		List<String> last = compWords[s.length()-1];
		if (last == null)
			return Collections.emptyList();

		List<StringBuilder> resSb = getAll(s.length()-1);

		List<String> res = new LinkedList<>();
		for (StringBuilder sb : resSb) {
			res.add(sb.deleteCharAt(0).toString());
		}

		return res;
	}

	private List<StringBuilder> getAll(int idx) {
		List<StringBuilder> res = new LinkedList<>();
		if (idx == -1) {
			res.add(new StringBuilder());
			return res;
		}

		for (String w : compWords[idx]) {
			List<StringBuilder> prev = getAll(idx - w.length());
			for (StringBuilder sb : prev) {
				res.add(sb.append(' ').append(w));
			}
		}

		return res;
	}

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("a");
		set.add("aa");
		System.out.println(new Solution2().wordBreak("aa", set));

		set = new HashSet<String>();
		set.add("a");
		set.add("aa");
		set.add("aaa");
		set.add("aaaa");
		set.add("aaaaa");
		set.add("aaaaaa");
		set.add("aaaaaaa");
		set.add("aaaaaaaa");
		set.add("aaaaaaaaa");
		set.add("aaaaaaaaaa");
		System.out.println(new Solution2().wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", set));
	}
}