package cxymsjd.n1_2;

/**
 * Whiteboard coding!
 * From nowcoder.com
 * Created by zkf on 4/22/16.
 */
public class Same {
    public boolean checkSam(String stringA, String stringB) {
        // write code here
        if (stringA == stringB) return true;

        int len;
        if (stringA == null || stringB == null || (len=stringA.length()) != stringB.length()) return false;

        int[] cnt = new int[128];
        for (int i = 0; i < len; i++)
            cnt[stringA.charAt(i)]++;

        for (int i = 0; i < len; i++) {
            char c = stringB.charAt(i);
            if (cnt[c] == 0) return false;
            cnt[c]--;
        }

        return true;
    }
}
