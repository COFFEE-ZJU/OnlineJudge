package cn.edu.zju.coffee.leetcode.no015;

import java.util.*;

/**
 * Created by zkf on 2015/12/18.
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<Triple> set = new HashSet<>();
        if(nums == null || nums.length < 3)
            return toList(set);

        List<Integer> numList = new ArrayList<>(nums.length);
        for(int n : nums)
            numList.add(n);

        Collections.sort(numList);
        for (int i = 1; i < numList.size() - 1; i++) {
            int dest = 0 - numList.get(i);
            int m = 0, n = numList.size() - 1;
            while(m < i && n > i){
                int sum = numList.get(m) + numList.get(n);
                if(sum == dest){
                    set.add(new Triple(numList.get(m), dest, numList.get(n)));
                    m ++;
                    n --;
                }
                else if (sum < dest)
                    m ++;
                else
                    n --;
            }
        }

        return toList(set);
    }

    private List<List<Integer>> toList(Set<Triple> set){
        List<List<Integer>> list = new LinkedList<>();
        for (Triple t : set)
            list.add(t.toList());

        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().threeSum(new int[]{7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6}));
    }

    static class Triple{
        final int a, b, c;
        public Triple(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        List<Integer> toList(){
            List<Integer> list = new ArrayList<>(3);
            list.add(a);
            list.add(b);
            list.add(c);

            return list;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Triple triple = (Triple) o;

            if (a != triple.a) return false;
            if (b != triple.b) return false;
            return c == triple.c;

        }

        @Override
        public int hashCode() {
            int result = a;
            result = 31 * result + b;
            result = 31 * result + c;
            return result;
        }
    }
}
