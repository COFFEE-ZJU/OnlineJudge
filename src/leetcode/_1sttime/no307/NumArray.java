package leetcode._1sttime.no307;

public class NumArray {
    private static class RangeTree {
        final int start, end;
        int sum;
        RangeTree left, right;

        private RangeTree(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private int[] nums;
    private RangeTree rangeTree;

    public NumArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        int len = nums.length;
        this.nums = nums;
        rangeTree = new RangeTree(0, len);
        calc(rangeTree);

    }

    private void calc(RangeTree tree) {
        int st = tree.start, end = tree.end;
        if (st + 1 == end) {
            tree.sum = nums[st];
            return;
        }

        int mid = (st + end) / 2;
        tree.left = new RangeTree(st, mid);
        tree.right = new RangeTree(mid, end);
        calc(tree.left);
        calc(tree.right);
        tree.sum = tree.left.sum + tree.right.sum;
    }

    private void update(int i, int diff, RangeTree tree) {
        tree.sum += diff;
        int st = tree.start, end = tree.end;
        if (st + 1 == end)
            return;

        if (i < (st + end) / 2)
            update(i, diff, tree.left);
        else
            update(i, diff, tree.right);
    }

    public void update(int i, int val) {
        if (i < 0 || i >= nums.length || val == nums[i]) return;

        int diff = val - nums[i];
        nums[i] = val;
        update(i, diff, rangeTree);
    }

    public int sumRange(int i, int j) {
        if (i > j || i < 0 || i >= nums.length || j < 0 || j >= nums.length)
            throw new ArrayIndexOutOfBoundsException();

        return sumRange(i, j+1, rangeTree);
    }

    private int sumRange(int i, int j, RangeTree tree) {
        int st = tree.start, end = tree.end;
        if (st == i && end == j) return tree.sum;
        int mid = (st + end) / 2;

        if (i >= mid) return sumRange(i, j, tree.right);
        else if (j <= mid) return sumRange(i, j, tree.left);
        else return sumRange(i, mid, tree.left) + sumRange(mid, j, tree.right);
    }

    public static void main(String[] args) {
        NumArray na = new NumArray(new int[]{0,9,5,7,3});
        System.out.println(na.sumRange(4,4));
    }
}
