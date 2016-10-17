package toutiao.screen.n4;

/**
 * 两有序数组求第kth个元素
 */
public class Solution {
    public int findKth(int[] ns1, int[] ns2, int k) {
        int len1 = ns1 == null ? 0 : ns1.length;
        int len2 = ns2 == null ? 0 : ns2.length;
        if (len1 + len2 < k || k <= 0) return -1;
        k--;
        int st1 = 0, st2 = 0;
        while (st1 < len1 && st2 < len2 && k != 0) {
            int mid = k / 2;
            int i1 = Math.min(len1-1, st1 + mid);
            int i2 = Math.min(len2-1, st2 + mid);
            int n1 = ns1[i1], n2 = ns2[i2];
            if (n1 <= n2) {
                k -= (i1 + 1 - st1);
                st1 = i1+1;
            } else {
                k -= (i2 + 1 - st2);
                st2 = i2+1;
            }
        }
        if (st1 == len1) return ns2[st2 + k];
        if (st2 == len2) return ns1[st1 + k];

        return Math.min(ns1[st1], ns2[st2]);
    }

}