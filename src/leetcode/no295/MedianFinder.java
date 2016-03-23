package leetcode.no295;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> smallOnes = new PriorityQueue<>(Comparator.reverseOrder());
    PriorityQueue<Integer> bigOnes = new PriorityQueue<>();
    private boolean even = true;

    // Adds a number into the data structure.
    public void addNum(int num) {
        even = !even;

        if (smallOnes.isEmpty()){
            smallOnes.add(num);
            return;
        }

        if (num <= smallOnes.peek())
            smallOnes.add(num);
        else
            bigOnes.add(num);

        int bs = bigOnes.size(), ss = smallOnes.size();
        if (bs > ss)
            smallOnes.add(bigOnes.poll());
        else if (ss > bs + 1)
            bigOnes.add(smallOnes.poll());

    }

    // Returns the median of current data stream
    public double findMedian() {
        if (even)
            return ((double)smallOnes.peek() + (double)bigOnes.peek()) / 2;
        else
            return smallOnes.peek();
    }

    public static void main(String[] args) {
		MedianFinder mf = new MedianFinder();
        mf.addNum(-1);
        System.out.println(mf.findMedian());
        mf.addNum(-2);
        System.out.println(mf.findMedian());
        mf.addNum(-3);
        System.out.println(mf.findMedian());
        mf.addNum(-4);
        System.out.println(mf.findMedian());
        mf.addNum(-5);
        System.out.println(mf.findMedian());
    }
}
