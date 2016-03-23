package wap;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class TravelInfoCenter{
	private Node[] cities;
	
	private int[] subTreeSize;	// the subtree size of this node 
	private int[] maxSubTreeSize;	// the max subtree size among the children of this node
	private boolean[] visited;	// whether the node has been processed
	
	private int curTreeSize;	// the subtree size currently used
	private int curMinMaxSize;	// max subtree size of children of the current root node
	private int curRootIdx;		// index of the current root node
	
	public TravelInfoCenter(int cityNum) {
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
		//get the sizes of each node in this subtree, with nodeIdx as root
		getSizeDfs(nodeIdx, -1);
		
		//get the balanced root of this subtree, stored in curRootIdx
		curMinMaxSize = curTreeSize = subTreeSize[nodeIdx];
		curRootIdx = -1;
		getBalancedRootDfs(nodeIdx, -1);
		
		//generate distances to this root node, for all the nodes in this subtree
		genDistToRoot(curRootIdx, -1, 0);
		visited[curRootIdx] = true;		//set the root to be visited
		
		//recursively build the subtrees
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
	private void genDistToRoot(int nodeIdx, int parentNodeIdx, int dist){
		//store distance information in Nodes
		cities[nodeIdx].rootIndices.add(curRootIdx);
		cities[nodeIdx].rootDists.add(dist);
		
		//recursively visit children nodes
		for(Integer idx: cities[nodeIdx].adjacentNodeIndices){
			if(parentNodeIdx == idx || visited[idx]) continue;
			
			genDistToRoot(idx, nodeIdx, dist + 1);
		}
	}
	
	/**
	 * Recursively get the balanced root, find the node with minimum Max subtree size.
	 * 
	 * @param nodeIdx node index
	 * @param parentNodeIdx parent's node index
	 */
	private void getBalancedRootDfs(int nodeIdx, int parentNodeIdx){
		//get max size of subtrees of this node
		int maxSubSize;
		if(curTreeSize - subTreeSize[nodeIdx] > maxSubTreeSize[nodeIdx])
			maxSubSize = curTreeSize - subTreeSize[nodeIdx];
		else
			maxSubSize = maxSubTreeSize[nodeIdx];
		
		//if this node is best till now, update
		if(maxSubSize < curMinMaxSize){
			curMinMaxSize = maxSubSize;
			curRootIdx = nodeIdx;
		}
		
		//recursively visit children nodes
		for(Integer idx: cities[nodeIdx].adjacentNodeIndices){
			if(parentNodeIdx == idx || visited[idx]) continue;
			
			getBalancedRootDfs(idx, nodeIdx);
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
		subTreeSize[nodeIdx] = 1;		//include this node
		maxSubTreeSize[nodeIdx] = 0;	//exclude this node
		
		//recursively get the size of children and add up
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

	/**
	 * Class used to represent a city
	 *
	 */
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
			
			//update all the root nodes of this node
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
			int minDist = Integer.MAX_VALUE;
			
			//visit all the root nodes of this node, get the minimum distance
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
	public static void main(String[] args) {
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
