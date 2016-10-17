package toutiao.screen.n1;

/**
 * 用数组实现一个队列，有push、pop、isEmpty操作，要求时空复杂度尽可能低
 */
public class Queue {
	private int cap;
	private int idx, len;
	private int[] arr;

	public Queue(int cap) {
		if (cap < 0) throw new IllegalArgumentException();

		this.cap = cap;
		arr = new int[cap];
		idx = len = 0;
	}

	public boolean isEmpty() {
		return len == 0;
	}

	public void push(int x) {
		if (len == cap) throw new IllegalStateException();

		int tail = (idx + len) % cap;;
		arr[tail] = x;
		len++;
	}

	public int pop() {
		if (len == 0) throw new IllegalStateException();

		int ret = arr[idx++];
		idx %= cap;
		len--;
		return ret;
	}
}