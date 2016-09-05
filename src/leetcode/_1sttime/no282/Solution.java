package leetcode._1sttime.no282;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    private List<String> res;
    private String num;
    private int target;

    public List<String> addOperators(String num, int target) {
        if (num == null || num.length() == 0) return Collections.emptyList();

        this.num = num;
        this.target = target;
        res = new LinkedList<>();
        start();

        return res;
    }

    private void start() {
        long curNum = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            curNum = curNum * 10 + num.charAt(i) - '0';
            sb.setLength(0);
            sb.append(curNum);
            rec(i+1, curNum, 0, sb);
            if (curNum == 0) break;
        }
    }

    private void rec(int i, long prevNum, long prevSum, StringBuilder prevSb) {
        if (i == num.length()) {
            if (prevSum + prevNum == target) res.add(prevSb.toString());
            return;
        }
        int prevLen = prevSb.length();
        int ii = i;
        long curNum = 0;
        for (i = ii; i < num.length(); i++) {
            curNum = curNum * 10 + num.charAt(i) - '0';
            prevSb.setLength(prevLen);
            prevSb.append('*').append(curNum);
            rec(i+1, prevNum * curNum, prevSum, prevSb);
            if (curNum == 0) break;
        }

        curNum = 0;
        for (i = ii; i < num.length(); i++) {
            curNum = curNum * 10 + num.charAt(i) - '0';
            prevSb.setLength(prevLen);
            prevSb.append('+').append(curNum);
            rec(i+1, curNum, prevSum + prevNum, prevSb);
            if (curNum == 0) break;
        }

        curNum = 0;
        for (i = ii; i < num.length(); i++) {
            curNum = curNum * 10 + num.charAt(i) - '0';
            prevSb.setLength(prevLen);
            prevSb.append('-').append(curNum);
            rec(i+1, -curNum, prevSum + prevNum, prevSb);
            if (curNum == 0) break;
        }
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
        System.out.println(sol.addOperators("11", 2));
        System.out.println(sol.addOperators("11", 1));
        System.out.println(sol.addOperators("11", 11));
        System.out.println(sol.addOperators("11", 0));
        System.out.println(sol.addOperators("123", 6));
        System.out.println(sol.addOperators("232", 8));
        System.out.println(sol.addOperators("105", 5));
        System.out.println(sol.addOperators("00", 0));
        System.out.println(sol.addOperators("3456237490", 9191));
    }
}
