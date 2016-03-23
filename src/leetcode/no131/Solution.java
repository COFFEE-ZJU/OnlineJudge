package leetcode.no131;

import java.util.LinkedList;
import java.util.List;

public class Solution {
	List<List<String>> list = new LinkedList<List<String>>();
	String str;
	
	private boolean isPalin(int s, int e){
		if(e < s) return false;
		for(int i = s; i <= (s+e)/2; i++){
			if(str.charAt(i) != str.charAt(s+e-i))
				return false;
		}
		return true;
	}
	
	private void innerPart(List<String> curList, int start){
		if(start >= str.length()){
			list.add(curList);
			return;
		}
		
		int idx = start - 1;
		char curChar = str.charAt(start);
		List<String> dupList = null;
		while((idx = str.indexOf(curChar, idx + 1)) != -1){
			if(isPalin(start, idx)){
				dupList = new LinkedList<String>(curList);
				dupList.add(str.substring(start, idx+1));
				innerPart(dupList, idx+1);
			}
		}
		
	}
    public List<List<String>> partition(String s) {
        str = s;
        list.clear();
        if(str == null || str.length() == 0) return list;
        
        innerPart(new LinkedList<String>(), 0);
        
        return list;
    }
    
    public static void main(String[] args) {
		for(List<String> list: new Solution().partition("abbab")){
			for(String s: list)
				System.out.print(s+", ");
			System.out.println();
		}
	}
}