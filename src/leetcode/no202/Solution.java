package leetcode.no202;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    private Set<Integer> cache = new HashSet<>();
    public boolean isHappy(int n) {
        cache.clear();
        return happyRec(n);
    }

    private boolean happyRec(int n) {
        if (n == 1) return true;
        if (cache.contains(n)) return false;
        cache.add(n);
        int nxt = 0;
        while (n != 0) {
            int nn = n % 10;
            nxt += nn * nn;
            n /= 10;
        }

        return happyRec(nxt);
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
        System.out.println(sol.isHappy(19));
        System.out.println(sol.isHappy(1));
        System.out.println(sol.isHappy(2));
    }
}
