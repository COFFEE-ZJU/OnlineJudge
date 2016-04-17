package leetcode._2ndtime.no307;

public class NumArray {
    private int len;
    private int[] tree;
    private int[] num;

    public NumArray(int[] nums) {
        this.num = nums;
        len = num.length;
        tree = new int[len+1];
        for (int i = 0; i < len; i++) {
            updateDiff(i, nums[i]);
        }
    }

    private void updateDiff(int i, int diff) {
        i++;
        while (i <= len) {
            tree[i] += diff;
            i += (i & -i);
        }
    }

    void update(int i, int val) {
        if (val == num[i]) return;

        updateDiff(i, val - num[i]);
        num[i] = val;
    }

    private int sum(int i) {
        int sum = 0;
        i++;
        while (i != 0) {
            sum += tree[i];
            i -= (i & -i);
        }
        return sum;
    }

    public int sumRange(int i, int j) {
        if (i > j) return 0;
        if (i < 0) i = 0;
        if (j >= len) j = len-1;

        return sum(j) - sum(i-1);
    }

    public static void main(String[] args) {
        NumArray na = new NumArray(new int[]{0,9,5,7,3});
        System.out.println(na.sumRange(4,4));
        System.out.println(na.sumRange(1,2));
    }
}
