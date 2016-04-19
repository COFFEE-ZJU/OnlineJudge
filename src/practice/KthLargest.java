package practice;

/**
 * Created by Zhangkefei on 2016/4/17.
 */
public class KthLargest {
    private static int kthLargest(int[] array, int k, int start, int end) {
        int left = start, right = end;
        int key = array[left];
        while (left < right) {
            while (left < right && array[right] <= key)
                right--;

            array[left] = array[right];
            while (left < right && array[left] >= key)
                left++;

            array[right] = array[left];
        }

        array[left] = key;
        if (left == k) return key;
        else if (left > k)
            return kthLargest(array, k, start, left-1);
        else
            return kthLargest(array, k, left+1, end);
    }

    public static int kthLargest(int[] array, int k) {
        return kthLargest(array, k-1, 0, array.length-1);
    }

    public static void main(String[] args) {
        System.out.println(kthLargest(new int[]{220,14,73,19,1,3,100,55,12,7,100,44,99}, 1));
        System.out.println(kthLargest(new int[]{220,14,73,19,1,3,100,55,12,7,100,44,99}, 2));
        System.out.println(kthLargest(new int[]{220,14,73,19,1,3,100,55,12,7,100,44,99}, 3));
    }
}
