package leetcode.no093;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    private List<String> retList;
    private char[] cs;
    private String s;
    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() < 4 || s.length() > 12)
            return Collections.emptyList();

        retList = new LinkedList<>();
        cs = s.toCharArray();
        this.s = s;
        int[] poses = new int[4];

        tryRestore(poses, 0);

        return retList;
    }

    private void addString(int[] poses){
        retList.add(s.substring(0, poses[0]+1) + "." +
                s.substring(poses[0]+1, poses[1]+1) + "." +
                s.substring(poses[1]+1, poses[2]+1) + "." +
                s.substring(poses[2]+1, poses[3]+1));

    }

    public void tryRestore(int[] poses, int idx){
        int s;
        if (idx == 4){
            if (poses[idx - 1] != cs.length - 1)
                return;

            addString(poses);
            return;
        }

        if (idx == 0)
            s = 0;
        else
            s = poses[idx - 1] + 1;

        if (s >= cs.length)
            return;

        if (isLegal(cs[s])){
            poses[idx] = s;
            tryRestore(poses, idx+1);
        }

        if (s+1 >= cs.length)
            return;

        if (isLegal(cs[s], cs[s+1])) {
            poses[idx] = s+1;
            tryRestore(poses, idx+1);
        }

        if (s+2 >= cs.length)
            return;
        if (isLegal(cs[s], cs[s+1], cs[s+2])){
            poses[idx] = s+2;
            tryRestore(poses, idx+1);
        }
    }

    private boolean isLegal(char c){
        return (c >= '0' && c <= '9');
    }

    private boolean isLegal(char c1, char c2){
        int n = (c1 - '0') * 10 + (c2 - '0');
        return (n >= 10 && n <= 99);
    }

    private boolean isLegal(char c1, char c2, char c3){
        int n = (c1 - '0') * 100 + (c2 - '0') * 10 + (c3 - '0');
        return (n >= 100 && n <= 255);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.restoreIpAddresses("1111"));
        System.out.println(sol.restoreIpAddresses("25525511135"));
    }
}