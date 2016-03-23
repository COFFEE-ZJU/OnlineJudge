package wap;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class Main2Test {
	private static final int MAX_CITY = 10000;
	private static final Random RAN = new Random(System.currentTimeMillis());
	
	public static void main(String[] args) {
		for(int i = 0; i < 1000; i++)
			random();
	}
	
	public static void random() {
		TravelInfoCenter1 tic1 = new TravelInfoCenter1(MAX_CITY);
		TravelInfoCenter tic2 = new TravelInfoCenter(MAX_CITY);
		long t1, t2, t;
		t1 = t2 = 0;
		
		List<Integer> nodeList1 = new LinkedList<Integer>();
		List<Integer> nodeList2 = new LinkedList<Integer>();
		for(int i = 1; i <= MAX_CITY; i++)
			nodeList1.add(i);
		
		int first = RAN.nextInt(nodeList1.size());
		nodeList2.add(nodeList1.get(first));
		nodeList1.remove(first);
		
		while(!nodeList1.isEmpty()){
			int idx1 = RAN.nextInt(nodeList1.size());
			int idx2 = RAN.nextInt(nodeList2.size());
//			int idx2 = nodeList2.size()-1;
			int node1 = nodeList1.get(idx1);
			int node2 = nodeList2.get(idx2);
			nodeList1.remove(idx1);
			nodeList2.add(node1);
			
			tic1.setAdjacent(node1, node2);
			tic2.setAdjacent(node1, node2);
		}
		t = System.currentTimeMillis();
		tic1.addFestiveCity(1);
		t1 += System.currentTimeMillis() - t;
		
		t = System.currentTimeMillis();
		tic2.init();
		t2 += System.currentTimeMillis() - t;
		
		while(!nodeList2.isEmpty()){
			int idx = RAN.nextInt(nodeList2.size());
			int node = nodeList2.get(idx);
			nodeList2.remove(idx);

			if(RAN.nextBoolean()){
				if(node == 1) continue;
				
				t = System.currentTimeMillis();
				tic1.addFestiveCity(node);
				t1 += System.currentTimeMillis() - t;
				
				t = System.currentTimeMillis();
				tic2.addFestiveCity(node);
				t2 += System.currentTimeMillis() - t;
			}
			else{
				int query = RAN.nextInt(MAX_CITY)+1;
				
				t = System.currentTimeMillis();
				int res1 = tic1.getMinDistToFestiveCity(query);
				t1 += System.currentTimeMillis() - t;
				
				t = System.currentTimeMillis();
				int res2 = tic2.getMinDistToFestiveCity(query);
				t2 += System.currentTimeMillis() - t;
				if(res1 != res2)
					System.err.println("not matched ! r1: "+res1+", r2: "+res2);
			}
		}
		
		System.out.println("t1: "+t1);
		System.out.println("t2: "+t2);
//		System.out.println("t1: "+TimeUnit.MILLISECONDS.toSeconds(t1));
//		System.out.println("t2: "+TimeUnit.MILLISECONDS.toSeconds(t2));
	}

	public static void star() {
		TravelInfoCenter1 tic1 = new TravelInfoCenter1(MAX_CITY);
		TravelInfoCenter tic2 = new TravelInfoCenter(MAX_CITY);
		long t1, t2, t;
		t1 = t2 = 0;
		for(int i = 1; i < MAX_CITY; i++){
			tic1.setAdjacent(i, MAX_CITY);
			tic2.setAdjacent(i, MAX_CITY);
		}
		t = System.currentTimeMillis();
		tic1.addFestiveCity(1);
		t1 += System.currentTimeMillis() - t;
		
		t = System.currentTimeMillis();
		tic2.init();
		t2 += System.currentTimeMillis() - t;
		
		for(int i = MAX_CITY; i >= 2; i--){
			if(RAN.nextBoolean()){
				t = System.currentTimeMillis();
				tic1.addFestiveCity(i);
				t1 += System.currentTimeMillis() - t;
				
				t = System.currentTimeMillis();
				tic2.addFestiveCity(i);
				t2 += System.currentTimeMillis() - t;
			}
			else{
				t = System.currentTimeMillis();
				int res1 = tic1.getMinDistToFestiveCity(i);
				t1 += System.currentTimeMillis() - t;
				
				t = System.currentTimeMillis();
				int res2 = tic2.getMinDistToFestiveCity(i);
				t2 += System.currentTimeMillis() - t;
				if(res1 != res2)
					System.err.println("not matched ! r1: "+res1+", r2: "+res2);
			}
		}
		
		System.out.println("t1: "+t1);
		System.out.println("t2: "+t2);
//		System.out.println("t1: "+TimeUnit.MILLISECONDS.toSeconds(t1));
//		System.out.println("t2: "+TimeUnit.MILLISECONDS.toSeconds(t2));
	}

	public static void line() {
		TravelInfoCenter1 tic1 = new TravelInfoCenter1(MAX_CITY);
		TravelInfoCenter tic2 = new TravelInfoCenter(MAX_CITY);
		long t1, t2, t;
		t1 = t2 = 0;
		for(int i = 1; i < MAX_CITY; i++){
			tic1.setAdjacent(i, i+1);
			tic2.setAdjacent(i, i+1);
		}
		t = System.currentTimeMillis();
		tic1.addFestiveCity(1);
		t1 += System.currentTimeMillis() - t;
		
		t = System.currentTimeMillis();
		tic2.init();
		t2 += System.currentTimeMillis() - t;
		
		for(int i = MAX_CITY; i >= 2; i--){
			if(RAN.nextBoolean()){
				t = System.currentTimeMillis();
				tic1.addFestiveCity(i);
				t1 += System.currentTimeMillis() - t;
				
				t = System.currentTimeMillis();
				tic2.addFestiveCity(i);
				t2 += System.currentTimeMillis() - t;
			}
			else{
				t = System.currentTimeMillis();
				int res1 = tic1.getMinDistToFestiveCity(i);
				t1 += System.currentTimeMillis() - t;
				
				t = System.currentTimeMillis();
				int res2 = tic2.getMinDistToFestiveCity(i);
				t2 += System.currentTimeMillis() - t;
				if(res1 != res2)
					System.err.println("not matched ! r1: "+res1+", r2: "+res2);
			}
		}
		
		System.out.println("t1: "+t1);
		System.out.println("t2: "+t2);
//		System.out.println("t1: "+TimeUnit.MILLISECONDS.toSeconds(t1));
//		System.out.println("t2: "+TimeUnit.MILLISECONDS.toSeconds(t2));
	}
}
