package cn.edu.zju.coffee.no003;

public class Solution {
	private int[] idxMap = new int[128];
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        for(int i = 0; i < 128; i++)
        	idxMap[i] = -1;
        int maxLen = 1, start = 0, end = 1;
        idxMap[s.charAt(0)] = 0;
        while(end < s.length()){
        	int idx = idxMap[s.charAt(end)];
        	idxMap[s.charAt(end)] = end;
        	if(idx >= start)
        		start = idx + 1;
        	
        	if(maxLen < end - start + 1)
        		maxLen = end - start + 1;
        	
        	end ++;
        }
        
        return maxLen;
    }
    
    public static void main(String[] args) {
		int res = new Solution().lengthOfLongestSubstring("abccccbbbcabcbb");
		System.out.println(res);
	}
}