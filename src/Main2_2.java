import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class TracelInfoCenter{
	private Node[] cities;
	
	private int[] subTreeSize;
	private int[] maxSubTreeSize;
	private boolean[] visited;
	
	private int curTreeSize;
	private int curMinMaxSize;
	private int curRootIdx;
	
	public TracelInfoCenter(int cityNum) {
		if(cityNum < 1)
			throw new IllegalArgumentException("city number must be positive");
		
		subTreeSize = new int[cityNum];
		maxSubTreeSize = new int[cityNum];
		visited = new boolean[cityNum];
		cities = new Node[cityNum];
		for(int i = 0; i < cityNum; i++)
			cities[i] = new Node();
		
	}
	
	public void setAjacent(int city1, int city2){
		checkCityNoRange(city1);
		checkCityNoRange(city2);
		if(city1 == city2)
			throw new IllegalArgumentException("must be 2 different cities");
		
		city1 --;
		city2 --;
		cities[city1].addAdjcentNode(city2);
		cities[city2].addAdjcentNode(city1);
	}
	
	private void genDistToRoot(int nodeIdx, int parentNodeIdx, int dist){
		cities[nodeIdx].rootIndices.add(curRootIdx);
		cities[nodeIdx].rootDists.add(dist);
		
		for(Integer idx: cities[nodeIdx].adjacentNodes){
			if(parentNodeIdx == idx || visited[idx]) continue;
			
			genDistToRoot(idx, nodeIdx, dist + 1);
		}
	}
	
	private void getBalancedRootDfs(int nodeIdx, int parentNodeIdx){
		int maxSubSize;
		if(curTreeSize - subTreeSize[nodeIdx] > maxSubTreeSize[nodeIdx])
			maxSubSize = curTreeSize - subTreeSize[nodeIdx];
		else
			maxSubSize = maxSubTreeSize[nodeIdx];
		
		if(maxSubSize < curMinMaxSize){
			curMinMaxSize = maxSubSize;
			curRootIdx = nodeIdx;
		}
		
		for(Integer idx: cities[nodeIdx].adjacentNodes){
			if(parentNodeIdx == idx || visited[idx]) continue;
			
			getBalancedRootDfs(idx, nodeIdx);
		}
	}
	
	private void getSizeDfs(int nodeIdx, int parentNodeIdx){
		subTreeSize[nodeIdx] = 1;
		maxSubTreeSize[nodeIdx] = 0;
		for(Integer idx: cities[nodeIdx].adjacentNodes){
			if(parentNodeIdx == idx || visited[idx]) continue;
			
			getSizeDfs(idx, nodeIdx);
			subTreeSize[nodeIdx] += subTreeSize[idx];
			
			if(subTreeSize[idx] > maxSubTreeSize[nodeIdx])
				maxSubTreeSize[nodeIdx] = subTreeSize[idx];
		}
	}
	
	private void getBalancedRoot(int nodeIdx){
		getSizeDfs(nodeIdx, -1);
		curMinMaxSize = curTreeSize = subTreeSize[nodeIdx];
		curRootIdx = -1;
		getBalancedRootDfs(nodeIdx, -1);
		genDistToRoot(curRootIdx, -1, 0);
		visited[curRootIdx] = true;
		
		for(Integer idx: cities[curRootIdx].adjacentNodes){
			if(visited[idx]) continue;
			getBalancedRoot(idx);
		}
	}
	
	public void init(){
		getBalancedRoot(0);
	}
	
	public void addFestiveCity(int cityNo){
		checkCityNoRange(cityNo);
		
		cities[cityNo - 1].becomesFestiveCity();
	}
	
	public int getMinDistToFestiveCity(int cityNo){
		checkCityNoRange(cityNo);
		
		return cities[cityNo - 1].getMinDistToFestiveCity();
	}

	private void checkCityNoRange(int cityNo){
		if(cityNo < 1 || cityNo > cities.length)
			throw new IllegalArgumentException(
					"city No. should be in the range of 1 and " + cities.length);
	}

	class Node{
		List<Integer> adjacentNodes;
		int minDistToSubFestive;
		List<Integer> rootIndices;
		List<Integer> rootDists;
		Node(){
			minDistToSubFestive = Integer.MAX_VALUE;
			adjacentNodes = new LinkedList<Integer>();
			rootIndices = new LinkedList<Integer>();
			rootDists = new LinkedList<Integer>();
		}
		
		/**
		 * add adjacentNode of this node
		 * assume one node will only be added once
		 * @param adjcentNode
		 */
		void addAdjcentNode(int adjcentNodeIdx){
			adjacentNodes.add(adjcentNodeIdx);
		}
		
		/**
		 * invoked when this node becomes a festive city
		 * updated minDist of all nodes needed
		 */
		void becomesFestiveCity(){
			if(minDistToSubFestive == 0) return;	// already a festive city
			
			minDistToSubFestive = 0;
			
			Iterator<Integer> itIdx = rootIndices.iterator();
			Iterator<Integer> itDist = rootDists.iterator();
			while(itIdx.hasNext()){
				int idx = itIdx.next();
				int dist = itDist.next();
				if(cities[idx].minDistToSubFestive > dist)
					cities[idx].minDistToSubFestive = dist;
			}
		}
		
		int getMinDistToFestiveCity(){
//			int minDist = minDistToSubFestive;
			int minDist = Integer.MAX_VALUE;
			Iterator<Integer> itIdx = rootIndices.iterator();
			Iterator<Integer> itDist = rootDists.iterator();
			while(itIdx.hasNext()){
				int idx = itIdx.next();
				int dist = itDist.next();
				if(minDist - dist > cities[idx].minDistToSubFestive)
					minDist = cities[idx].minDistToSubFestive + dist;
			}
			
			return minDist;
		}
	}
}

public class Main2_2 {
	public static void test(){
		TracelInfoCenter tic = new TracelInfoCenter(5);
		tic.setAjacent(1, 2);
		tic.setAjacent(1, 3);
		tic.setAjacent(3, 4);
		tic.setAjacent(3, 5);
		
		tic.init();
		tic.addFestiveCity(1);
		
		System.out.println(tic.getMinDistToFestiveCity(5));
		System.out.println(tic.getMinDistToFestiveCity(3));
		
		tic.addFestiveCity(3);
		System.out.println(tic.getMinDistToFestiveCity(3));
		System.out.println(tic.getMinDistToFestiveCity(4));
	}

	public static void main(String[] args) {
//		test();
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		
		TracelInfoCenter tic = new TracelInfoCenter(n);
		for(int i = 1; i < n; i++)
			tic.setAjacent(scanner.nextInt(), scanner.nextInt());
		
		tic.init();
		tic.addFestiveCity(1);
		
		for(int i = 0; i < m; i++){
			if(scanner.nextInt() == 1)
				tic.addFestiveCity(scanner.nextInt());
			else
				System.out.println(tic.getMinDistToFestiveCity(scanner.nextInt()));
		}
	}

}
