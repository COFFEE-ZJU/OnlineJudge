package leetcode.no216;

import java.util.*;

public class Solution {
    private static Map<Integer, List<List<Integer>>[]> map;
    static {
        map = new HashMap<>();
        for (int i = 0; i < 1 << 9; i++) {
            List<Integer> list = new LinkedList<>();
            int sum = 0;
            for (int j = 0; j < 9; j++) {
                if ((i & (1 << j)) != 0) {
                    list.add(j + 1);
                    sum += j+1;
                }
            }
            List<List<Integer>>[] val = map.get(sum);
            if (val == null) {
                val = new List[10];
                map.put(sum, val);
            }
            int len = list.size();
            if (val[len] == null)
                val[len] = new LinkedList<>();
            val[len].add(list);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k < 0 || k > 9) return null;
        List<List<Integer>>[] val = map.get(n);
        if (val == null)
            return null;

        return val[k] == null ? Collections.emptyList() : val[k];
    }
	
	public static void main(String[] args) {
		Solution sol = new Solution();
        System.out.println(sol.combinationSum3(3,7));
        System.out.println(sol.combinationSum3(0,0));
        System.out.println(sol.combinationSum3(1,1));
        System.out.println(sol.combinationSum3(3,9));
    }
}
