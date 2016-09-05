package leetcode._1sttime.no321;

import java.util.Arrays;

public class Solution {
    private int l1,l2,k;
    private int[] nums1, nums2;
    private int[] cand1, cand2;
    private int[] cand, res;
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        if (nums1 == null || nums2 == null || k <= 0)
            return null;

        l1=nums1.length;
        l2=nums2.length;
        if (k > (l1+l2))
            return null;

        this.k = k;
        this.nums1 = nums1;
        this.nums2 = nums2;
        res = new int[k];
        cand = new int[k];

        int ns1 = Math.max(0, k-l2), ne1 = Math.min(l1, k);
        int ns2 = Math.max(0, k-l1), ne2 = Math.min(l2, k);
        cand1 = new int[ne1];
        cand2 = new int[ne2];
        for (int i = ns1; i <= ne1; i++) {
            int j = k - i;
            genCand(cand1, nums1, l1, i);
            genCand(cand2, nums2, l2, j);
            mergeAndSet(i, j);
        }

        return res;
    }

    private void mergeAndSet(int i, int j) {
        int ii = 0, jj = 0;
        int idx = 0;
        for (; ii < i && jj < j; idx++) {
            if (cand1[ii] > cand2[jj])
                cand[idx] = cand1[ii++];
            else if (cand1[ii] < cand2[jj])
                cand[idx] = cand2[jj++];
            else if (useFirst(ii, i, jj, j))
                cand[idx] = cand1[ii++];
            else
                cand[idx] = cand2[jj++];
        }
        if (ii == i)
            System.arraycopy(cand2, jj, cand, idx, k-idx);
        else
            System.arraycopy(cand1, ii, cand, idx, k-idx);

        for (int l = 0; l < k; l++) {
            if (res[l] < cand[l]) {
                System.arraycopy(cand, l, res, l, k - l);
                break;
            }
            if (res[l] > cand[l])
                break;
        }

    }

    private boolean useFirst(int ii, int i, int jj, int j) {
        for (int l = 0; l < (i-ii + j-jj); l++) {
            int n1 = (ii+l) < i ? cand1[ii+l] : cand2[jj+ii+l-i];
            int n2 = (jj+l) < j ? cand2[jj+l] : cand1[ii+jj+l-j];
            if (n1 > n2) return true;
            else if (n1 < n2) return false;
        }

        return true;
    }


    private void genCand(int[] cand, int[] nums, int nlen, int len) {
        int idx = 0;
        for (int i = 0; i < len; i++) {
            int max = -1, pos = -1;
            int rst = len - i;
            for (int j = idx; j <= nlen-rst; j++) {
                if (nums[j] > max) {
                    max = nums[j];
                    pos = j;
                }
            }

            if (pos == nlen-rst) {
                System.arraycopy(nums, pos, cand, i, rst);
                return;
            }

            idx = pos+1;
            cand[i] = nums[pos];
        }
    }


    public static void main(String[] args) {
		Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.maxNumber(new int[]{2,5,6,4,4,0},
        new int[]{7,3,8,0,6,5,7,6,2},
        15)));
        System.out.println(Arrays.toString(sol.maxNumber(new int[]{1,2,6,6}, new int[]{1,9,2,4}, 4)));
        System.out.println(Arrays.toString(sol.maxNumber(new int[]{3, 4, 6, 5}, new int[]{9, 1, 2, 5, 8, 3}, 5)));
        System.out.println(Arrays.toString(sol.maxNumber(new int[]{3, 9}, new int[]{8, 9}, 3)));
    }
}
