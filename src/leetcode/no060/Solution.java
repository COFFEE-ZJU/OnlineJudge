package leetcode.no060;

import java.util.LinkedList;
import java.util.List;

public class Solution {
	static private long[] facts = new long[10];
	static{
		facts[0] = 1;
		for(int i = 1; i<10; i++)
			facts[i] = facts[i-1] * i; 
	}
	
	private String getPerm(List<Integer> list, int k){
		int n = list.size();
		int idx = k / (int)facts[n-1];
		int cur = list.remove(idx);
		if(list.isEmpty())
			return ""+cur;
		return cur+getPerm(list, k % (int)facts[n-1]);
	}
	
    public String getPermutation(int n, int k) {
        List<Integer> list = new LinkedList<Integer>();
        for(int i = 1; i<=n; i++)
        	list.add(i);
        
        return getPerm(list, k-1);
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().getPermutation(3, 6));
	}
}