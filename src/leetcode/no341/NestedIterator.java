package leetcode.no341;

/**
 * Created by Zhangkefei on 2016/4/17.
 */

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
    private static class MyNestInt {
        Iterator<NestedInteger> niit;
        MyNestInt next;
    }

    private MyNestInt cur;
    private Integer cachedNext;

    public NestedIterator(List<NestedInteger> nestedList) {
        cur = new MyNestInt();
        cur.niit = nestedList.iterator();
        cachedNext = next0();
    }

    private Integer next0() {
        if (cur == null) return null;

        if (cur.niit.hasNext()) {
            NestedInteger ni = cur.niit.next();
            if (ni.isInteger())
                return ni.getInteger();
            MyNestInt next = new MyNestInt();
            next.niit = ni.getList().iterator();
            next.next = cur;
            cur = next;
        }
        else
            cur = cur.next;

        return next0();
    }

    @Override
    public Integer next() {
        if (!hasNext()) return null;

        Integer ret = cachedNext;
        cachedNext = next0();
        return ret;
    }

    @Override
    public boolean hasNext() {
        return cachedNext != null;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */