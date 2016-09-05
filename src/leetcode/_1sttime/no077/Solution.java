package leetcode._1sttime.no077;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    private List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        res = new LinkedList<>();
        if (n < 0 || k < 0 || n < k)
            return res;
        if (k == 0){
            res.add(new ArrayList<>());
            return res;
        }

        combine(new LinkedList<Integer>(), 0, n, k);
        return res;
    }

    private void combine(List<Integer> prefix, int st, int n, int k){
        List<Integer> l = new LinkedList<>(prefix);
        if (k == 0){
            res.add(new LinkedList<>(l));
            return;
        }

        if (n - st == k){
            for (int i = st; i < n; i++)
                l.add(i+1);
            res.add(l);
            return;
        }

        for (int i = st; i <= n-k; i++) {
            l.add(i+1);
            combine(l, i+1, n, k-1);
            l.remove(l.size()-1);
        }
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
        System.out.println(sol.combine(3,2));
    }
}