package leetcode._2ndtime.no295;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Whiteboard coding!
 */
public class MedianFinder {
    private static final Comparator<Integer> comp = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return Integer.compare(o2, o1);
        }
    };
    private PriorityQueue<Integer> smallOnes = new PriorityQueue<>(11, comp);
    private PriorityQueue<Integer> bigOnes = new PriorityQueue<>();

    // Adds a number into the data structure.
    public void addNum(int num) {
        if (smallOnes.isEmpty()) {
            smallOnes.add(num);
            return;
        }

        int s = smallOnes.peek();
        if (num > s) bigOnes.add(num);
        else smallOnes.add(num);

        while (smallOnes.size() > bigOnes.size() + 1) {
            bigOnes.add(smallOnes.poll());
        }
        while (bigOnes.size() > smallOnes.size() + 1) {
            smallOnes.add(bigOnes.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        int size1 = smallOnes.size(), size2 = bigOnes.size();
        if (size1 == 0 && size2 == 0) return 0;

        if (size1 > size2) return smallOnes.peek();
        if (size2 > size1) return bigOnes.peek();

        return (0.0 + smallOnes.peek() + bigOnes.peek()) / 2;
    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        mf.addNum(3);
        System.out.println(mf.findMedian());
    }
}

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();