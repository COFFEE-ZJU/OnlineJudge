package leetcode._1sttime.no058;

public class Solution {
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) return 0;
        
        char[] chs = s.toCharArray();
        int end = -1, start = -1;
        for(int i = chs.length-1; i >= 0; i--){
        	if(chs[i] == ' '){
        		if(end != -1)
        			break;
        		else
        			continue;
        	}
        	else{
        		if(end == -1)
        			end = i + 1;
        		start = i;
        	}
        }
        
        return end-start;
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().lengthOfLastWord(" hello World  "));
	}
}