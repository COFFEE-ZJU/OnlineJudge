package cn.edu.zju.coffee.leetcode.no032;

class Node{
	int balance;
	int startIdx;
	Node next;
	public Node(int b, int s) {
		balance = b;
		startIdx = s;
	}
}

public class Solution {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0) return 0;
        
        int max = 0;
        Node endsHere = null, endsHerePrev = null;
        int blcOff = 0;
        for(int i = 0; i<s.length(); i++){
        	if(s.charAt(i) == '('){
        		if(endsHerePrev == null || endsHerePrev.balance + blcOff != 0){
        			endsHere = new Node(0 - blcOff, i);
        			endsHere.next = endsHerePrev;
        		}
        		else 
        			endsHere = endsHerePrev;
        		blcOff ++;
        	}
        	else{
        		if(endsHerePrev != null && endsHerePrev.balance + blcOff == 0)
    				endsHere = endsHerePrev.next;
        		else
        			endsHere = endsHerePrev;
        		
        		blcOff --; 
        	}
        	
        	if(endsHere != null && endsHere.balance + blcOff == 0){
        		int len = i - endsHere.startIdx + 1;
        		if(len > max) max = len;
        	}
        	
        	endsHerePrev = endsHere;
        }
        
        return max;
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().longestValidParentheses("("));
	}
}