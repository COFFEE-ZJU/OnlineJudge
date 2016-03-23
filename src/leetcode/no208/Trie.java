package leetcode.no208;

class TrieNode {
    // Initialize your data structure here.
	private static final int LEN = 26;
	boolean exists;
	TrieNode[] children;
	
    public TrieNode() {
        exists = false;
        children = new TrieNode[LEN];
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if(word == null) return;
        char[] cword = word.toCharArray();
        
        TrieNode cur = root;
        for(int i = -1;;){
        	if(i == cword.length - 1){
        		cur.exists = true;
        		break;
        	}
        	i++;
        	int idx = cword[i] - 'a';
        	if(cur.children[idx] == null)
        		cur.children[idx] = new TrieNode();
        	cur = cur.children[idx];
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
    	TrieNode node = findNode(word);
    	return node == null ? false : node.exists;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
    	TrieNode node = findNode(prefix);
    	return node == null ? false : true;
    }
    
    private TrieNode findNode(String prefix){
    	if(prefix == null) return null;
        char[] cword = prefix.toCharArray();
        
        TrieNode cur = root;
        for(int i = -1;;){
        	if(i == cword.length - 1)
        		return cur;
        	i++;
        	int idx = cword[i] - 'a';
        	cur = cur.children[idx];
        	if(cur == null) return null;
        }
    }
    
    public static void main(String[] args) {
    	Trie trie = new Trie();
    	trie.insert("somestring");
    	System.out.println(trie.search("somestring"));
    	System.out.println(trie.search("some"));
    	System.out.println(trie.startsWith("somestring"));
    	System.out.println(trie.startsWith("some"));
	}
}
