package cn.edu.zju.coffee.leetcode.no223;

public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        return (int)(calcOne(A, B, C, D) + calcOne(E, F, G, H) -
                calcOne(Math.max(A,E), Math.max(B,F), Math.min(C,G), Math.min(D,H)));
    }

    private long calcOne(long A, long B, long C, long D){
        long r = C-A, c = D-B;
        if (r < 0) r = 0;
        if (c < 0) c = 0;
        return r*c;
    }
	
	public static void main(String[] args) {
		Solution sol = new Solution();
        System.out.println(sol.computeArea(-1500000001,0,-1500000000 ,1 ,1500000000 ,0 ,1500000001 ,1));
    }
}
