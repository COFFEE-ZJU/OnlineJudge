package leetcode._1sttime.no017;

import java.util.LinkedList;
import java.util.List;

public class Solution {
	private static final char[][] CHARS = new char[][]{
		"abc".toCharArray(),
		"def".toCharArray(),
		"ghi".toCharArray(),
		"jkl".toCharArray(),
		"mno".toCharArray(),
		"pqrs".toCharArray(),
		"tuv".toCharArray(),
		"wxyz".toCharArray(),
	};
	
    public List<String> letterCombinations(String digits) {
    	if(digits == null || digits.length() == 0) return new LinkedList<String>();
    	
    	List<String> l1 = new LinkedList<String>();
    	List<String> l2 = new LinkedList<String>();
    	List<String> t;
    	for(int i = 0; i < digits.length(); i++){
    		if(l1.isEmpty()){
    			for(char c: CHARS[digits.charAt(i)-'2'])
    				l1.add(""+c);
    			continue;
    		}
    		l2.clear();
    		for(String s: l1){
    			for(char c: CHARS[digits.charAt(i)-'2'])
    				l2.add(s+c);
    		}
    		t = l1; l1 = l2; l2 = t;
    	}
    	
    	return l1;
    }
    
    public static void main(String[] args) {
		List<String> l = new Solution().letterCombinations("234");
		for(String s: l)
			System.out.print(s+", ");
	}
}