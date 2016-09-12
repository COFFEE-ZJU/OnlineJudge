package leetcode._2ndtime.no331;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Whiteboard coding!
 *
 */
public class Solution {
    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) return true;

        Deque<Integer> stack = new ArrayDeque<>();
        String[] tokens = preorder.split(",");
        for (String token : tokens) {
            int status = "#".equals(token) ? 2 : 0;
            while (status == 2 && !stack.isEmpty()) {
                status = stack.pop();
                if (status >= 2) return false;
                status++;
            }
            stack.push(status);
        }

        return stack.size() == 1 && stack.pop() == 2;
    }
}