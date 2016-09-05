package leetcode._1sttime.no303;

public class NumArray {
    private long[] sums;

    public NumArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        int len = nums.length;
        sums = new long[len];
        long sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            sums[i] = sum;
        }
    }

    public int sumRange(int i, int j) {
        if (i > j || i < 0 || i >= sums.length || j < 0 || j >= sums.length)
            throw new ArrayIndexOutOfBoundsException();

        return (int) (i == 0 ? sums[j] : sums[j] - sums[i-1]);
    }

    public static void main(String[] args) {
    }
}
