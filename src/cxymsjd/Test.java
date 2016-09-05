package cxymsjd;

/**
 * Created by Zhangkefei on 2016/3/6.
 */
public class Test {
    private int olen, plen;
    private String ori, pat;
    boolean[][] track;
    public boolean matches(String ori, String pat) {
        if (ori == null || pat == null) return false;
        olen=ori.length();
        plen=pat.length();

        this.ori = ori; this.pat = pat;
        track = new boolean[olen][plen];
        return tryMatch(0, 0);
    }

    private boolean tryMatch(int oi, int pi) {
        if (oi >= olen && pi >= plen) return true;

        if (pi >= plen) return false;

        if (oi >= olen) {
            if (pat.charAt(pi) == '*')
                return tryMatch(oi, pi+1);
            else
                return false;
        }

        if (track[oi][pi]) return false;

        char o = ori.charAt(oi), p = pat.charAt(pi);
        if ('*' == p) {
            for (int i = oi; i <= olen; i++) {
                if (tryMatch(i, pi+1)) return true;
            }
        }
        else if (o == p) {
            if (tryMatch(oi+1, pi+1)) return true;
        }

        track[oi][pi] = true;
        return false;
    }

    public static void main(String[] args) {
        Test sol = new Test();
        System.out.println(sol.matches("alibaba", "al*ba*"));
        System.out.println(sol.matches("", ""));
        System.out.println(sol.matches("", "*"));
        System.out.println(sol.matches("", "a"));
        System.out.println(sol.matches("a", "*"));
        System.out.println(sol.matches("abc", "*"));
    }
}
