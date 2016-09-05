package leetcode._1sttime.no089;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<Integer> grayCode(int n) {
        if (n <= 0)
            return Collections.singletonList(0);
        List<Integer> nums = new ArrayList<>(1 << n);
        nums.add(0); nums.add(1);
        for (int cur = 2; cur <= (1<<(n-1)); cur = cur << 1){
            for (int i = 0; i < cur; i++)
                nums.add(cur + nums.get(cur - i - 1));
        }

        return nums;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.grayCode(2));
        System.out.println(sol.grayCode(3));
    }
}