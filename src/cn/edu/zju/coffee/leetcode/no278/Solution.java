package cn.edu.zju.coffee.leetcode.no278;

public class Solution extends VersionControl{
    public int firstBadVersion(int n) {
        if (n <= 0) return 0;
        int st = 1, end = n+1;

        int first = Integer.MAX_VALUE;
        while (st < end){
            int mid = st / 2 + end / 2;
            if (isBadVersion(mid)){
                first = Math.min(first, mid);
                end = mid;
            }
            else
                st = mid + 1;
        }

        return first;
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
        System.out.println(sol.firstBadVersion(2126753390));
    }
}

class VersionControl {
    boolean isBadVersion(int version){
        return version >= 1702766719;
    }
}