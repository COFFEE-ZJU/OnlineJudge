package leetcode._1sttime.no118and119;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<>();
        if (numRows <= 0) return res;
        List<Integer> prev = Collections.singletonList(1);
        res.add(prev);
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<>(i+1);
            list.add(1);
            for (int j = 1; j < i; j++) {
                list.add(prev.get(j-1) + prev.get(j));
            }
            list.add(1);
            res.add(list);
            prev = list;
        }

        return res;
    }

    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0) return Collections.EMPTY_LIST;
        List<Integer> res = new ArrayList<>(rowIndex+1);
        res.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            res.add(1);
            for (int j = i-1; j > 0 ; j--) {
                res.set(j, res.get(j-1) + res.get(j));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.getRow(0));
        System.out.println(sol.getRow(1));
        System.out.println(sol.getRow(3));
    }
}