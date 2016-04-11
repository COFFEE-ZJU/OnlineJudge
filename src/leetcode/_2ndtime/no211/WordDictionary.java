package leetcode._2ndtime.no211;

import leetcode.Trie;

public class WordDictionary {
	private Trie root = new Trie();

	private boolean search(String word, int st, Trie node) {
		if (node == null) return false;

		for (int i = st; i < word.length(); i++) {
			char c = word.charAt(i);
			if (c == '.') {
				for (Trie nn : node.children) {
					if (search(word, i+1, nn))
						return true;
				}
				return false;
			}

			int pos = c-'a';
			node = node.children[pos];
			if (node == null)
				return false;
		}

		return node.word != null;
	}

    // Adds a word into the data structure.
	public void addWord(String word) {
		root.addWord(word);
	}

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
		return search(word, 0, root);
	}

    public static void main(String[] args) {
    	WordDictionary wordDictionary = new WordDictionary();
    	wordDictionary.addWord("bad");
    	wordDictionary.addWord("dad");
    	wordDictionary.addWord("mad");
    	System.out.println(wordDictionary.search("pad"));
    	System.out.println(wordDictionary.search("bad"));
    	System.out.println(wordDictionary.search(".ad"));
    	System.out.println(wordDictionary.search("b.."));
	}
}