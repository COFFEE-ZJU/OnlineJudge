package practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Google 实习生电面二面真题, Online doc coding.
 * Using Binary Indexed Tree.
 *
 * Created by zkf on 4/19/16.
 */
public class FindPermutationOrder {
    private void update(int[] bit, int idx, int diff) {
        int max = bit.length;
        while (idx < max) {
            bit[idx] += diff;
            idx += (idx & -idx);
        }
    }

    private int read(int[] bit, int idx) {
        int max = bit.length;
        int sum = 0;
        while (idx > 0) {
            sum += bit[idx];
            idx -= (idx & -idx);
        }
        return sum;
    }

    public int getOrder(char[] cs, String perm) {
        int len = cs.length;
        Arrays.sort(cs);
        Map<Character, Integer> posMap = new HashMap<>();
        int[] bit = new int[len+1];
        for (int i = 0; i < len; i++) {
            posMap.put(cs[i], i+1);
            update(bit, i+1, 1);
        }

        int order = 1;
        int fact = 1;
        for (int i = 1; i <= len; i++)
            fact *= i;
        int rem = len;
        for (char c : perm.toCharArray()) {
            int pos = posMap.get(c);
            update(bit, pos, -1);
            int prevCnt = read(bit, pos);

            fact /= rem;
            rem--;
            order += prevCnt * fact;
        }
        return order;
    }

    public static void main(String[] args) {
        FindPermutationOrder pfo = new FindPermutationOrder();
        System.out.println(pfo.getOrder("dcba".toCharArray(), "dcba"));
        System.out.println(pfo.getOrder("dcba".toCharArray(), "abcd"));
        System.out.println(pfo.getOrder("dcba".toCharArray(), "bacd"));
    }
}
