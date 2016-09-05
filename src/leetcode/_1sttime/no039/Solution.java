package leetcode._1sttime.no039;

import java.util.*;

/**
 * Created by Zhangkefei on 2016/1/3.
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> retList = new LinkedList<>();
        if (candidates == null || candidates.length == 0)
            return retList;
        Arrays.sort(candidates);
        List<Prefix> q1 = new LinkedList<>(), q2 = new LinkedList<>(), tmp;
        for (int num : candidates){
            q2.clear();
            if (num <= target)
                q1.add(new Prefix(num, target));

            for (Prefix p : q1){
                if (p.remainder == 0)
                    retList.add(p.prefix);
                if (p.remainder > num)
                    q2.add(p);
                for (Prefix np = p; np.remainder >= num;){
                    np = np.add(num);
                    if (np.remainder == 0)
                        retList.add(np.prefix);
                    if (np.remainder > num)
                        q2.add(np);
                }
            }

            tmp = q1;
            q1 = q2;
            q2 = tmp;
        }

        return retList;
    }

    private static class Prefix{
        private List<Integer> prefix;
        private int remainder;

        private Prefix(){}

        Prefix(int initNum, int target){
            prefix = new LinkedList<>();
            prefix.add(initNum);
            remainder = target - initNum;
        }

        private Prefix add(int newNum){
            Prefix np = new Prefix();
            np.prefix = new LinkedList<>(prefix);
            np.prefix.add(newNum);
            np.remainder = remainder - newNum;

            return np;
        }

        @Override
        public String toString() {
            return "Prefix{" +
                    "prefix=" + prefix +
                    ", remainder=" + remainder +
                    '}';
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum(new int[]{2,3,6,7}, 7));
    }
}
