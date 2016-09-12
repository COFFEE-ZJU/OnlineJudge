package netease.n2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Zhangkefei on 2016/9/11.
 */
public class Main {
    private static class IntArr {
        final int[] arr;

        private IntArr(int[] arr) {
            this.arr = arr;
        }

        @Override
        public boolean equals(Object o) {
            IntArr intArr = (IntArr) o;

            return Arrays.equals(arr, intArr.arr);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(arr);
        }
    }

    private static Map<IntArr, Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            cache.clear();

            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }

            System.out.println(getCount(new IntArr(nums)));
        }
    }

    private static int getCount(IntArr arr) {
        Integer res = cache.get(arr);
        if (res != null) return res;

        if (isRev(arr)) {
            cache.put(arr, 0);
            return 0;
        }

        int[] nums = arr.arr;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length-1; i++) {
            int[] nn = new int[nums.length-1];
            for (int j = 0, jj = 0; j < nums.length; ) {
                if (j == i+1)
                    nn[jj-1] += nums[j++];
                else
                    nn[jj++] = nums[j++];
            }

            min = Math.min(min, 1 + getCount(new IntArr(nn)));
        }
        cache.put(arr, min);
        return min;
    }

    private static boolean isRev(IntArr arr) {
        int[] nums = arr.arr;
        for (int i = 0; i < nums.length / 2; i++) {
            if (nums[i] != nums[nums.length-1-i]) return false;
        }
        return true;
    }
}
