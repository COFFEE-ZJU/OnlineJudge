package leetcode._1sttime.no155;

import java.util.Stack;
import java.util.TreeMap;

public class MinStack {
	private Stack<Integer> min = new Stack<>();
	private Stack<Integer> stack = new Stack<>();

	public void push(int x) {
		stack.push(x);
		if (min.isEmpty() || min.peek() >= x) min.push(x);
	}

	public void pop() {
		Integer x = stack.pop();
		if (min.peek().equals(x)) min.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return min.peek();
	}
}

class MinStackSlow {
	private TreeMap<Integer, Integer> pq = new TreeMap<>();
	private Stack<Integer> stack = new Stack<>();

	public void push(int x) {
		stack.push(x);
		pq.put(x, pq.getOrDefault(x, 0) + 1);
	}

	public void pop() {
		Integer x = stack.pop();
		int c = pq.get(x) - 1;
		if (c == 0) pq.remove(x);
		else pq.put(x, c);
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return pq.firstKey();
	}
}
