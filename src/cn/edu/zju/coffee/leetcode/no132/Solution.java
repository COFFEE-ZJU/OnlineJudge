package cn.edu.zju.coffee.leetcode.no132;

import java.util.LinkedList;
import java.util.List;

public class Solution {
	List<String> list = new LinkedList<String>();
	String str;
	int minCut = Integer.MAX_VALUE;
	
	private int indexOfRev(char ch, int start, int end){
		for(int i = end; i >= start; i--){
			if(str.charAt(i) == ch)
				return i;
		}
		return -1;
	}

	private boolean isPalin(int s, int e){
		if(e < s) return false;
		for(int i = s; i <= (s+e)/2; i++){
			if(str.charAt(i) != str.charAt(s+e-i))
				return false;
		}
		return true;
	}
	
	private void innerPart(int start, int cut){
		if(cut > minCut) return;
		if(start >= str.length()){
			if(minCut > cut)
				minCut = cut;
			return ;
		}
		
		int idx = str.length();
		char curChar = str.charAt(start);
		while((idx = indexOfRev(curChar, start, idx - 1)) != -1){
			if(isPalin(start, idx)){
				innerPart(idx+1, cut+1);
			}
		}
		
	}
	public int minCut(String s) {
        str = s;
        if(str == null || str.length() <= 1) return 0;
        
        minCut = Integer.MAX_VALUE;
        innerPart(0, -1);
        return minCut;
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().minCut("apjeasafafwwd"));
	}
}