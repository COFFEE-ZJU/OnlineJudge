package leetcode._2ndtime.no321;

import java.util.Arrays;

/**
 * Whiteboard coding!
 */
public class Solution {
    private int l1, l2;
    private int[] ns1, ns2;
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        ns1 = nums1;
        ns2 = nums2;
        l1 = nums1 == null ? 0 : nums1.length;
        l2 = nums2 == null ? 0 : nums2.length;

        int min1 = Math.max(0, k-l2), max1 = Math.min(l1, k);
        int[] res = new int[k];
        for (int i = min1; i <= max1; i++) {
            int[] cand = merge(getMaxArray(ns1, i), getMaxArray(ns2, k-i));
            if (greater(cand, 0, res, 0)) res = cand;
        }
        return res;
    }

    private int[] merge(int[] ns1, int[] ns2) {
        int l1 = ns1.length, l2 = ns2.length;
        int[] res = new int[l1+l2];
        for (int ri = 0, i1 = 0, i2 = 0; ri < l1+l2; ri++) {
            res[ri] = greater(ns1, i1, ns2, i2) ? ns1[i1++] : ns2[i2++];
        }
        return res;
    }

    private boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }

    private int[] getMaxArray(int[] nums, int len) {
        int [] res = new int[len];
        for (int i = 0, ri = 0; i < nums.length; i++) {
            if (ri >= len) return res;
            if (nums.length - i == len - ri) {
                System.arraycopy(nums, i, res, ri, len-ri);
                return res;
            }
            int maxIdx = i;
            for (int j = i+1; j <= nums.length - len + ri; j++) {
                if (nums[j] > nums[maxIdx]) maxIdx = j;
            }
            res[ri++] = nums[maxIdx++];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().maxNumber(new int[]{3,4,6,5}, new int[]{9,1,2,5,8,3}, 5)));
    }
}