package jzoffer.n01;

/**
 * Created by Zhangkefei on 2016/4/23.
 */
public class Solution {
    public boolean Find(int [][] array,int target) {
        int r, c;
        if (array == null || (r=array.length) == 0 || array[0] == null || (c=array[0].length) == 0)
            return false;

        int left = 0, right = r-1;
        // 找到首个第0位大于target的行
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (array[mid][0] <= target)
                left = mid+1;
            else
                right = mid-1;
        }
        int endRow = left;

        left = 0;
        right = r-1;
        // 找到首个末位大于等于target的行
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (array[mid][c-1] < target)
                left = mid+1;
            else
                right = mid-1;
        }
        int startRow = left;

        System.out.println(startRow + ", " + endRow);
        for (int i = startRow; i < endRow; i++) {
            if (binSearch(array[i], target))
                return true;
        }

        return false;
    }

    private boolean binSearch(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < target)
                left = mid+1;
            else if (nums[mid] > target)
                right = mid-1;
            else
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] arr = new int[][]{
                new int[]{1,2,8,9},
                new int[]{2,4,9,12},
                new int[]{4,7,10,13},
                new int[]{6,8,11,15}
        };

        System.out.println(sol.Find(arr, 7));
        System.out.println(sol.Find(arr, 6));
        System.out.println(sol.Find(arr, 9));
        System.out.println(sol.Find(arr, 11));
        System.out.println(sol.Find(arr, 12));
        System.out.println(sol.Find(arr, 15));
        System.out.println(sol.Find(arr, 18));
    }
}
