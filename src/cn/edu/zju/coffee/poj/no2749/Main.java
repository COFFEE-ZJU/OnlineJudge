package cn.edu.zju.coffee.poj.no2749;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Map.Entry;

public class Main {
	 public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
		 int n = scanner.nextInt();
		 int nHate = scanner.nextInt(), nLike = scanner.nextInt();
		 int s1x = scanner.nextInt(), s1y = scanner.nextInt(), s2x = scanner.nextInt(), s2y = scanner.nextInt();
		 int[] xs = new int[n], ys = new int[n];
		 for(int i = 0; i < n; i ++){
			 xs[i] = scanner.nextInt();
			 ys[i] = scanner.nextInt();
		 }
		 UnionFind uf = new UnionFind(xs, ys, s1x, s1y, s2x, s2y);
		 for(int i = 0; i < nHate; i ++)
			 uf.union(scanner.nextInt()-1, scanner.nextInt()-1, true);
		 for(int i = 0; i < nLike; i ++)
			 uf.union(scanner.nextInt()-1, scanner.nextInt()-1, false);
		 
		 System.out.println(uf.calcMinTotal());
		 
		 scanner.close();
	}
}

class UnionFind{
	class Relation{
		int id;
		boolean rel;
		public Relation(int id, boolean rel) {
			this.id = id;
			this.rel = rel;
		}
	}
	
	private int[] id;
	private int[] size;
	private boolean[] relWithPar;	//true for opposite pair, false otherwise
	private int[] distToS1;
	private int[] distToS2;
	private int unionSize;
	private int pointSize;
	public UnionFind(int[] xs, int[] ys, int s1x, int s1y, int s2x, int s2y){
		
		int n = xs.length;
		pointSize = n;
		unionSize = n;
		id = new int[n];
		size = new int[n];
		distToS1 = new int[n];
		distToS2 = new int[n];
		relWithPar = new boolean[n];
		for(int i = 0; i<n; i++){
			id[i] = i;
			distToS1[i] = calcDist(xs[i], ys[i], s1x, s1y);
			distToS2[i] = calcDist(xs[i], ys[i], s2x, s2y);
		}
	}
	
	private static int calcDist(int x1, int y1, int x2, int y2){
		return (Math.abs(x1-x2) + Math.abs(y1-y2));
	}
	
	public long calcMinTotal(){
		Map<Integer, List<Relation>> rootRels = new HashMap<Integer, List<Relation>>();
		
		Queue<Integer> heap1 = new PriorityQueue<Integer>(), heap2 = new PriorityQueue<Integer>();
		
		for(int i=0; i<pointSize; i++){
			int root = getRootId(i);
			boolean rel = relWithPar[i];
			Relation relation = new Relation(i, rel);
			addRel(rootRels, root, relation);
		}
		
		long sum = 0;
		for(Entry<Integer, List<Relation>> ent: rootRels.entrySet()){
			int root = ent.getKey();
			List<Relation> relList = ent.getValue();
			long tmpSum1 = 0, tmpSum2 = 0;
//			tmpSum1 += distToS1[root];
//			tmpSum2 += distToS2[root];
			for(Relation rel : relList){
				if(rel.rel){	//opposite with root
					tmpSum1 += distToS2[rel.id];
					tmpSum2 += distToS1[rel.id];
				}
				else{			//same side with root
					tmpSum1 += distToS1[rel.id];
					tmpSum2 += distToS2[rel.id];
				}
			}
			sum += Math.min(tmpSum1, tmpSum2);
		}
		
		return sum;
	}
	
	private void addRel(Map<Integer, List<Relation>> rootRels, int root, Relation rel){
		List<Relation> relList = rootRels.get(root);
		if(relList == null){
			relList = new LinkedList<UnionFind.Relation>();
			rootRels.put(root, relList);
		}
		relList.add(rel);
	}
	
	public boolean union(int p, int q, boolean opposite){
		int rp = getRootId(p), rq = getRootId(q);
		if(rp == rq){
			if(relWithPar[p] == relWithPar[q])	//already same side
				return !opposite;
			else	//already opposite
				return opposite;
		}
		if(size[rp] < size[rq]){
			id[rp] = rq;
			size[rq] += size[rp];
			relWithPar[rp] = (relWithPar[p] ^ relWithPar[q]) ^ opposite;
		}
		else{
			id[rq] = rp;
			size[rp] += size[rq];
			relWithPar[rq] = (relWithPar[p] ^ relWithPar[q]) ^ opposite;
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
		boolean rel = relWithPar[p];
		while(i != id[i]){
			rel = rel ^ relWithPar[i];
			i = id[i];
		}
		relWithPar[p] = rel;
		id[p] = i;
		return i;
	}
}
