package leetcode._1sttime.no076;

public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null ||
                s.length() == 0 || t.length() == 0 ||
                t.length() > s.length())
            return "";

        int[] oriCnt = new int[128];
        int[] cnt = new int[128];
        for (int i = 0; i < t.length(); i++)
            oriCnt[t.charAt(i)] ++;
        for (int i = 0; i < s.length(); i++)
            cnt[s.charAt(i)] ++;

        for (int i = 0; i < 128; i++) {
            if (oriCnt[i] > cnt[i])
                return "";
        }

        int start = 0, end = s.length()-1;
        while (end >= 0){
            char c = s.charAt(end);
            cnt[c] --;
            if (cnt[c] < oriCnt[c]){
                cnt[c] ++;
                break;
            }
            end --;
        }
        int minS = start, minE = end, minLen = end - start + 1;
        while (true){
            char c;
            for (c = s.charAt(start); cnt[c] != oriCnt[c]; c = s.charAt(start)){
                cnt[c] --;
                start ++;
            }

            if (minLen > (end - start + 1)){
                minLen = (end - start + 1);
                minS = start;
                minE = end;
            }
            cnt[c] --;
            start ++;
            if (end == s.length() - 1)
                break;
            else
                end++;

            while (end < s.length()){
                char c2 = s.charAt(end);
                cnt[c2] ++;
                if (c2 == c)
                    break;
                end ++;
            }
            if (end == s.length())
                break;
        }
        return s.substring(minS, minE+1);
    }
    public static void main(String[] args) {
		Solution sol = new Solution();
        System.out.println(sol.minWindow("acbbaca", "aba"));
        System.out.println(sol.minWindow("ADOBEjhgjhghgC", "ABC"));
        System.out.println(sol.minWindow("ADOBECABNC", "ABC"));
        System.out.println(sol.minWindow("ab", "a"));
    }
}