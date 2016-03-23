package leetcode.no284;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PeekingIterator implements Iterator<Integer> {
    private final Iterator<Integer> iterator;
    private Integer next;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        if (iterator.hasNext()) next = iterator.next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (next == null) throw new NoSuchElementException();
        Integer ret = next;
        if (iterator.hasNext()) next = iterator.next();
        else next = null;

        return ret;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }
}
