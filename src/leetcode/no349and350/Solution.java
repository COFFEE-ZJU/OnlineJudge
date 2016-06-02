package leetcode.no349and350;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Whiteboard coding!
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int len1, len2;
        if (nums1 == null || nums2 == null || (len1=nums1.length) == 0 || (len2=nums2.length) == 0)
            return new int[0];
        List<Integer> res = new ArrayList<>(Math.min(len1, len2));
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i1 = 0, i2 = 0;
        while (i1 < len1 && i2 < len2) {
            if (nums1[i1] < nums2[i2])
                i1++;
            else if (nums1[i1] > nums2[i2])
                i2++;
            else {
                if (res.size() == 0 || res.get(res.size()-1) != nums1[i1])
                    res.add(nums1[i1]);
                i1++;i2++;
            }
        }
        int[] inter = new int[res.size()];
        for (int i = 0; i < inter.length; i++)
            inter[i] = res.get(i);
        return inter;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        int len1, len2;
        if (nums1 == null || nums2 == null || (len1=nums1.length) == 0 || (len2=nums2.length) == 0)
            return new int[0];
        List<Integer> res = new ArrayList<>(Math.min(len1, len2));
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i1 = 0, i2 = 0;
        while (i1 < len1 && i2 < len2) {
            if (nums1[i1] < nums2[i2])
                i1++;
            else if (nums1[i1] > nums2[i2])
                i2++;
            else {
                res.add(nums1[i1]);
                i1++;i2++;
            }
        }
        int[] inter = new int[res.size()];
        for (int i = 0; i < inter.length; i++)
            inter[i] = res.get(i);
        return inter;
    }
}