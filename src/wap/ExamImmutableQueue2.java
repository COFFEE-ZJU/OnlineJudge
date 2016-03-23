package wap;


import java.util.NoSuchElementException;

/**
 * The Queue class represents an immutable first-in-first-out (FIFO) queue of objects.
 * @param <E>
 */
public class ExamImmutableQueue2<E> {
	
    private final int length;
    private final IQElement<E> head;
    private final IQElement<E> tail;

    /**
     * Immutable queue element
     */
    private static final class IQElement<E> {
        private final E e;
        private final IQElement<E> prev;

        public IQElement(E e, IQElement<E> prev) {
            this.e = e;
            this.prev = prev;
        }
    }

    /**
     * requires default constructor.
     */
    public ExamImmutableQueue2() {
        this(0, null, null); // length zero
    }

    private ExamImmutableQueue2(IQElement<E> iqe) {
        this(1, iqe, iqe); // length one, head and tail point to the same element
    }

    private ExamImmutableQueue2(int length, IQElement<E> head, IQElement<E> tail) {
        this.length = length;
        this.head = head;
        this.tail = tail;
    }

    // add other constructors if necessary

    /**
     * Returns the queue that adds an item into the tail of this queue without modifying this queue.
     * <pre>
     * e.g.
     * When this queue represents the queue (2, 1, 2, 2, 6) and we enqueue the value 4 into this queue,
     * this method returns a new queue (2, 1, 2, 2, 6, 4)
     * and this object still represents the queue (2, 1, 2, 2, 6) .
     * </pre>
     * If the element e is null, throws IllegalArgumentException.
     * @param e
     * @return
     * @throws IllegalArgumentException
     */
    public ExamImmutableQueue2<E> enqueue(E e) {
        if (e == null) {
            throw new IllegalArgumentException("Enqueue null element");
        }

        IQElement<E> iqe = new IQElement<E>(e, tail);
        
        if(length == 0)
        	return new ExamImmutableQueue2<E>(iqe);
        else
        	return new ExamImmutableQueue2<E>(length + 1, head, iqe);
    }

    /**
     * Returns the queue that removes the object at the head of this queue without modifying this queue.
     * <pre>
     * e.g.
     * When this queue represents the queue (7, 1, 3, 3, 5, 1) ,
     * this method returns a new queue (1, 3, 3, 5, 1)
     * and this object still represents the queue (7, 1, 3, 3, 5, 1) .
     * </pre>
     * If this queue is empty, throws java.util.NoSuchElementException.
     * @return
     * @throws java.util.NoSuchElementException
     */
    public ExamImmutableQueue2<E> dequeue() {
    	if(length == 0)
    		throw new NoSuchElementException("Dequeue empty queue");
    	
    	if(length == 1)
    		return new ExamImmutableQueue2<E>();
    	
    	IQElement<E> curEle = tail;
    	while(curEle.prev != head)
    		curEle = curEle.prev;
    	
    	return new ExamImmutableQueue2<E>(length - 1, curEle, tail);
    }

    /**
     * Looks at the object which is the head of this queue without removing it from the queue.
     * <pre>
     * e.g.
     * When this queue represents the queue (7, 1, 3, 3, 5, 1),
     * this method returns 7 and this object still represents the queue (7, 1, 3, 3, 5, 1)
     * </pre>
     * If the queue is empty, throws java.util.NoSuchElementException.
     * @return
     * @throws java.util.NoSuchElementException
     */
    public E peek() {
        if (this.length == 0) {
            throw new NoSuchElementException("Peek empty queue");
        }

        return head.e;
    }

    /**
     * Returns the number of objects in this queue.
     * @return
     */
    public int size() {
        return length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        IQElement<E> iqe = this.tail;
        for (int i = 0; i < this.length; i++) {
            sb.insert(0, iqe.e + " ");
            iqe = iqe.prev;
        }

        if (sb.length() > 0) {
            sb.delete(sb.length() - 1, sb.length());
        }

        sb.insert(0, '[');
        sb.append(']');

        return sb.toString();
    }

    public static void main(String[] args) {
        ExamImmutableQueue2<Integer> queue1 = new ExamImmutableQueue2<Integer>();
        queue1 = queue1.enqueue(10).enqueue(11).enqueue(12);
        System.out.println(queue1.enqueue(13).dequeue());
        System.out.println(queue1.enqueue(14));
        
        ExamImmutableQueue2<Integer> queue2 = queue1.dequeue().dequeue();
        System.out.println(queue2.enqueue(15).peek());
        
        System.out.println(queue1);
    }
}
