package leetcode.no108and109;

import leetcode.ListNode;
import leetcode.TreeNode;

public class Solution {
    private int[] nums;

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;

        this.nums = nums;
        return buildTree(0, nums.length);
    }

    private TreeNode buildTree(int st, int end){
        if (st >= end)
            return null;
        if (st + 1 == end)
            return new TreeNode(nums[st]);

        int mid = (st + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildTree(st, mid);
        node.right = buildTree(mid + 1, end);
        return node;
    }

    public TreeNode sortedListToBST(ListNode head) {
        return sortedArrayToBST(listToNums(head));
    }

    private static int[] listToNums(ListNode head){
        if (head == null)
            return null;

        int len = 0;
        for (ListNode node = head; node != null; node = node.next)
            len ++;

        int[] nums = new int[len];
        int i = 0;
        for (ListNode node = head; node != null; node = node.next)
            nums[i++] = node.val;

        return nums;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = new int[]{-99,-98,-97,-96,-94,-93,-91,-90,-88,-87,-86,-85,-83,-81,-80,-79,-78,-76,-73,-72,-70,-69,-66,-65,-64,-63,-61,-59,-57,-56,-55,-54,-53,-52,-51,-48,-45,-44,-43,-42,-41,-40,-39,-37,-34,-33,-32,-31,-30,-28,-26,-24,-22,-20,-19,-18,-16,-15,-14,-12,-10,-9,-8,-6,-5,-4,-3,-2,-1,0,1,2,5,7,8,9,10,11,15,16,17,19,20,21,23,24,26,27,28,30,33,35,36,38,49,50,51,52,54,55,56,57,58,59,60,61,64,65,67,69,70,71,72,73,74,77,79,81,82,85,86,87,88,90,91,94,95,96,97,99};
//        int[] nums = new int[]{1,2,3};
        sol.sortedArrayToBST(nums);
    }
}