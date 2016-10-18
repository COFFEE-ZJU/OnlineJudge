package leetcode._2ndtime.no335;

/**
 * Whiteboard coding!
 *
 */
public class Solution {
    private static class Line {
        final int x0, y0, x1, y1;

        private Line(int x0, int y0, int x1, int y1) {
            this.x0 = x0;
            this.y0 = y0;
            this.x1 = x1;
            this.y1 = y1;
        }
    }
    public boolean isSelfCrossing(int[] x) {
        int len;
        if (x == null || (len = x.length) <= 3) return false;

        Line pppVert, ppVert, pVert, pppHori, ppHori, pHori;
        pppVert = pppHori = ppHori = ppVert = null;
        pVert = pHori = new Line(0,0,0,0);
        int curX = 0, curY = 0;
        for (int i = 0; i < len;) {
            Line cur = new Line(curX, curY, curX, curY + x[i]);
            curY += x[i++];
            if (cross(cur, pppHori) || cross(cur, ppHori)) return true;
            pppVert = ppVert;
            ppVert = pVert;
            pVert = cur;
            if (i >= len) break;

            cur = new Line(curX - x[i], curY, curX, curY);
            curX -= x[i++];
            if (cross(cur, pppVert) || cross(cur, ppVert)) return true;
            pppHori = ppHori;
            ppHori = pHori;
            pHori = cur;
            if (i >= len) break;

            cur = new Line(curX, curY - x[i], curX, curY);
            curY -= x[i++];
            if (cross(cur, pppHori) || cross(cur, ppHori)) return true;
            pppVert = ppVert;
            ppVert = pVert;
            pVert = cur;
            if (i >= len) break;

            cur = new Line(curX, curY, curX + x[i], curY);
            curX += x[i++];
            if (cross(cur, pppVert) || cross(cur, ppVert)) return true;
            pppHori = ppHori;
            ppHori = pHori;
            pHori = cur;
        }

        return false;
    }

    private boolean cross(Line cur, Line prev) {
        if (prev == null) return false;

        if (cur.x1 < prev.x0 || cur.x0 > prev.x1 || cur.y0 > prev.y1 || cur.y1 < prev.y0)
            return false;

        return true;
    }

    public static void main(String[] args) {
        new Solution().isSelfCrossing(new int[]{1,2,3,4});
    }
}