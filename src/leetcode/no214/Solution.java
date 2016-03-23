package leetcode.no214;

public class Solution {
	
	
    public String shortestPalindrome(String s) {
        if(s == null || s.length() == 0) return s;
        
        char[] ch = s.toCharArray();
        int i = (s.length() - 1) / 2, j = s.length() / 2;
        while(i >= 0){
        	int ii = i, jj = j;
        	while(ii >= 0){
        		if(ch[ii] != ch[jj])
        			break;
        		
        		ii --;
        		jj ++;
        	}
        	
        	if(ii == -1){	//matched
        		StringBuilder sb = new StringBuilder();
        		while(jj < s.length()){
        			sb.insert(0, ch[jj]);
        			jj++;
        		}
        		sb.append(s);
        		
        		return sb.toString();
        	}
        	
        	if(i == j)
        		i --;
        	else
        		j --;
        }
        
        return null;
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().shortestPalindrome("abcd"));
	}
}