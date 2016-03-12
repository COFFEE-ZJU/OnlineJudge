package cn.edu.zju.coffee.leetcode.no004;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null) nums1 = new int[0];
        if (nums2 == null) nums2 = new int[0];
        int len1, len2;
        len1 = nums1.length;
        len2 = nums2.length;
        int total = len1 + len2;
        if (total == 0) return 0;

        if (total % 2 == 1) {
            return find(nums1, 0, len1, nums2, 0, len2, total / 2);
        }
        else {
            return ( find(nums1, 0, len1, nums2, 0, len2, total / 2 - 1) +
                    find(nums1, 0, len1, nums2, 0, len2, total / 2) ) / 2;
        }
    }

    private double find(int[] nums1, int st1, int len1,
                        int[] nums2, int st2, int len2, int k) {
        if (len1 == 0) return nums2[st2+k];
        if (len2 == 0) return nums1[st1+k];
        if (k == 0)
            return Math.min(nums1[st1], nums2[st2]);

        if (len1 < len2)
            return find(nums2, st2, len2, nums1, st1, len1, k);
        int p2 = Math.min(k / 2, len2 - 1), p1 = k - p2 - 1;
        int n1 = nums1[st1+p1], n2 = nums2[st2+p2];
        if (n1 == n2) return n1;
        if (n1 > n2)
            return find(nums1, st1, len1, nums2, st2+p2+1, len2-p2-1, k-p2-1);
        else
            return find(nums1, st1+p1+1, len1-p1-1, nums2, st2, len2, k-p1-1);
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
        System.out.println(sol.findMedianSortedArrays(new int[]{1}, new int[]{2,3,4}));
    }
}
