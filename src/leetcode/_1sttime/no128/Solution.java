package leetcode._1sttime.no128;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int longestConsecutive(int[] nums) {
    	if(nums == null || nums.length == 0) return 0;
    	
        Set<Integer> set = new HashSet<Integer>();
        for(int num: nums)
        	set.add(num);
        
        int maxLen = 0;
        for(Integer i: nums){
        	int cnt = 0;
        	Integer tmp = i;
        	while(set.contains(tmp)){
        		set.remove(tmp);
        		cnt ++;
        		tmp ++;
        	}
        	tmp = i-1;
        	while(set.contains(tmp)){
        		set.remove(tmp);
        		cnt ++;
        		tmp --;
        	}
        	
        	if(cnt > maxLen)
        		maxLen = cnt;
        }
        
        return maxLen;
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
	}
}