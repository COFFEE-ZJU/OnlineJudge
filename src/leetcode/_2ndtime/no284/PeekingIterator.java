package leetcode._2ndtime.no284;

import java.util.Iterator;

/**
 * Whiteboard coding!
 */
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
public class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iter;
    Integer next = null;
    boolean cached = false;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        iter = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (!cached) {
            next = iter.next();
            cached = true;
        }
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (cached) {
            cached = false;
            return next;
        }
        return iter.next();
    }

    @Override
    public boolean hasNext() {
        return cached || iter.hasNext();
    }
}