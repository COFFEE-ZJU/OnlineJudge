package cn.edu.zju.coffee.leetcode.no040;

import java.util.*;

/**
 * Created by Zhangkefei on 2016/1/3.
 */
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> retList = new HashSet<>();
        if (candidates == null || candidates.length == 0)
            return new LinkedList<>(retList);
        Arrays.sort(candidates);
        List<Prefix> q1 = new LinkedList<>(), q2 = new LinkedList<>(), tmp;
        for (int num : candidates){
            q2.clear();
            if (num <= target) {
                Prefix p = new Prefix(num, target);
                if (p.remainder == 0)
                    retList.add(p.prefix);
                else
                    q2.add(p);
            }

            for (Prefix p : q1){
                if (p.remainder == 0)
                    retList.add(p.prefix);
                if (p.remainder > num)
                    q2.add(p);
                if (p.remainder >= num){
                    Prefix np = p.add(num);
                    if (np.remainder == 0)
                        retList.add(np.prefix);
                    if (np.remainder >= num)
                        q2.add(np);
                }
            }

            tmp = q1;
            q1 = q2;
            q2 = tmp;
        }

        return new LinkedList<>(retList);
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Prefix prefix1 = (Prefix) o;

            return prefix != null ? prefix.equals(prefix1.prefix) : prefix1.prefix == null;

        }

        @Override
        public int hashCode() {
            return prefix != null ? prefix.hashCode() : 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum2(new int[]{2,5,2,1,2}, 5));
    }
}
