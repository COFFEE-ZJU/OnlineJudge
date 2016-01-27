package cn.edu.zju.coffee.leetcode.no120;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0)
            return 0;

        int len = triangle.size();
        int[] dpPrev = new int[len];
        int[] dp = new int[len];
        for (List<Integer> list : triangle){
            int i = 0;
            len = list.size();
            for (int n : list){
                int min;
                if (i == 0)
                    min = dpPrev[i];
                else if (i == len-1)
                    min = dpPrev[i-1];
                else
                    min = Math.min(dpPrev[i], dpPrev[i-1]);
                dp[i++] = min + n;
            }
            int[] tmp = dp;
            dp = dpPrev;
            dpPrev = tmp;
        }
        int min = dpPrev[0];
        for (int n : dpPrev)
            if (n < min) min = n;

        return min;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<List<Integer>> l = new LinkedList<>();
        l.add(Arrays.asList(-1));
        l.add(Arrays.asList(2, 3));
        l.add(Arrays.asList(1, -1, -3));
        System.out.println(sol.minimumTotal(l));
    }
}