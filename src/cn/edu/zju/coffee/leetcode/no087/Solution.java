package cn.edu.zju.coffee.leetcode.no087;

public class Solution {
    char[] c1, c2;
    int len;

    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null || (len = s1.length()) != s2.length())
            return false;
        if (len == 0)
            return true;

        c1 = s1.toCharArray();
        c2 = s2.toCharArray();
        return isScrambledEqual(0, len, 0, len);
    }
    
    private boolean isScrambledEqual(int s1, int e1, int s2, int e2){
        int len = e1 - s1;
        if (len == 1)
            return c1[s1] == c2[s2];
        
        int hash1 = 0, hash2 = 0;
        for (int i = 0; i < len; i++) {
            hash1 += c1[s1+i];
            hash2 += c2[s2+i];
        }
        if (hash1 != hash2)
            return false;
        
        int mid1 = (s1+e1) / 2, mid2 = (s2+e2) / 2;
        if (len % 2 == 0){
            return (isScrambledEqual(s1, mid1, s2, mid2) && isScrambledEqual(s1, mid1, s2, mid2)) ||
                    (isScrambledEqual(s1, mid1, mid2, e2) && isScrambledEqual(mid1, e1, s2, mid2));
        }
        else {
            return (isScrambledEqual(s1, mid1, s2, mid2) && isScrambledEqual(mid1, e1, mid2, e2)) ||
                    (isScrambledEqual(s1, mid1, mid2+1, e2) && isScrambledEqual(mid1, e1, s2, mid2+1)) ||
                    (isScrambledEqual(s1, mid1+1, mid2, e2) && isScrambledEqual(mid1+1, e1, s2, mid2)) ||
                    (isScrambledEqual(s1, mid1+1, s2, mid2+1) && isScrambledEqual(mid1+1, e1, mid2+1, e2));
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isScramble("abb", "bab"));
        System.out.println(sol.isScramble("great", "great"));
        System.out.println(sol.isScramble("great", "eatgr"));
        System.out.println(sol.isScramble("great", "rgeat"));
        System.out.println(sol.isScramble("great", "rgeat1"));
        System.out.println(sol.isScramble("great", "agert"));
        System.out.println(sol.isScramble("great", "ag"));
    }
}