package practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zkf on 4/19/16.
 */
public class GoogleFunc {
    public int getF(int n) {
        if (n < 3) return n;
        if (n == 3) return 2;
        List<Integer> arr = new ArrayList<>();
        arr.add(0);
        arr.add(1);
        arr.add(3);
        int a = 2, ceil = arr.get(2), cnt = 3;
        for (int cur = 3; ; cur++) {
            if (cur > ceil) {
                a++;
                ceil = arr.get(a);
            }
            cnt += a;
            arr.add(cnt);
            if (cnt >= n)
                return cur;
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(new GoogleFunc().getF(i));

        }
    }
}
