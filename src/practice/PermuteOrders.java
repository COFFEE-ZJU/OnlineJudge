package practice;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 给一个数n ,考虑这样2n个数 1 1 2 2 ……n n
 * 打印所有它的序列，使得该序列先非递减，后非递增
 * 例如：n=2
 * 2211 1221 1122
 *
 * Created by zkf on 4/26/16.
 */
public class PermuteOrders {
    private List<List<Integer>> solve (int st, int n) {
        if (st == n) {
            List<Integer> list = new LinkedList<>();
            list.add(n);
            list.add(n);
            return Collections.singletonList(list);
        }

        List<List<Integer>> res = new LinkedList<>(),
                prev = solve (st+1, n);
        for (List<Integer> nums : prev) {
            List<Integer> nn = new LinkedList<>(nums);
            nn.add(0, st);
            nn.add(0, st);
            res.add(nn);

            nn = new LinkedList<>(nums);
            nn.add(0, st);
            nn.add(st);
            res.add(nn);

            nums.add(st);
            nums.add(st);
            res.add(nums);
        }

        return res;
    }
    public List<List<Integer>> solve (int n) {
        return solve(1, n);
    }

    public static void main(String[] args) {
        System.out.println(new PermuteOrders().solve(1));
        System.out.println(new PermuteOrders().solve(2));
        System.out.println(new PermuteOrders().solve(3));
        System.out.println(new PermuteOrders().solve(5));
    }
}
