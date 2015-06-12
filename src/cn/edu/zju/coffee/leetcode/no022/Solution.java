package cn.edu.zju.coffee.leetcode.no022;

import java.util.LinkedList;
import java.util.List;

public class Solution {
	private List<String> list = new LinkedList<String>();
	
	private void genParan(int n, int cur, int extra, String str){
		if(n == cur && extra == 0){
			list.add(str);
			return;
		}
		
		if(n != cur)
			genParan(n, cur+1, extra+1, str+'(');
		if(extra != 0)
			genParan(n, cur, extra-1, str+')');
	}
	
    public List<String> generateParenthesis(int n) {
        list.clear();
        genParan(n, 0, 0, "");
        return list;
    }
    
    public static void main(String[] args) {
    	List<String> list = new Solution().generateParenthesis(3);
    	for(String s: list)
    		System.out.print(s+", ");
	}
}