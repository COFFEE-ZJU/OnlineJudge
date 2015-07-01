package cn.edu.zju.coffee.poj.no1611;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true){
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			if(m == n && m == 0)
				break;
			
			UnionFind uf = new UnionFind(n);
			
			for(int i = 0; i< m; i++){
				int size = scanner.nextInt();
				if(size <= 0) continue;

				int first = scanner.nextInt();
				for(int j = 0; j < size-1; j++){
					uf.union(scanner.nextInt(), first);
				}
			}
			
			System.out.println(uf.getSubunionSize(0));
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
		for(int i = 0; i<n; i++){
			id[i] = i;
			size[i] = 1;
		}
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
	
	public int getSubunionSize(int p){
		return size[getRootId(p)];
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