package leetcode._1sttime.no335;

public class Solution {
    private VertLine vert, pVert, ppVert;
    private HoriLine hori, pHori, ppHori;
    public boolean isSelfCrossing(int[] x) {
        int len;
        if (x == null || (len=x.length) < 4) return false;

        int curX = 0, curY = 0;
        vert = pVert = ppVert = null;
        pHori = ppHori = null;
        hori = new HoriLine(0,0,0);

        for (int i = 0;;) {
            if (i >= len) break;
            VertLine vert = new VertLine(curX, curY, curY + x[i]);
            curY += x[i];
            i++;
            if (checkCrossAndUpdateVert(vert))
                return true;

            if (i >= len) break;
            HoriLine hori = new HoriLine(curX - x[i], curX, curY);
            curX -= x[i];
            i++;
            if (checkCrossAndUpdateHori(hori))
                return true;

            if (i >= len) break;
            vert = new VertLine(curX, curY - x[i], curY);
            curY -= x[i];
            i++;
            if (checkCrossAndUpdateVert(vert))
                return true;

            if (i >= len) break;
            hori = new HoriLine(curX, curX + x[i], curY);
            curX += x[i];
            i++;
            if (checkCrossAndUpdateHori(hori))
                return true;
        }

        return false;
    }

    private boolean checkCrossAndUpdateHori(HoriLine hori) {
        if (checkCross(ppVert, hori) || checkCross(pVert, hori))
            return true;

        ppHori = pHori;
        pHori = this.hori;
        this.hori = hori;
        return false;
    }

    private boolean checkCrossAndUpdateVert(VertLine vert) {
        if (checkCross(vert, ppHori) || checkCross(vert, pHori))
            return true;

        ppVert = pVert;
        pVert = this.vert;
        this.vert = vert;
        return false;
    }

    private boolean checkCross(VertLine vert, HoriLine hori) {
        if (vert == null || hori == null)
            return false;

        if (vert.x >= hori.x0 && vert.x <= hori.x1 &&
                hori.y >= vert.y0 && hori.y <= vert.y1)
            return true;

        return false;
    }

    private static class VertLine {
        final long x, y0, y1;

        private VertLine(long x, long y0, long y1) {
            this.x = x;
            this.y0 = y0;
            this.y1 = y1;
        }
    }
    private static class HoriLine {
        final long x0, x1, y;

        private HoriLine(long x0, long x1, long y) {
            this.x0 = x0;
            this.x1 = x1;
            this.y = y;
        }
    }

    public static void main(String[] args) {
		Solution sol = new Solution();
        System.out.println(sol.isSelfCrossing(new int[]{1, 2, 3, 4}));
        System.out.println(sol.isSelfCrossing(new int[]{2, 1, 1, 2}));
        System.out.println(sol.isSelfCrossing(new int[]{1, 1, 1, 1}));
        System.out.println(sol.isSelfCrossing(new int[]{1, 1, 2, 1, 1}));
    }
}
