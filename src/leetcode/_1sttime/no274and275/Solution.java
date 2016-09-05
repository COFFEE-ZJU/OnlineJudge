package leetcode._1sttime.no274and275;

import java.util.Arrays;

public class Solution {
    public int hIndex(int[] citations) {
        int len;
        if (citations == null || (len=citations.length) == 0) return 0;

        // delete this in no275, already sorted.
        Arrays.sort(citations);

        int st = 0, end = len, h = 0;
        while (st < end){
            int mid = (st + end) / 2;
            int ph = len - mid;
            if (citations[mid] >= ph) {
                h = Math.max(ph, h);
                end = mid;
            }
            else
                st = mid + 1;
        }

        return h;
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
        System.out.println(sol.hIndex(new int[]{3, 0, 6, 1, 5}));
        System.out.println(sol.hIndex(new int[]{0,0,0}));
        System.out.println(sol.hIndex(new int[]{100}));
        System.out.println(sol.hIndex(new int[]{100,100,100}));
    }
}
