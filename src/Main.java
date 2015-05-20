import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class TracelInfoCenter{
	private Node[] cities;
	public TracelInfoCenter(int cityNum) {
		if(cityNum < 1)
			throw new IllegalArgumentException("city number must be positive");
		
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
		cities[city1].addAdjcentNode(cities[city2]);
		cities[city2].addAdjcentNode(cities[city1]);
	}
	
	public void addFestiveCity(int cityNo){
		checkCityNoRange(cityNo);
		
		cities[cityNo - 1].becomesFestiveCity();
	}
	
	public int getMinDistToFestiveCity(int cityNo){
		checkCityNoRange(cityNo);
		
		return cities[cityNo - 1].minDist;
	}

	private void checkCityNoRange(int cityNo){
		if(cityNo < 1 || cityNo > cities.length)
			throw new IllegalArgumentException(
					"city No. should be in the range of 1 and " + cities.length);
	}

	class Node{
		List<Node> adjacentNodes;
		int minDist;
//		int cityNo;
		Node(){
//			cityNo = no;
			minDist = Integer.MAX_VALUE;
			adjacentNodes = new LinkedList<Node>();
		}
		
		/**
		 * add adjacentNode of this node
		 * assume one node will only be added once
		 * @param adjcentNode
		 */
		void addAdjcentNode(Node adjcentNode){
			adjacentNodes.add(adjcentNode);
		}
		
		/**
		 * invoked when this node becomes a festive city
		 * updated minDist of all nodes needed
		 */
		void becomesFestiveCity(){
			if(minDist == 0) return;	// already a festive city
			
			minDist = 0;
			for(Node node: adjacentNodes)
				node.refreshMinDistFromHere(1);
		}
		
		void refreshMinDistFromHere(int dist){
			if(dist >= minDist) return;
			
			minDist = dist;
			for(Node node: adjacentNodes)
				node.refreshMinDistFromHere(dist + 1);
		}
	}
}

public class Main {
	public static void test(){
		TracelInfoCenter tic = new TracelInfoCenter(5);
		tic.setAjacent(1, 2);
		tic.setAjacent(1, 3);
		tic.setAjacent(3, 4);
		tic.setAjacent(3, 5);
		
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
		
		tic.addFestiveCity(1);
		
		for(int i = 0; i < m; i++){
			if(scanner.nextInt() == 1)
				tic.addFestiveCity(scanner.nextInt());
			else
				System.out.println(tic.getMinDistToFestiveCity(scanner.nextInt()));
		}
	}

}
