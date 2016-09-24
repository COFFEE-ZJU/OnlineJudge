package leetcode._2ndtime.no004;

/**
 * Whiteboard coding!
 */
public class Solution {
    private int[] ns1, ns2;
    private int l1, l2;
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return 0;
        ns1 = nums1;
        ns2 = nums2;
        l1 = ns1.length;
        l2 = ns2.length;
        int l = l1 + l2;
        if (l % 2 == 0) return (0.0 + findKth(0, l1-1, 0, l2-1, l/2 - 1) + findKth(0, l1-1, 0, l2-1, l/2)) / 2;
        else return findKth(0, l1-1, 0, l2-1, l/2);
    }

    private int findKth(int st1, int end1, int st2, int end2, int k) {
        if (st1 > end1) return ns2[st2+k];
        else if (st2 > end2) return ns1[st1+k];

        int mid1 = (st1+end1) / 2;
        int mid2 = (st2+end2) / 2;
        int n1 = ns1[mid1], n2 = ns2[mid2];
        if (mid1 + mid2 - st1 - st2 + 1 <= k) {
            if (n1 < n2) return findKth(mid1+1, end1, st2, end2, k-mid1+st1-1);
            else return findKth(st1, end1, mid2+1, end2, k-mid2+st2-1);
        } else {
            if (n1 > n2) return findKth(st1, mid1-1, st2, end2, k);
            else return findKth(st1, end1, st2, mid2-1, k);
        }
    }
}