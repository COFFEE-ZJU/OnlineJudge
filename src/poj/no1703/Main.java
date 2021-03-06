package poj.no1703;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for(int it = 0; it < t; it++){
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			
			UnionFind uf = new UnionFind(n);
			
			for(int i = 0; i< m; i++){
				char c = scanner.next().charAt(0);
				int p = scanner.nextInt(), q = scanner.nextInt();
				if(c == 'A')
					System.out.println(uf.judge(p - 1, q - 1));
				else if(c == 'D')
					uf.diff(p - 1, q - 1);
			}
		}
		scanner.close();
	}
}

class UnionFind{
	private int[] id;
	private int[] size;
	private Map<Integer, Integer> oppositeMap;
	public UnionFind(int n){
		if(n <= 0)
			throw new IllegalArgumentException();
		id = new int[n];
		size = new int[n];
		for(int i = 0; i<n; i++){
			id[i] = i;
			size[i] = 1;
		}
		oppositeMap = new HashMap<Integer, Integer>();
	}
	
	public void diff(int p, int q){
		int rp = getRootId(p), rq = getRootId(q);
		Integer rpOppo = oppositeMap.get(rp), rqOppo = oppositeMap.get(rq);
		int newq = rq, newp = rp;
		
		if(rpOppo != null){
			newq = union(rpOppo, rq);
			oppositeMap.remove(rpOppo);
		}
		if(rqOppo != null){
			newp = union(rqOppo, rp);
			oppositeMap.remove(rqOppo);
		}
		
		oppositeMap.remove(rp);
		oppositeMap.remove(rq);
		oppositeMap.put(newp, newq);
		oppositeMap.put(newq, newp);
	}
	
	public String judge(int p, int q){
		int pid = getRootId(p), qid = getRootId(q);
		if(pid == qid)
			return "In the same gang.";
		
		if(oppositeMap.get(qid) == pid)
			return "In different gangs.";
		
		return "Not sure yet.";
	}
	
	private int union(int rp, int rq){
		if(rp == rq) return rp;
		
		if(size[rp] < size[rq]){
			id[rp] = rq;
			size[rq] += size[rp];
			return rq;
		}
		else{
			id[rq] = rp;
			size[rp] += size[rq];
			return rp;
		}
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