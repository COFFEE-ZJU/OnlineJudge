package leetcode._1sttime.no187;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
    	List<String> list = new LinkedList<String>();
        if(s == null || s.length() <= 10) 
        	return list;
    	
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i <= s.length() - 10; i++){
        	String cur = s.substring(i, i+10);
        	Integer val = map.get(cur);
        	if(val == null)
        		map.put(cur, 1);
        	else if(val == 1){
        		list.add(cur);
        		map.put(cur, 2);
        	}
        }
        
        return list;
    }
    
    public static void main(String[] args) {
		List<String> l = new Solution().findRepeatedDnaSequences("AAAAAAAAAAA");
		for(String s: l){
			System.out.print(s+", ");
		}
	}
}