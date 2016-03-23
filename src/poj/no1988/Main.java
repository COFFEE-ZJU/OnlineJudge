package poj.no1988;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		UnionFind uf = new UnionFind();
		for(int it = 0; it < t; it++){
			char c = scanner.next().charAt(0);
			
			if(c == 'C')
				System.out.println(uf.count(scanner.nextInt()));
			else if(c == 'M')
				uf.move(scanner.nextInt(), scanner.nextInt());
		}
		scanner.close();
	}
}

class UnionFind{
	private Map<Integer, Integer> id = new HashMap<Integer, Integer>();
	private Map<Integer, Integer> downCnt = new HashMap<Integer, Integer>();
	private Map<Integer, Integer> size = new HashMap<Integer, Integer>();
	
	private int getId(int i){
		return id.getOrDefault(i, i);
	}
	
	private int getDownCnt(int i){
		return downCnt.getOrDefault(i, 0);
	}
	
	private int getSize(int i){
		return size.getOrDefault(i, 1);
	}
	
	public boolean move(int up, int down){
		int rup = getRootId(up), rdown = getRootId(down);
		if(rup == rdown)
			return false;
		
		downCnt.put(rup, getSize(rdown));
		size.put(rdown, getSize(rdown) + getSize(rup));
		id.put(rup, rdown);
		
		return true;
	}
	
	public int count(int p){
		int cnt = 0, i = p;
		while(i != getId(i)){
			cnt += getDownCnt(i);
			i = getId(i);
		}
		
		id.put(p, i);
		downCnt.put(p, cnt);
		
		return cnt;
	}
	
	public boolean find(int p, int q){
		return getRootId(p) == getRootId(q);
	}
	
	private int getRootId(int p){
		int i = getId(p);
		while(i != getId(i))
			i = getId(i);
		return i;
	}
}