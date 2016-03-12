package cn.edu.zju.coffee.leetcode.no038;

public class Solution {
    public String countAndSay(int n) {
        if (n <= 1) return "1";
        StringBuilder sb1 = new StringBuilder("1");
        StringBuilder sb2 = new StringBuilder();
        for (int i = 1; i < n; i++) {
            sb2.setLength(0);
            char prev = sb1.charAt(0);
            int cnt = 1;
            for (int j = 1; j < sb1.length(); j++) {
                char cur = sb1.charAt(j);
                if (cur == prev) cnt++;
                else {
                    sb2.append(cnt).append(prev);
                    prev = cur;
                    cnt = 1;
                }
            }
            sb2.append(cnt).append(prev);
            StringBuilder tmp = sb2;
            sb2 = sb1;
            sb1 = tmp;
        }

        return sb1.toString();
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
        System.out.println(sol.countAndSay(1));
        System.out.println(sol.countAndSay(2));
        System.out.println(sol.countAndSay(4));
    }
}
