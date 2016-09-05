package leetcode._1sttime.no330;

public class Solution {
    public int minPatches(int[] nums, int n) {
        if (n <= 0) return 0;
        if (nums == null) nums = new int[0];
        long rh = 0;
        int patch = 0;
        for (int nn : nums) {
            while (rh + 1 < nn && rh < n) {
                rh = rh * 2 + 1;
                patch++;
            }
            rh += nn;
            if (rh >= n) break;
        }
        while (rh < n) {
            rh = rh * 2 + 1;
            patch++;
        }

        return patch;
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
        System.out.println(sol.minPatches(new int[]{1,2,2,6,34,38,41,44,47,47,56,59,62,73,77,83,87,89,94}, 20));
        System.out.println(sol.minPatches(new int[]{1,3}, 6));
        System.out.println(sol.minPatches(new int[]{}, 7));
        System.out.println(sol.minPatches(new int[]{1,2,31,33}, 2147483647));
        System.out.println(sol.minPatches(new int[]{1,7,21,31,34,37,40,43,49,87,90,92,93,98,99}, 12));
    }
}
