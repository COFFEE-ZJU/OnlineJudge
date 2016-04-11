package leetcode;

/**
 * Created by Zhangkefei on 2016/4/11.
 */
public class Trie {
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
}
