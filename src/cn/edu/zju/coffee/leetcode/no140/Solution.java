package cn.edu.zju.coffee.leetcode.no140;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {
	
    public List<String> wordBreak(String s, Set<String> wordDict) {
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
	}
}