package leetcode.no315;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    private Tree root = null;

    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.emptyList();

        List<Integer> ret = new LinkedList<>();
        for (int i = nums.length-1; i >= 0 ; i--) {
            root = insert(root, nums[i]);
            ret.add(0, getCnt(root, nums[i], 0));
        }

        return ret;
    }

    private int getCnt(Tree tree, int num, int prevCnt) {
        if (tree.val == num)
            return tree.leftCnt + prevCnt;
        if (tree.val > num)
            return getCnt(tree.left, num, prevCnt);
        else
            return getCnt(tree.right, num, prevCnt + tree.leftCnt + tree.cnt);
    }

    private Tree insert(Tree tree, int num) {
        if (tree == null) {
            tree = new Tree(num, 1, 0);
            return tree;
        }

        if (tree.val < num)
            tree.right = insert(tree.right, num);
        else if (tree.val == num)
            tree.cnt++;
        else {
            tree.leftCnt++;
            tree.left = insert(tree.left, num);
        }

        return tree;
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
        System.out.println(sol.countSmaller(new int[]{5, 2, 6, 1}));
    }
}

class Tree {
    int leftCnt;
    int cnt;
    int val;

    Tree left;
    Tree right;

    Tree(int val, int cnt, int leftCnt) {
        this.leftCnt = leftCnt;
        this.cnt = cnt;
        this.val = val;
    }
}