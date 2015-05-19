package cn.edu.zju.coffee.no188;

import java.util.LinkedList;
import java.util.List;

public class Solution {
	public int maxProfit(int k, int[] prices) {
		if(prices.length <= 1) return 0;
		
        List<Integer> ups = new LinkedList<Integer>();
        List<Integer> downs = new LinkedList<Integer>();
        
        int prev = prices[0];
        boolean isUp = true;
        for(int i = 1; i < prices.length; i++){
        	
        }
        
        return -1; //TODO
    }
	
	public static void main(String[] args) {
		
	}
}
