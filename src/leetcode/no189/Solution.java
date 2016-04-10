package leetcode.no189;

import java.util.Arrays;

public class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        k = nums.length - k;
        int cnt, a, b;
        cnt = a = 0;
        b = k % nums.length;
        while (cnt < nums.length) {
            a = (a+1) % nums.length;
            b = (b+1) % nums.length;
            int st = a;
            int tmp = nums[st];
            while (b != st) {
                nums[a] = nums[b];
                a += k; b+= k;
                a %= nums.length; b %= nums.length;
                cnt++;
            }
            nums[a] = tmp;
            cnt++;
        }
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
        int[] a = new int[]{1,2,3};
        sol.rotate(a, 1);
        System.out.println(Arrays.toString(a));
    }
}
