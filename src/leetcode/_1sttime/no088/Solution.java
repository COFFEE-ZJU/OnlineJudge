package leetcode._1sttime.no088;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null || n <= 0 || m < 0)
            return;
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }

        System.arraycopy(nums1, 0, nums1, n, m);
        int i = n, j = 0, cur = 0;
        for (; i < m+n && j < n; cur++) {
            if (nums1[i] <= nums2[j])
                nums1[cur] = nums1[i++];
            else
                nums1[cur] = nums2[j++];
        }
        if (i == m+n)
            System.arraycopy(nums2, j, nums1, cur, n - j);

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
	}
}