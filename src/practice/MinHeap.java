package practice;

import java.util.Arrays;

/**
 * Created by zkf on 4/19/16.
 */
public class MinHeap {
    int[] array;
    int len;
    public MinHeap(int[] array) {
        this.array = array;
        len = array.length;
        heapify();
    }

    public void add(int val) {
        if (len == array.length) {
            array = Arrays.copyOf(array, len << 1);
        }
        siftUp(len++, val);
    }

    public int pop() {
        int ret = array[0];
        len--;
        siftDown(0, array[len]);
        return ret;
    }

    private void heapify() {
        for (int idx = (len >>> 1) - 1; idx >= 0; idx--) {
            siftDown(idx, array[idx]);
        }
    }

    private void siftDown(int idx, int val) {
        while (idx < (len >>> 1)) {
            int c = (idx << 1) + 1;
            if (c + 1 < len && array[c+1] < array[c])
                c++;
            if (val <= array[c])
                break;

            array[idx] = array[c];
            idx = c;
        }
        array[idx] = val;
    }

    private void siftUp(int idx, int val) {
        while (idx > 0) {
            int p = (idx - 1) >>> 1;
            if (array[p] <= val)
                break;

            array[idx] = array[p];
            idx = p;
        }
        array[idx] = val;
    }

    void print() {
        System.out.println(Arrays.toString(array) + ", len : " + len);
    }

    public static void main(String[] args) {
        MinHeap heap = new MinHeap(new int[]{9});
        heap.print();
        heap.add(3);
        heap.add(2);
        heap.add(5);
        heap.add(51);
        heap.print();
        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(heap.pop());
        heap.print();
        heap.add(3);
        heap.add(2);
        heap.add(5);
        heap.add(51);
        heap.print();
        System.out.println(heap.pop());
        heap.print();
    }
}
