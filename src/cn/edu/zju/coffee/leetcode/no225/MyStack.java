package cn.edu.zju.coffee.leetcode.no225;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    private Queue<Integer> queue = new LinkedList<>();
    // Push element x onto stack.
    public void push(int x) {
        queue.add(x);
    }

    private int ppop() {
        int size = queue.size();
        if (size == 0) throw new IllegalStateException();
        for (int i = 0; i < size - 1; i++)
            queue.add(queue.poll());
        return queue.poll();
    }

    // Removes the element on top of the stack.
    public void pop() {
        ppop();
    }

    // Get the top element.
    public int top() {
        int ret = ppop();
        queue.add(ret);
        return ret;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}