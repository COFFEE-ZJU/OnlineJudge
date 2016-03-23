package hiho.no1014;

import java.util.Scanner;

/**
 * 
 * Problem Description: http://hihocoder.com/problemset/problem/1014
 * @author zkf
 *
 */

public class Main {
	private static class Trie {
		int count = 0;
		Trie[] children = new Trie[26];
	}

	private Trie root = new Trie();

	private void addWord(String word) {
		if (word == null || word.length() == 0)
			return;

		Trie trie = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (trie.children[c-'a'] == null)
				trie.children[c-'a'] = new Trie();

			trie.count++;
			trie = trie.children[c-'a'];
		}
		trie.count++;
	}

	private int query(String prefix) {
		if (prefix == null || prefix.length() == 0)
			return root.count;

		Trie trie = root;
		for (int i = 0; i < prefix.length(); i++) {
			char c = prefix.charAt(i);
			if (trie.children[c-'a'] == null)
				return 0;

			trie = trie.children[c-'a'];
		}
		return trie.count;
	}

	public static void main(String[] args) {
		try(Scanner scanner = new Scanner(System.in)) {
			while (scanner.hasNextInt()) {
				Main main = new Main();
				int n = scanner.nextInt();
				for (int i = 0; i < n; i++)
					main.addWord(scanner.next());

				int q = scanner.nextInt();
				for (int i = 0; i < q; i++)
					System.out.println(main.query(scanner.next()));
			}
		}
	}
}
