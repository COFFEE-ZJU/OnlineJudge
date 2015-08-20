package cn.edu.zju.coffee.poj.no1182;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		
		UnionFind uf = new UnionFind(n);
		int fakeCnt = 0;
		
		for(int i = 0; i< m; i++){
			int type = scanner.nextInt() - 1;
			if(! uf.rel(scanner.nextInt() - 1, scanner.nextInt() - 1, type)){
				fakeCnt ++;
				System.out.println("fake");
			}
			else
				System.out.println("true");
		}
		
		System.out.println(fakeCnt);
		
		scanner.close();
	}
}

class UnionFind{
	private int[] id;
	private int[] relation;
	private int num;
	public UnionFind(int n){
		if(n <= 0)
			throw new IllegalArgumentException();
		num = n;
		id = new int[n];
		relation = new int[n];
		for(int i = 0; i<n; i++)
			id[i] = i;
	}
	
	public boolean rel(int a, int b, int type){
		if(a >= num || b >= num)
			return false;
		
		if(type == 1 && a == b)
			return false;
		
		int aRel = 0, bRel = 0, aRoot = a, bRoot = b;
		while(aRoot != id[aRoot]){
			aRel += relation[aRoot];
			aRoot = id[aRoot];
		}
		id[a] = aRoot;
		aRel = aRel % 3;
		relation[a] = aRel;
		
		while(bRoot != id[bRoot]){
			bRel += relation[bRoot];
			bRoot = id[bRoot];
		}
		id[b] = bRoot;
		bRel = bRel % 3;
		relation[b] = bRel;
		
		if(aRoot == bRoot)
			return (aRel+3-bRel) % 3 == type;
		
		int newRel = (bRel+3-aRel+type) % 3;
		id[aRoot] = bRoot;
		relation[aRoot] = newRel;
		
		return true;
	}
}