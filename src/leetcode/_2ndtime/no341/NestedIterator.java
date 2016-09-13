package leetcode._2ndtime.no341;

/**
 * Created by Zhangkefei on 2016/4/17.
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/**
 * whiteboard coding!
 *
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    private Deque<Iterator<NestedInteger>> iterStack = new ArrayDeque<>();
    private Integer next = null;

    public NestedIterator(List<NestedInteger> nestedList) {
        iterStack.add(nestedList.iterator());
    }

    @Override
    public Integer next() {
        if (!hasNext()) return null;

        Integer ret = next;
        next = null;
        return ret;
    }

    @Override
    public boolean hasNext() {
        if (next != null) return true;

        while(!iterStack.isEmpty()) {
            Iterator<NestedInteger> it = iterStack.peek();

            while (it.hasNext()) {
                NestedInteger ni = it.next();
                if (ni.isInteger()) {
                    next = ni.getInteger();
                    return true;
                }
                it = ni.getList().iterator();
                iterStack.push(it);
            }


            if (!it.hasNext()){
                iterStack.pop();
            }
        }

        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */