package cn.edu.zju.coffee.leetcode.no331;

public class Solution {
    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0)
            return true;

        String[] nodes = preorder.split(",");
        int curNum = 1;
        for (String node : nodes) {
            if (curNum <= 0) return false;

            if ("#".equals(node))
                curNum --;
            else
                curNum ++;
        }

        return curNum == 0;
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
    }
}
