package cn.edu.zju.coffee.leetcode.no139;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s == null || s.length() == 0) return true;
        if(wordDict == null || wordDict.isEmpty()) return false;
        
        boolean[] ok = new boolean[s.length()+1];
        ok[0] = true;
        for(int i = 1; i <= s.length(); i++){
        	for(int j = 0; j < i; j++){
        		if(ok[j] && wordDict.contains(s.substring(j, i))){
        			ok[i] = true;
        			break;
        		}
        	}
        }
        
        return ok[s.length()];
    }
    
    public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("a");
		System.out.println(new Solution().wordBreak("a", set));
	}
}