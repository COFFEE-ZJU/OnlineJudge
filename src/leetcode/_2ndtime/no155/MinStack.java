package leetcode._2ndtime.no155;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Whiteboard coding!
 */
public class MinStack {
    private Deque<Integer> mins, nums;

    /** initialize your data structure here. */
    public MinStack() {
        mins = new ArrayDeque<>();
        nums = new ArrayDeque<>();
    }

    public void push(int x) {
        nums.push(x);
        if (mins.isEmpty() || mins.peek() >= x) mins.push(x);
    }

    public void pop() {
        int x = nums.pop();
        if (x <= mins.peek()) mins.pop();
    }

    public int top() {
        return nums.peek();
    }

    public int getMin() {
        return mins.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */