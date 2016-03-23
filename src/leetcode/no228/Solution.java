package leetcode.no228;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0)
            return Collections.emptyList();

        int st, prev;
        st = prev = nums[0];
        List<String> list = new LinkedList<>();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prev + 1)
                prev++;
            else {
                if (st == prev)
                    list.add(""+st);
                else
                    list.add(st+"->"+prev);
                st = prev = nums[i];
            }
        }
        if (st == prev)
            list.add(""+st);
        else
            list.add(st+"->"+prev);

        return list;
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
        System.out.println(sol.summaryRanges(new int[]{0,1,2,4,5,7}));
    }
}
