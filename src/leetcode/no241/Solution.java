package leetcode.no241;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        int len;
        if (input == null || (len=input.length()) == 0)
            return Collections.emptyList();

        char[] cs = input.toCharArray();
        List<Integer> ops = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            char c = cs[i];
            if (c == ' ') continue;
            if (c >= '0' && c <= '9') {
                int num = c - '0';
                while (i+1 < cs.length && cs[i+1] >= '0' && cs[i+1] <= '9')
                    num = num * 10 + (cs[++i] - '0');

                ops.add(num);
            }
            else if (c == '+')
                ops.add(1);
            else if (c == '-')
                ops.add(-1);
            else if (c == '*')
                ops.add(2);
        }


        List<Integer> list = diffWaysToCompute(ops, 0, ops.size());
        Collections.sort(list);
        return list;
    }

    private List<Integer> diffWaysToCompute(List<Integer> input, int st, int end) {
        List<Integer> list = new LinkedList<>();
        if (st+1 == end){
            list.add(input.get(st));
            return list;
        }
        for (int pos = st+1; pos < end; pos+=2){
            List<Integer> left = diffWaysToCompute(input, st, pos);
            List<Integer> right = diffWaysToCompute(input, pos+1, end);
            int op = input.get(pos);
            for (int l : left){
                for (int r : right){
                    switch (op) {
                        case 1:
                            list.add(l+r);
                            break;
                        case -1:
                            list.add(l-r);
                            break;
                        case 2:
                            list.add(l*r);
                            break;
                    }
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
        System.out.println(sol.diffWaysToCompute("2-1-1"));
        System.out.println(sol.diffWaysToCompute("2*3-4*5"));
    }
}
