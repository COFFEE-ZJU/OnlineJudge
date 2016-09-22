package hulu.n2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static class Trie {
		public Trie[] children = new Trie[128];
		public String word;

		public void addWord(String word) {
			Trie cur = this;
			for (int i = 0; i < word.length(); i++) {
				int pos = word.charAt(i);
				if (cur.children[pos] == null)
					cur.children[pos] = new Trie();
				cur = cur.children[pos];
			}
			cur.word = word;
		}

		public List<Integer> findPrefixLens(String word) {
			Trie cur = this;
			List<Integer> res = new ArrayList<>();
			for (int i = 0; i < word.length(); i++) {
				if (cur == null) return res;
				int c = word.charAt(i);
				if (cur.word != null) res.add(cur.word.length());
				cur = cur.children[c];
			}
			if (cur.word != null) res.add(cur.word.length());
			return res;
		}
	}
	private void deal() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextLine()) {
			String[] words = scanner.nextLine().split(" ");
			Trie order = new Trie();
			Trie rev = new Trie();
			for (String w : words) {
				order.addWord(w);
				rev.addWord(new StringBuilder(w).reverse().toString());
			}

			String maxStr = null;
			int maxLen = -1;
			for (String w : words) {
				int len = w.length();
				if (len <= maxLen) continue;

				List<Integer> l1 = order.findPrefixLens(w);
				List<Integer> l2 = rev.findPrefixLens(new StringBuilder(w).reverse().toString());
				for (int i = 0, j = l2.size()-1; i < l1.size() && j >= 0; ){
					int cmp = l1.get(i) + l2.get(j);
					if (cmp == len) {
						maxLen = len;
						maxStr = w;
						break;
					}

					if (cmp < len) i++;
					else j--;
				}
			}

			System.out.println(maxStr);
		}
	}

	public static void main(String[] args) {
		new Main().deal();
	}
}
