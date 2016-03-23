package leetcode.no227;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    private Deque<Integer> list = new LinkedList<>();

    public int calculate(String s) {
        if (s == null || s.length() == 0)
            return 0;

        char[] cs = s.toCharArray();

        list.clear();
        int cur = 0, sign = 1;
        list.addLast(sign);
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            if (c == ' ') continue;

            if (c >= '0' && c <= '9') {
                int num = c - '0';
                while (i+1 < cs.length && cs[i+1] >= '0' && cs[i+1] <= '9')
                    num = num * 10 + (cs[++i] - '0');

                int ss = list.peekLast();
                if (ss == -2){
                    list.pollLast();
                    list.addLast(list.pollLast() / num);
                }
                else if (ss == 2){
                    list.pollLast();
                    list.addLast(list.pollLast() * num);
                }
                else
                    list.addLast(num);
            }
            else if (c == '+')
                list.addLast(1);
            else if (c == '-')
                list.addLast(-1);
            else if (c == '*')
                list.addLast(2);
            else if (c == '/')
                list.addLast(-2);
        }

        while (!list.isEmpty()){
            int ss = list.pollFirst();
            int cc = list.pollFirst();
            cur += ss * cc;
        }

        return cur;
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
        System.out.println(sol.calculate("1 + 1"));
        System.out.println(sol.calculate(" 3+5 / 2 "));
    }
}
