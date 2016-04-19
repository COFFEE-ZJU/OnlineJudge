package practice;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Zhangkefei on 2016/4/17.
 */
public class QuickSort {

    private static void qSort(int[] array, int start, int end) {
        if (start >= end) return;

        int left = start, right = end;
        int key = array[left];
        while (left < right) {
            while (left < right && array[right] >= key)
                right--;

            array[left] = array[right];

            while (left < right && array[left] <= key)
                left++;

            array[right] = array[left];
        }
        array[left] = key;
        qSort(array, start, left-1);
        qSort(array, left+1, end);
    }
    public static void qSort(int[] array) {
        qSort(array, 0, array.length-1);
    }

    public static void main(String[] args) {
        Random rand = new Random(System.currentTimeMillis());
        for (int i = 0; i < 1000; i++) {
            int[] arr1 = new int[i];
            for (int j = 0; j < i; j++) {
                arr1[j] = rand.nextInt();
            }
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);

            qSort(arr1);
            Arrays.sort(arr2);
            if (!Arrays.equals(arr1, arr2)) {
                System.out.println("tests not passed!");
                return;
            }
        }

        System.out.println("random tests passed!");
    }
}
