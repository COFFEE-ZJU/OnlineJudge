package cn.edu.zju.coffee.poj2411;

import java.util.Scanner;

public class MondriaansDream {
	long[][] stat;
	int row, col;
	
	private void dfs(int r, int c, int prev, int cur){
		if(c > col){
			stat[r][cur] += stat[r-1][prev];
			return;
		}
		
		if(c <= col){
			dfs(r, c+1, (prev << 1) | 1, cur << 1);		// not place tile here
			dfs(r, c+1, prev << 1, (cur << 1) | 1);
		}
		
		if(c < col){
			dfs(r, c+2, (prev << 2) | 3, (cur << 2) | 3);
		}
	}
	
	public long solve(int r, int c){
		if(r < c){
			row = c; col = r;
		}
		else{
			row = r; col = c;
		}
		stat = new long[row+1][(1<<col)];
		stat[0][(1<<col) - 1] = 1;
		for(int i = 1; i <= row; i++){
			dfs(i,1,0,0);
		}
		
		return stat[row][(1<<col) - 1];
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int r,c;
		MondriaansDream md = new MondriaansDream();
		while(true){
			r = scanner.nextInt();
			c = scanner.nextInt();
			if(r == 0 && c == 0)
				break;
			
			System.out.println(md.solve(r, c));
		}
		scanner.close();
	}
}
