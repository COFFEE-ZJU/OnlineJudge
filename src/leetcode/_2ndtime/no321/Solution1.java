package leetcode._2ndtime.no321;

import java.util.Arrays;

/**
 * Whiteboard coding!
 */
public class Solution1 {
    private int l1, l2;
    private int[] ns1, ns2;
    private int[] res;
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        ns1 = nums1;
        ns2 = nums2;
        l1 = nums1 == null ? 0 : nums1.length;
        l2 = nums2 == null ? 0 : nums2.length;
        res = new int[k];
        maxNum(0, 0, k, 0);
        return res;
    }

    private void maxNum(int i1, int i2, int k, int ri) {
        if (k == 0) return;

        int max1 = Integer.MIN_VALUE, maxIdx1 = -1;
        int bound1 = Math.min(l1, l1+l2-i2-k+1);
        for (int i = i1; i < bound1; i++) {
            if (ns1[i] > max1) {
                max1 = ns1[i];
                maxIdx1 = i;
            }
        }

        int max2 = Integer.MIN_VALUE, maxIdx2 = -1;
        int bound2 = Math.min(l2, l2+l1-i1-k+1);
        for (int i = i2; i < bound2; i++) {
            if (ns2[i] > max2) {
                max2 = ns2[i];
                maxIdx2 = i;
            }
        }

        if (max1 > max2) {
            res[ri++] = max1;
            i1 = maxIdx1+1;
            maxNum(i1, i2, k-1, ri);
        } else if (max1 < max2) {
            res[ri++] = max2;
            i2 = maxIdx2+1;
            maxNum(i1, i2, k-1, ri);
        } else {
            res[ri++] = max2;
            maxNum(maxIdx1+1, i2, k-1, ri);
            int[] res2 = Arrays.copyOf(res, res.length);
            maxNum(i1, maxIdx2+1, k-1, ri);
            setMaxRes(res2);
        }
    }

    private void setMaxRes(int[] res2) {
        for (int i = 0; i < res.length; i++) {
            if (res2[i] > res[i]) {
                res = res2;
                return;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution1().maxNumber(new int[]{0}, new int[]{0,6,5,7,6,2}, 7)));
    }
}