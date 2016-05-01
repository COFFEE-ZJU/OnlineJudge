package practice;

import java.util.Arrays;

/**
 * Given a string e.g. ABCDAABCD. Shuffle he string so that no two smilar letters together.
 * E.g. AABC can be shuffled as ABAC.
 *
 * Created by zkf on 4/26/16.
 */
public class ShuffleString {
    private static class CharCnt implements Comparable<CharCnt>{
        final char c;
        int cnt;

        private CharCnt(char c) {
            this.c = c;
            cnt = 0;
        }

        @Override
        public int compareTo(CharCnt o) {
            return Integer.compare(o.cnt, cnt);
        }
    }

    public String shuffle(String ori) {
        CharCnt[] cnts = new CharCnt[128];
        for (int i = 0; i < 128; i++) {
            cnts[i] = new CharCnt((char)i);
        }
        char[] cs = ori.toCharArray();
        for (char c : cs) {
            cnts[c].cnt++;
        }

        Arrays.sort(cnts);
        int idx1 = 0, idx2 = 0;
        for (; idx1 < cs.length; idx1+=2) {
            if (cnts[idx2].cnt == 0) {
                idx2++;
            }
            cs[idx1] = cnts[idx2].c;
            cnts[idx2].cnt--;
        }
        for (idx1 = 1; idx1 < cs.length; idx1+=2) {
            if (cnts[idx2].cnt == 0) {
                idx2++;
            }
            cs[idx1] = cnts[idx2].c;
            cnts[idx2].cnt--;
        }

        return new String(cs);
    }

    public static void main(String[] args) {
        ShuffleString sol = new ShuffleString();
        System.out.println(sol.shuffle("AABC"));
        System.out.println(sol.shuffle("ABBCCC"));
        System.out.println(sol.shuffle("CCCCCBBBBD"));
    }
}
