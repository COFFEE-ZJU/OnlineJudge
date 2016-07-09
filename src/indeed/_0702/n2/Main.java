package indeed._0702.n2;

import java.util.*;

/**
 * Created by Zhangkefei on 2016/7/2.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<Integer, Integer> nums = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nums.put(i, scanner.nextInt()-1);
        }

        int cnt = 0;
        while (!nums.isEmpty()) {
            Integer key = nums.keySet().iterator().next();
            while ((key = nums.remove(key)) != null) {
            }
            cnt++;
        }

        System.out.println(cnt);
    }
}
