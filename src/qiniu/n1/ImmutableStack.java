package qiniu.n1;

import java.util.Stack;

public class ImmutableStack {
    private final Stack<Integer> stack;

    public ImmutableStack() {
        stack = new Stack<>();
    }

    private ImmutableStack(Stack<Integer> st) {
        stack = st;
    }

    ImmutableStack push(int i) {
        Stack<Integer> newSt = new Stack<>();
        newSt.addAll(stack);
        newSt.push(i);
        return new ImmutableStack(newSt);
    }

    ImmutableStack pop() {
        Stack<Integer> newSt = new Stack<>();
        newSt.addAll(stack);
        newSt.pop();
        return new ImmutableStack(newSt);
    }

    int peek() {
        return stack.peek();
    }
}
