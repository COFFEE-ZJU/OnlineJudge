package cn.edu.zju.coffee.poj.no2186;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt(), m = scanner.nextInt();
		Graph g = new Graph(n);
		for(int i = 0; i < m; i++){
			int a = scanner.nextInt(), b = scanner.nextInt();
			g.addRelation(a, b);
		}
		
		System.out.println(g.calcPopularNum());
		
		scanner.close();
	}
}

class Node{
	int id;
	List<Node> nodes;
	
	public Node(int id) {
		this.id = id;
		nodes = new LinkedList<Node>();
	}
	
	public void addNode(Node node){
		nodes.add(node);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Node - id: " + id);
		sb.append("; nodes: ");
		for(Node n : nodes)
			sb.append(n.id + ", ");
		sb.append("\n");
		return sb.toString();
	}
	
}

class Graph{
	Node[] allNodes;
	int num;
	
	public Graph(int num){
		this.num = num;
		allNodes = new Node[num];
		for(int i = 0; i < num; i++)
			allNodes[i] = new Node(i);
	}
	
	public void addRelation(int id1, int id2){
		allNodes[id2 - 1].addNode(allNodes[id1 - 1]);
	}
	
	public int calcPopularNum(){
		Set<Node> nodesVisited = new HashSet<Node>();
		Queue<Node> nodes2Visit = new LinkedList<Node>();
		int popNum = 0;
		for(Node node : allNodes){
			nodesVisited.clear();
			nodes2Visit.clear();
			nodesVisited.add(node);
			nodes2Visit.add(node);
			
			while(! nodes2Visit.isEmpty()){
				Node n = nodes2Visit.poll();
				for(Node nn: n.nodes){
					if(nodesVisited.contains(nn))
						continue;
					
					nodes2Visit.add(nn);
					nodesVisited.add(nn);
				}
			}
			
			if(nodesVisited.size() == num)
				popNum ++;
		}
		
		return popNum;
	}
}
