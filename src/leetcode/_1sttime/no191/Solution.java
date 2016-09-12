package leetcode._1sttime.no191;

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int cnt = 0;
        while (n != 0) {
            n &= (n-1);
            cnt++;
        }

        return cnt;
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
    }
}