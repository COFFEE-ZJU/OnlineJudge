package cn.edu.zju.coffee.google.codejam.no6234486;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainA {
	private static int getIndex(String name, Map<String, Integer> nameMap){
		Integer idx = nameMap.get(name);
		if(idx == null){
			idx = nameMap.size();
			nameMap.put(name, idx);
		}
		
		return idx;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new File("resources/google/codejam/no6234486/A-small-practice-2.in"));
		FileWriter writer = new FileWriter(new File("resources/google/codejam/no6234486/A-small-practice-2.out"));
		int t = scanner.nextInt();
		Map<String, Integer> nameMap = new HashMap<String, Integer>();
		
		for(int tt=0; tt<t; tt++){
			int m = scanner.nextInt();
			UnionFind uf = new UnionFind(2 * m);
			nameMap.clear();
			boolean res = true;
			for(int i=0; i<m; i++){
				String name1 = scanner.next();
				String name2 = scanner.next();
				
				if(res){
					int idx1 = getIndex(name1, nameMap);
					int idx2 = getIndex(name2, nameMap);
					
					res = uf.unionOpposite(idx1, idx2);
				}
			}
			writer.write("Case #" + (tt+1) + (res?": Yes\n":": No\n"));
		}
		
		writer.close();
	}
	
}

class UnionFind{
	private int[] id;
	private int[] size;
	private boolean[] relWithPar;	//true for opposite pair, false otherwise
	private int unionSize;
	public UnionFind(int n){
		if(n <= 0)
			throw new IllegalArgumentException();
		unionSize = n;
		id = new int[n];
		size = new int[n];
		relWithPar = new boolean[n];
		for(int i = 0; i<n; i++)
			id[i] = i;
	}
	
	public boolean unionOpposite(int p, int q){
		int rp = getRootId(p), rq = getRootId(q);
		if(rp == rq){
			if(relWithPar[p] == relWithPar[q])	//already same side
				return false;
			else	//already opposite
				return true;
		}
		if(size[rp] < size[rq]){
			id[rp] = rq;
			size[rq] += size[rp];
			relWithPar[rp] = !(relWithPar[p] ^ relWithPar[q]);
		}
		else{
			id[rq] = rp;
			size[rp] += size[rq];
			relWithPar[rq] = !(relWithPar[p] ^ relWithPar[q]);
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
		return i;
	}
}
