package leetcode._1sttime.no005;

public class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return s;
    	int len = s.length();
    	boolean[][] isPal = new boolean[len][len];
    	isPal[0][0] = true;
    	int max = 1;
    	int start = 0, end = 0;
    	for(int i = 1; i < len; i++){
    		isPal[i][i] = true;
    		if(s.charAt(i) == s.charAt(i - 1)){
    			isPal[i-1][i] = true;
    			if(2 > max){
					max = 2;
					start = i-1;
					end = i;
				}
    		}
    		for(int j = 0; j < i; j++){
    			if(isPal[j+1][i-1] && s.charAt(i) == s.charAt(j)){
    				isPal[j][i] = true;
    				if(i - j + 1 > max){
    					max = i - j + 1;
    					start = j;
    					end = i;
    				}
    			}
    		}
    	}
    	
    	return s.substring(start, end+1);
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().longestPalindrome("aa"));
	}
}