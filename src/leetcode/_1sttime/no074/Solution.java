package leetcode._1sttime.no074;

public class Solution {
    private int tg;
    private int[][] m;
    private int[] nums;

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0|| matrix[0].length == 0)
            return false;

        tg = target;
        m = matrix;
        return search2D(0, m.length);
    }

    private boolean search1D(int s, int e){
        if (s + 1 == e)
            return nums[s] == tg;

        int mid = (s+e) / 2;
        if (nums[mid] > tg)
            return search1D(s, mid);
        else
            return search1D(mid, e);
    }

    private boolean search2D(int s, int e){
        if (s + 1 == e){
            nums = m[s];
            return search1D(0, nums.length);
        }

        int mid = (s+e) / 2;
        if (m[mid][0] > tg)
            return search2D(s, mid);
        else
            return search2D(mid, e);

    }

    public static void main(String[] args) {
		Solution sol = new Solution();
        int[][] m = new int[][]{
                new int[]{1,3,5,7},
                new int[]{10,11,16,20},
                new int[]{23,30,34,50},
        };

        System.out.println(sol.searchMatrix(m, -1));
        System.out.println(sol.searchMatrix(m, 1));
        System.out.println(sol.searchMatrix(m, 5));
        System.out.println(sol.searchMatrix(m, 20));
        System.out.println(sol.searchMatrix(m, 50));
        System.out.println(sol.searchMatrix(m, 99));
        System.out.println(sol.searchMatrix(m, 24));
        System.out.println(sol.searchMatrix(m, 21));
    }
}