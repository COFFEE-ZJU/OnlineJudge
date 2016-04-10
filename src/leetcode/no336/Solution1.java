package leetcode.no336;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    private static class Trie {
        final int level;
        Trie[] chidlren = new Trie[26];
        List<Integer> orderIdxes = new LinkedList<>(), revIdxes = new LinkedList<>();
        private Trie(int level) {
            this.level = level;
        }
    }

    private String[] words;
    private Trie root;
    public List<List<Integer>> palindromePairs(String[] words) {
        this.words = words;
        root = new Trie(0);

        for (int idx = 0; idx < words.length; idx++) {
            String w = words[idx];
            Trie cur = root;
            if (isPali(w, 0, w.length()-1))
                cur.orderIdxes.add(idx);
            for (int i = 0; i < w.length(); i++) {
                int pos = w.charAt(i) - 'a';
                if (cur.chidlren[pos] == null) {
                    cur.chidlren[pos] = new Trie(cur.level+1);
                }
                cur = cur.chidlren[pos];
                if (isPali(w, i+1, w.length()-1))
                    cur.orderIdxes.add(idx);
            }

            cur = root;
            if (isPali(w, 0, w.length()-1))
                cur.revIdxes.add(idx);
            for (int i = w.length()-1; i >= 0; i--) {
                int pos = w.charAt(i) - 'a';
                if (cur.chidlren[pos] == null) {
                    cur.chidlren[pos] = new Trie(cur.level+1);
                }
                cur = cur.chidlren[pos];
                if (isPali(w, 0, i-1))
                    cur.revIdxes.add(idx);
            }
        }

        List<List<Integer>> res = new LinkedList<>();
        for (int idx = 0; idx < words.length; idx++) {
            String w = words[idx];
            Trie node = findTrieNode(w);
            for (int cand : node.revIdxes) {
                if (cand == idx) continue;
                if (isPali(words[cand], 0, node.level-1)) {
                    res.add(Arrays.asList(idx, cand));
                }
            }

            node = findTrieNodeRev(w);
            for (int cand : node.orderIdxes) {
                if (cand == idx) continue;
                if (isPali(words[cand], node.level, words[cand].length()-1)) {
                    res.add(Arrays.asList(cand, idx));
                }
            }
        }

        return res;
    }

    private boolean isPali(String word, int left, int right) {
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }

    private Trie findTrieNode(String w) {
        Trie cur = root;
        for (int i = 0; i < w.length(); i++) {
            cur = cur.chidlren[w.charAt(i) - 'a'];
        }
        return cur;
    }

    private Trie findTrieNodeRev(String w) {
        Trie cur = root;
        for (int i = w.length()-1; i >= 0; i--) {
            cur = cur.chidlren[w.charAt(i) - 'a'];
        }
        return cur;
    }

    public static void main(String[] args) {
		Solution1 sol = new Solution1();
        System.out.println(sol.palindromePairs(new String[]{
                "bat", "tab", "cat"
//                "abcd", "dcba", "lls", "s", "sssll"
        }));
    }
}
