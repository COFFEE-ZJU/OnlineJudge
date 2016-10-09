package leetcode.contest08.n4;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        Map<Integer, int[]> cache = new HashMap<>();
        int curR = -1, curC = cols, rep = 0;
        while (curR < rows) {
            int[] delta = null;
            rep++;
            delta = cache.get(curC);
            int stR = curR, stC = curC;
            if (delta != null) {
                curR += delta[0];
                curC = delta[1];
                continue;
            }

            for (int i = 0; i < sentence.length; i++) {
                String s = sentence[i];
                if (curC != cols) curC++;  //space
                if (curC + s.length() > cols) curC = cols;

                curC += s.length();
                if (curC > cols) {
                    curR++;
                    curC -= cols;
                    if (curC > cols) return 0;
                }
            }
            delta = new int[]{curR - stR, curC};
            cache.put(stC, delta);
        }
        return rep-1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution());
    }
}