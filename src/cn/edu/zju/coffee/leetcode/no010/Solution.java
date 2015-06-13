package cn.edu.zju.coffee.leetcode.no010;

public class Solution {
	private boolean isMatch(String s, String p, int pos1, int pos2) {
        int len1 = s.length() - pos1, len2 = p.length() - pos2;
		if(len2 == 0)	// pattern string ended
			return len1 == 0;
		
        if(len2 == 1 || p.charAt(pos2+1) != '*'){	//match this one
        	if(len1 == 0) return false;
        	if(equals(s.charAt(pos1), p.charAt(pos2)))
        		return isMatch(s, p, pos1+1, pos2+1);
        	else return false;
        }
        
        // multiple matches
        while(pos1 <= s.length()){
        	if(isMatch(s, p, pos1, pos2+2))
        		return true;
        	
        	if(pos1 == s.length()) return false;
        	
        	if(equals(s.charAt(pos1), p.charAt(pos2)))
        		pos1 ++;
        	else
        		return false;
        }
        
        return false;
	}
	
	private boolean equals(char s, char p){
		if(p == '.') return true;
		
		return p == s;
	}
	
    public boolean isMatch(String s, String p) {
    	if(s == null && p == null) return true;
    	if(s == null || p == null) return false;
        return isMatch(s, p, 0, 0);
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().isMatch("ab", ".*c"));
	}
}