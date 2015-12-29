package cn.edu.zju.coffee.poj.no2186;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
	
	public boolean addNode(Node node){
		nodes.add(node);
		return nodes.size() == 1;
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
	
	List<Node> stack;
	boolean[] inStack;
	int[] dfn, low;
	int visitCnt = 0, sccCnt = 0;
	List<Integer> sccSize;
	int zeroOutCnt;
	Map<Node, Integer> newNodeMap;
	
	public Graph(int num){
		this.num = num;
		allNodes = new Node[num];
		for(int i = 0; i < num; i++)
			allNodes[i] = new Node(i);
		
	}
	
	public void addRelation(int id1, int id2){
		if(allNodes[id1 - 1].addNode(allNodes[id2 - 1]))
			zeroOutCnt --;
	}
	
	private void tarjan(Node node){
		int i = node.id;
		dfn[i] = visitCnt++;
		low[i] = dfn[i];
		stack.add(0, node);
		inStack[i] = true;
		for(Node n : allNodes[i].nodes){
			if(dfn[n.id] == -1){
				tarjan(n);
				if(low[i] > low[n.id])
					low[i] = low[n.id];
			}
			else if(inStack[n.id] && low[i] > low[n.id]){
				low[i] = low[n.id];
			}
		}
		if(low[i] == dfn[i]){
			int newNodeId = sccCnt++;
			int size = 0;
			Node tn = stack.remove(0);
			newNodeMap.put(tn, newNodeId);
			size ++;
			while(tn != node){
				tn = stack.remove(0);
				newNodeMap.put(tn, newNodeId);
				size ++;
			}
			sccSize.add(size);
		}
	}
	
	private void doTarjan(){
		stack = new LinkedList<Node>();
		inStack = new boolean[num];
		dfn = new int[num];
		for(int i = 0; i < num; i++) dfn[i] = -1;
		low = new int[num];
		zeroOutCnt = num;
		newNodeMap = new HashMap<Node, Integer>();
		sccSize = new LinkedList<Integer>();
		
		for(int i = 0; i < num; i++){
			if(dfn[i] == -1) tarjan(allNodes[i]);
		}
	}
	
	public int calcPopularNum(){
		if(zeroOutCnt > 1)
			return 0;
		else if(zeroOutCnt == 1)
			return 1;
		else{
			doTarjan();
			if(sccCnt == 1)
				return num;
			else{
				Set<Integer> set = new HashSet<Integer>();
				for(int i = 0; i < sccCnt; i++)
					set.add(i);
				
				for(Node n : allNodes){
					int newid = newNodeMap.get(n);
					if(! set.contains(newid))
						continue;
					for(Node nn : n.nodes){
						if(newid != newNodeMap.get(nn)){
							set.remove(newid);
							break;
						}
					}
				}
				
				if(set.size() == 1){
					int newid = set.iterator().next();
					return sccSize.get(newid);
				}
				else
					return 0;
			}
		}
		
	}
}
