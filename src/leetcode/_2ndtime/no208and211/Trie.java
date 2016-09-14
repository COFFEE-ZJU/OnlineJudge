package leetcode._2ndtime.no208and211;

/**
 * Whiteboard coding!
 */
class TrieNode {
    // Initialize your data structure here.
    private TrieNode[] children = null;
    private boolean isAWord = false;
    public TrieNode() {
    }

    private TrieNode searchNode(String s, int idx, boolean isPrefix) {
        if (idx == s.length()) return this;

        if (children == null) return null;
        char c = s.charAt(idx++);
        if (c != '.') {
            TrieNode next = children[c - 'a'];
            return next == null ? null : next.searchNode(s, idx, isPrefix);
        }

        for (int i = 0; i < 26; i++) {
            if (children[i] != null) {
                TrieNode node = children[i].searchNode(s, idx, isPrefix);
                if (node != null && (isPrefix || node.isAWord)) return node;
            }
        }

        return null;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = searchNode(prefix, 0, true);
        return node != null;
    }

    public boolean search(String word) {
        TrieNode node = searchNode(word, 0, false);
        return node != null && node.isAWord;
    }

    public void insert(String w, int idx) {
        if (idx == w.length()) {
            isAWord = true;
            return;
        }

        if (children == null) children = new TrieNode[26];

        int c = w.charAt(idx++) - 'a';
        if (children[c] == null) children[c] = new TrieNode();
        children[c].insert(w, idx);
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if (word == null) word = "";
        root.insert(word, 0);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if (word == null) word = "";
        return root.search(word);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (prefix == null) prefix = "";
        return root.startsWith(prefix);
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");