package cn.edu.zju.coffee.wap;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class TravelInfoCenter3{
	private Node[] cities;
	
	private int[] subTreeSize;
	private int[] maxSubTreeSize;
	private boolean[] visited;
	
	private int curTreeSize;
	private int curMinMaxSize;
	private int curRootIdx;
	
	public TravelInfoCenter3(int cityNum) {
		if(cityNum < 1)
			throw new IllegalArgumentException("city number must be positive");
		
		subTreeSize = new int[cityNum];
		maxSubTreeSize = new int[cityNum];
		visited = new boolean[cityNum];
		cities = new Node[cityNum];
		for(int i = 0; i < cityNum; i++)
			cities[i] = new Node();
		
	}
	
	/**
	 * Set city1 and city2 to be adjacent cities
	 * 
	 * @param city1
	 * @param city2
	 */
	public void setAdjacent(int city1, int city2){
		checkCityNoRange(city1);
		checkCityNoRange(city2);
		if(city1 == city2)
			throw new IllegalArgumentException("must be 2 different cities");
		
		city1 --;
		city2 --;
		cities[city1].addAdjcentNode(city2);
		cities[city2].addAdjcentNode(city1);
	}
	
	/**
	 * Invoked after all adjacent cities have been set.
	 * Used to build the trees and set city 1 to be festive city.
	 */
	public void init(){
		build(0);
		addFestiveCity(1);
	}

	public void addFestiveCity(int cityNo){
		checkCityNoRange(cityNo);
		
		cities[cityNo - 1].becomesFestiveCity();
	}

	public int getMinDistToFestiveCity(int cityNo){
		checkCityNoRange(cityNo);
		
		return cities[cityNo - 1].getMinDistToFestiveCity();
	}

	/**
	 * Get the balanced root, and recursively build the tree. 
	 * 
	 * @param nodeIdx node index
	 */
	private void build(int nodeIdx){
		getSizeDfs(nodeIdx, -1);
		curMinMaxSize = curTreeSize = subTreeSize[nodeIdx];
		curRootIdx = -1;
		getBalancedRootDfs(nodeIdx);
		genDistToRoot(curRootIdx);
		visited[curRootIdx] = true;
		
		for(Integer idx: cities[curRootIdx].adjacentNodeIndices){
			if(visited[idx]) continue;
			build(idx);
		}
	}

	/**
	 * Generate distances to balanced root for each node. 
	 * 
	 * @param nodeIdx current node index
	 * @param parentNodeIdx parent's node index
	 * @param dist current distance to balanced root
	 */
	private void genDistToRoot(int nodeIdx){
		List<Integer> nodeIdxList = new LinkedList<Integer>();
		List<Integer> parentIdxList = new LinkedList<Integer>();
		List<Integer> distList = new LinkedList<Integer>();
		nodeIdxList.add(nodeIdx);
		parentIdxList.add(-1);
		distList.add(0);
		while(!nodeIdxList.isEmpty()){
			int idx = nodeIdxList.get(0);
			nodeIdxList.remove(0);
			int parent = parentIdxList.get(0);
			parentIdxList.remove(0);
			int dist = distList.get(0);
			distList.remove(0);
			
			cities[idx].rootIndices.add(curRootIdx);
			cities[idx].rootDists.add(dist);
			
			for(Integer childIdx: cities[idx].adjacentNodeIndices){
				if(parent == childIdx || visited[childIdx]) continue;
				
				nodeIdxList.add(0, childIdx);
				parentIdxList.add(0, idx);
				distList.add(0, dist + 1);
			}
		}
	}
	
	private void getBalancedRootDfs(int nodeIdx){
		List<Integer> nodeIdxList = new LinkedList<Integer>();
		List<Integer> parentIdxList = new LinkedList<Integer>();
		nodeIdxList.add(nodeIdx);
		parentIdxList.add(-1);
		while(!nodeIdxList.isEmpty()){
			int idx = nodeIdxList.get(0);
			nodeIdxList.remove(0);
			int parent = parentIdxList.get(0);
			parentIdxList.remove(0);
			
			int maxSubSize;
			if(curTreeSize - subTreeSize[idx] > maxSubTreeSize[idx])
				maxSubSize = curTreeSize - subTreeSize[idx];
			else
				maxSubSize = maxSubTreeSize[idx];
			
			if(maxSubSize < curMinMaxSize){
				curMinMaxSize = maxSubSize;
				curRootIdx = nodeIdx;
			}
			
			for(Integer childIdx: cities[idx].adjacentNodeIndices){
				if(parent == childIdx || visited[childIdx]) continue;
				
				nodeIdxList.add(0, childIdx);
				parentIdxList.add(0, idx);
			}
		}
	}
	
	/**
	 * Recursively get the balanced root, find the node with minimum Max subtree size.
	 * 
	 * @param nodeIdx node index
	 * @param parentNodeIdx parent's node index
	 */
	private void getBalancedRootDfsBk(int nodeIdx, int parentNodeIdx){
		int maxSubSize;
		if(curTreeSize - subTreeSize[nodeIdx] > maxSubTreeSize[nodeIdx])
			maxSubSize = curTreeSize - subTreeSize[nodeIdx];
		else
			maxSubSize = maxSubTreeSize[nodeIdx];
		
		if(maxSubSize < curMinMaxSize){
			curMinMaxSize = maxSubSize;
			curRootIdx = nodeIdx;
		}
		
		for(Integer idx: cities[nodeIdx].adjacentNodeIndices){
			if(parentNodeIdx == idx || visited[idx]) continue;
			
			getBalancedRootDfsBk(idx, nodeIdx);
		}
	}
	
	/**
	 * Recursively get the sub tree size of this node.
	 * Maintain the max sub tree size of the children of this node.
	 * 
	 * @param nodeIdx node index
	 * @param parentNodeIdx parent's node index
	 */
	private void getSizeDfs(int nodeIdx, int parentNodeIdx){
		subTreeSize[nodeIdx] = 1;
		maxSubTreeSize[nodeIdx] = 0;
		for(Integer idx: cities[nodeIdx].adjacentNodeIndices){
			if(parentNodeIdx == idx || visited[idx]) continue;
			
			getSizeDfs(idx, nodeIdx);
			subTreeSize[nodeIdx] += subTreeSize[idx];
			
			if(subTreeSize[idx] > maxSubTreeSize[nodeIdx])
				maxSubTreeSize[nodeIdx] = subTreeSize[idx];
		}
	}
	
	private void checkCityNoRange(int cityNo){
		if(cityNo < 1 || cityNo > cities.length)
			throw new IllegalArgumentException(
					"city No. should be in the range of 1 and " + cities.length);
	}

	class Node{
		List<Integer> adjacentNodeIndices;
		int minDistToSubFestive;
		List<Integer> rootIndices;
		List<Integer> rootDists;
		Node(){
			minDistToSubFestive = Integer.MAX_VALUE;
			adjacentNodeIndices = new LinkedList<Integer>();
			rootIndices = new LinkedList<Integer>();
			rootDists = new LinkedList<Integer>();
		}
		
		/**
		 * add adjacentNode of this node
		 * assume one node will only be added once
		 * @param adjcentNodeIdx
		 */
		void addAdjcentNode(int adjcentNodeIdx){
			adjacentNodeIndices.add(adjcentNodeIdx);
		}
		
		/**
		 * invoked when this node becomes a festive city
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

public class Main2_3 {
	public static void test(){
		TravelInfoCenter tic = new TravelInfoCenter(5);
		tic.setAdjacent(1, 2);
		tic.setAdjacent(1, 3);
		tic.setAdjacent(3, 4);
		tic.setAdjacent(3, 5);
		
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
		
		TravelInfoCenter tic = new TravelInfoCenter(n);
		for(int i = 1; i < n; i++)
			tic.setAdjacent(scanner.nextInt(), scanner.nextInt());
		
		tic.init();
		
		for(int i = 0; i < m; i++){
			if(scanner.nextInt() == 1)
				tic.addFestiveCity(scanner.nextInt());
			else
				System.out.println(tic.getMinDistToFestiveCity(scanner.nextInt()));
		}
		
		scanner.close();
	}

}
