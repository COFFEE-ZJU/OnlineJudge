package nowcoder.mogujie.y2016.n02;

import java.util.Scanner;

/**
 * Created by zkf on 3/17/16.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++)
                nums[i] = scanner.nextInt();

            if (n < 3) {
                System.out.println(0);
                continue;
            }
            int maxGap = 0;
            for (int i = 1; i < n; i++)
                maxGap = Math.max(nums[i]-nums[i-1], maxGap);

            int min2Gap = Integer.MAX_VALUE;
            for (int i = 2; i < n; i++)
                min2Gap = Math.min(nums[i]-nums[i-2], min2Gap);

            System.out.println(Math.max(maxGap, min2Gap));
        }
        scanner.close();
    }
}
