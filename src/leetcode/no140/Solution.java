package leetcode.no140;

import java.util.*;

public class Solution {
	private static class TrieTree {
		String word;
		TrieTree[] children = new TrieTree[128];
	}

	private TrieTree root;
	private List<List<String>>[] idxToList;
	public List<String> wordBreak(String s, Set<String> wordDict) {
		if(s == null || s.length() == 0){
			List<String> l = new LinkedList<String>();
			l.add("");
			return l;
		}
		if(wordDict == null || wordDict.isEmpty()) return new LinkedList<String>();

		root = new TrieTree();
		idxToList = new List[s.length()];
		for (String w : wordDict)
			addWord(w);

		List<String> res = new LinkedList<>();
		for (List<String> list : findBreaks(s, 0))
			res.add(String.join(" ", list));
		return res;
	}

	private List<List<String>> findBreaks(String s, int idx) {
		if (idxToList[idx] != null)
			return idxToList[idx];
		List<List<String>> res = new LinkedList<>();
		TrieTree cur = root;
		for (int i = idx; i < s.length(); i++) {
			char c = s.charAt(i);
			TrieTree child = cur.children[c];
			if (child == null) break;
			if (child.word != null) {
				if (i == s.length() - 1) {
					res.add(Collections.singletonList(child.word));
					break;
				}
				for (List<String> postRes : findBreaks(s, i+1)){
					List<String> tmp = new LinkedList<>(postRes);
					tmp.add(0, child.word);
					res.add(tmp);
				}
			}
			cur = child;
		}

		idxToList[idx] = res;
		return res;
	}

	private void addWord(String w) {
		TrieTree cur = root;
		for (int i = 0; i < w.length(); i++) {
			char c = w.charAt(i);
			if (cur.children[c] == null)
				cur.children[c] = new TrieTree();
			cur = cur.children[c];
		}
		if (cur.word == null)
			cur.word = w;
	}
	
    public List<String> wordBreak1(String s, Set<String> wordDict) {
        if(s == null || s.length() == 0){
        	List<String> l = new LinkedList<String>();
        	l.add("");
        	return l;
        }
        if(wordDict == null || wordDict.isEmpty()) return new LinkedList<String>();
        
        List<String>[] okList = new List[s.length()+1];
        okList[0] = new LinkedList<String>();
        okList[0].add("");
        for(int i = 1; i <= s.length(); i++){
        	for(int j = 0; j < i; j++){
        		String subS = s.substring(j, i);
        		if(okList[j] != null && wordDict.contains(subS)){
        			if(okList[i] == null)
        				okList[i] = new LinkedList<String>();
        			
        			for(String str: okList[j])
        				okList[i].add(str + subS + (i == s.length() ? "" : " "));
        		}
        	}
        }
        
        return okList[s.length()];
    }
    
    public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("a");
		set.add("aa");
		System.out.println(new Solution().wordBreak("aa", set));

//		Set<String> set = new HashSet<String>();
//		set.add("a");
//		set.add("aa");
//		set.add("aaa");
//		set.add("aaaa");
//		set.add("aaaaa");
//		set.add("aaaaaa");
//		set.add("aaaaaaa");
//		set.add("aaaaaaaa");
//		set.add("aaaaaaaaa");
//		set.add("aaaaaaaaaa");
//		System.out.println(new Solution().wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", set));
	}
}