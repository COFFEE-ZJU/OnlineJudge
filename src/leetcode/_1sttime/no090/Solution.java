package leetcode._1sttime.no090;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>(), tmp = new ArrayList<>();
        ret.add(new LinkedList<>());

        if (nums == null || nums.length == 0)
            return ret;
        Arrays.sort(nums);
        List<Num> numList = new ArrayList<>(nums.length);
        int prev = nums[0];
        numList.add(new Num(prev));
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prev)
                numList.get(numList.size() - 1).cnt++;
            else
                numList.add(new Num(nums[i]));

            prev = nums[i];
        }

        for (Num n : numList){
            tmp.clear();
            tmp.addAll(ret);
            for (int i = 1; i <= n.cnt; i++) {
                for (List<Integer> l : ret){
                    List<Integer> tl = new LinkedList<>(l);
                    for (int j = 0; j < i; j++)
                        tl.add(n.num);
                    tmp.add(tl);
                }
            }

            List<List<Integer>> tt = tmp;
            tmp = ret;
            ret = tt;
        }

        return ret;
    }

    private static class Num {
        final int num;
        int cnt;

        Num(int n){
            num = n;
            cnt = 1;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.subsetsWithDup(new int[]{1,2,2}));
        System.out.println(sol.subsetsWithDup(new int[]{1,2,3}));
    }
}