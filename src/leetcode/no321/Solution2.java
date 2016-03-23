package leetcode.no321;

import java.util.Arrays;

public class Solution2 {
    private int l1,l2,k;
    private int[] nums1, nums2;
    private int[] res;
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        if (nums1 == null || nums2 == null || k <= 0 ||
                (l1=nums1.length) == 0 || (l2=nums2.length) == 0 || k > (l1+l2))
            return null;

        this.k = k;
        this.nums1 = nums1;
        this.nums2 = nums2;
        res = null;
        tryOut(0, 0, 0, new int[k]);

        return res;
    }

    private void compareAndSet(int[] cand) {
        if (res == null) {
            res = Arrays.copyOf(cand, k);
            return;
        }
        for (int i = 0; i < res.length; i++) {
            if (res[i] > cand[i]) return;
            if (res[i] < cand[i]) {
                System.arraycopy(cand, 0, res, 0, k);
                return;
            }
        }
    }

    private void tryOut(int ki, int i1, int i2, int[] cand) {
        if (ki >= k) {
            compareAndSet(cand);
            return;
        }
        if (i1 == l1 && l2-i2 == k-ki) {
            System.arraycopy(nums2, i2, cand, ki, k-ki);
            compareAndSet(cand);
            return;
        }
        if (i2 == l2 && l1-i1 == k-ki) {
            System.arraycopy(nums1, i1, cand, ki, k-ki);
            compareAndSet(cand);
            return;
        }

        int idx1 = 0, idx2 = 0, max1 = -1, max2 = -1;
        for (int i = i1;i < l1; i++) {
            if (l1-i + l2-i2 < k-ki || max1 == 9)
                break;
            if (nums1[i] > max1) {
                max1 = nums1[i];
                idx1 = i;
            }
        }
        for (int i = i2;i < l2; i++) {
            if (l1-i1 + l2-i < k-ki || max2 == 9)
                break;
            if (nums2[i] > max2) {
                max2 = nums2[i];
                idx2 = i;
            }
        }

        if (res != null && max1 < res[ki] && max2 < res[ki])
            return;

        if (max1 >= max2) {
            cand[ki] = max1;
            tryOut(ki+1, idx1+1, i2, cand);
        }
        if (max2 >= max1) {
            cand[ki] = max2;
            tryOut(ki+1, i1, idx2+1, cand);
        }
    }

    public static void main(String[] args) {
		Solution2 sol = new Solution2();
        System.out.println(Arrays.toString(sol.maxNumber(new int[]{3, 4, 6, 5}, new int[]{9, 1, 2, 5, 8, 3}, 5)));
        System.out.println(Arrays.toString(sol.maxNumber(new int[]{3, 9}, new int[]{8, 9}, 3)));
        System.out.println(Arrays.toString(sol.maxNumber(new int[] {8,9,7,3,5,9,1,0,8,5,3,0,9,2,7,4,8,9,8,1,0,2,0,2,7,2,3,5,4,7,4,1,4,0,1,4,2,1,3,1,5,3,9,3,9,0,1,7,0,6,1,8,5,6,6,5,0,4,7,2,9,2,2,7,6,2,9,2,3,5,7,4,7,0,1,8,3,6,6,3,0,8,5,3,0,3,7,3,0,9,8,5,1,9,5,0,7,9,6,8,5,1,9,6,5,8,2,3,7,1,0,1,4,3,4,4,2,4,0,8,4,6,5,5,7,6,9,0,8,4,6,1,6,7,2,0,1,1,8,2,6,4,0,5,5,2,6,1,6,4,7,1,7,2,2,9,8,9,1,0,5,5,9,7,7,8,8,3,3,8,9,3,7,5,3,6,1,0,1,0,9,3,7,8,4,0,3,5,8,1,0,5,7,2,8,4,9,5,6,8,1,1,8,7,3,2,3,4,8,7,9,9,7,8,5,2,2,7,1,9,1,5,5,1,3,5,9,0,5,2,9,4,2,8,7,3,9,4,7,4,8,7,5,0,9,9,7,9,3,8,0,9,5,3,0,0,3,0,4,9,0,9,1,6,0,2,0,5,2,2,6,0,0,9,6,3,4,1,2,0,8,3,6,6,9,0,2,1,6,9,2,4,9,0,8,3,9,0,5,4,5,4,6,1,2,5,2,2,1,7,3,8,1,1,6,8,8,1,8,5,6,1,3,0,1,3,5,6,5,0,6,4,2,8,6,0,3,7,9,5,5,9,8,0,4,8,6,0,8,6,6,1,6,2,7,1,0,2,2,4,0,0,0,4,6,5,5,4,0,1,5,8,3,2,0,9,7,6,2,6,9,9,9,7,1,4,6,2,8,2,5,3,4,5,2,4,4,4,7,2,2,5,3,2,8,2,2,4,9,8,0,9,8,7,6,2,6,7,5,4,7,5,1,0,5,7,8,7,7,8,9,7,0,3,7,7,4,7,2,0,4,1,1,9,1,7,5,0,5,6,6,1,0,6,9,4,2,8,0,5,1,9,8,4,0,3,1,2,4,2,1,8,9,5,9,6,5,3,1,8,9,0,9,8,3,0,9,4,1,1,6,0,5,9,0,8,3,7,8,5},
                new int[] {7,8,4,1,9,4,2,6,5,2},
                250)));
    }
}
