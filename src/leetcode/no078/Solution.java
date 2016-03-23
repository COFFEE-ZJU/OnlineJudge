package leetcode.no078;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new LinkedList<>(), tmp = new LinkedList<>(), tt;
        ret.add(new LinkedList<>());
        if (nums == null || nums.length == 0)
            return ret;

        Arrays.sort(nums);
        for (int n : nums){
            tmp.clear();
            for (List<Integer> list : ret){
                List<Integer> tl = new LinkedList<>(list);
                tl.add(n);
                tmp.add(tl);
                tmp.add(list);
            }
            tt = tmp;
            tmp = ret;
            ret = tt;
        }

        return ret;
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
        System.out.println(sol.subsets(new int[]{1,2,3}));
    }
}