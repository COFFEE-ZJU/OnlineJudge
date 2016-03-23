package poj.no2524;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cnt = 1;
		while(true){
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			if(m == n && m == 0)
				break;
			
			UnionFind uf = new UnionFind(n);
			
			for(int i = 0; i< m; i++)
				uf.union(scanner.nextInt() - 1, scanner.nextInt() - 1);
			
			System.out.println("Case "+cnt+": "+uf.getUnionSize());
			cnt ++;
		}
		
		scanner.close();
	}
}

class UnionFind{
	private int[] id;
	private int[] size;
	private int unionSize;
	public UnionFind(int n){
		if(n <= 0)
			throw new IllegalArgumentException();
		unionSize = n;
		id = new int[n];
		size = new int[n];
		for(int i = 0; i<n; i++)
			id[i] = i;
	}
	
	public boolean union(int p, int q){
		int rp = getRootId(p), rq = getRootId(q);
		if(rp == rq)
			return false;
		if(size[rp] < size[rq]){
			id[rp] = rq;
			size[rq] += size[rp];
		}
		else{
			id[rq] = rp;
			size[rp] += size[rq];
		}
		
		unionSize --;
		return true;
	}
	
	public boolean find(int p, int q){
		return getRootId(p) == getRootId(q);
	}
	
	public int getUnionSize(){
		return unionSize;
	}
	
	private int getRootId(int p){
		int i = id[p];
		while(i != id[i]){
			id[i] = id[id[i]];
			i = id[i];
		}
		return i;
	}
}