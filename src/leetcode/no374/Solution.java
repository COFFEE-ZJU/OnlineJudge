package leetcode.no374;

class GuessGame {
    int guess(int x) {return 0;}
}

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        if (n <= 0) return 0;

        int left = 1, right = n;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            int res = guess(mid);
            if (res == 0) return mid;

            if (res < 0)
                right = mid-1;
            else
                left = mid+1;
        }

        return 0;
    }
}