import java.util.Scanner;

/**
 * Created by Zhangkefei on 2016/9/11.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int tt = 0; tt < t; tt++) {
            String[] ds = scanner.next().split(",");
            int len = ds.length;
            int[] nums = new int[len];

            for (int i = 0; i < len; i++) {
                nums[i] = Integer.parseInt(ds[i]);
            }

            System.out.println(Math.max(maxSum(nums, 0, len-1), maxSum(nums, 1, len)));
        }
    }

    private static int maxSum(int[] nums, int st, int end) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int max1 = 0, max2 = nums[st];
        for (int i = st+1; i < end; i++) {
            int mm = max1 + nums[i];
            max1 = max2;
            max2 = Math.max(max2, mm);
        }

        return max2;
    }

}
