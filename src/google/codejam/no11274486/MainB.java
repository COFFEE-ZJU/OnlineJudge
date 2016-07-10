package google.codejam.no11274486;

import google.codejam.CodejamUtils;

import java.io.IOException;
import java.io.Writer;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MainB {
    static Cell[][] mat;
    static int r, c, inc;
    static PriorityQueue<Cell> queue = new PriorityQueue<>();
	
	public static void main(String[] args) throws IOException {
		Scanner scanner = CodejamUtils.getScanner("B-large", MainB.class);
		Writer writer = CodejamUtils.getWriter("B-large", MainB.class);

		int t = scanner.nextInt();
		for(int tt = 0; tt < t; tt++){
			r = scanner.nextInt();
            c = scanner.nextInt();
            mat = new Cell[r][c];
            queue.clear();
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    mat[i][j] = new Cell(i, j, scanner.nextInt());
                }
            }
            inc = 0;
            while (!queue.isEmpty()) {
                Cell cur = queue.poll();
                dfs(cur);
            }

            writer.write(String.format("Case #%d: %s\n", tt+1, inc));
		}
		
		scanner.close();
		writer.close();

	}

    private static void dfs(Cell cur) {
        int ri = cur.ri, ci = cur.ci;
        Cell tmp;
        if (ri != 0) {
            tmp = mat[ri-1][ci];
            markAndDfs(tmp, cur);
        }
        if (ci != 0) {
            tmp = mat[ri][ci-1];
            markAndDfs(tmp, cur);
        }
        if (ri != r-1) {
            tmp = mat[ri+1][ci];
            markAndDfs(tmp, cur);
        }
        if (ci != c-1) {
            tmp = mat[ri][ci+1];
            markAndDfs(tmp, cur);
        }
    }

    private static void markAndDfs(Cell tmp, Cell cur) {
        if (!tmp.marked) {
            tmp.marked = true;
            if (tmp.height > cur.height) {
                queue.add(tmp);
            }
            else {
                inc += cur.height - tmp.height;
                tmp.height = cur.height;
                dfs(tmp);
            }
        }
    }

    private static class Cell implements Comparable<Cell>{
        final int ri, ci;
        int height;
        boolean marked = false;

        private Cell(int ri, int ci, int height) {
            this.ri = ri;
            this.ci = ci;
            this.height = height;

            if (ri == 0 || ci == 0 || ri == r-1 || ci == c-1) {
                marked = true;
                queue.add(this);
            }
        }

        @Override
        public int compareTo(Cell o) {
            return Integer.compare(height, o.height);
        }
    }
}
