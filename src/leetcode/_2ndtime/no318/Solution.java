package leetcode._2ndtime.no318;

/**
 * Whiteboard coding!
 */
public class Solution {
    private static class Word {
        final String w;
        final int mark;
        Word(String w) {
            this.w = w;
            int m = 0;
            for (int i = 0; i < w.length(); i++) {
                int idx = "abcdefghijklmnopqrstuvwxyz".indexOf(w.charAt(i));
                m |= 1 << idx;
            }
            mark = m;
        }
    }

    public int maxProduct(String[] words) {
        int max = 0;
        Word[] ws = new Word[words.length];
        for (int i = 0; i < words.length; i++) {
            ws[i] = new Word(words[i]);
        }
        for (int i = 0; i < words.length-1; i++) {
            Word wi = ws[i];
            for (int j = i+1; j < words.length; j++) {
                Word wj = ws[j];
                if ((wi.mark & wj.mark) == 0) {
                    max = Math.max(max, wi.w.length() * wj.w.length());
                }
            }
        }
        return max;
    }
}