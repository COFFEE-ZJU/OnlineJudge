package leetcode._2ndtime.no316;

import java.util.Stack;

/**
 * Whiteboard coding!
 */
public class Solution {
    public String removeDuplicateLetters(String s) {
        int len;
        if (s == null || (len=s.length()) == 0) return s;
        int[] cnt = new int[26];
        for (int i = 0; i < len; i++) cnt[s.charAt(i)-'a']++;

        boolean[] visited = new boolean[26];
        Stack<Character> str = new Stack<>();
        for (int i = 0; i < len; i++) {
            char cur = s.charAt(i);
            int idx = s.charAt(i) - 'a';
            cnt[idx]--;
            if (visited[idx]) continue;
            char c;
            while (!str.isEmpty() && (c=str.peek()) > cur && cnt[c-'a'] != 0) {
                str.pop();
                visited[c-'a'] = false;
            }
            str.push(cur);
            visited[idx] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!str.isEmpty()) sb.append(str.pop());
        return sb.reverse().toString();
    }
}