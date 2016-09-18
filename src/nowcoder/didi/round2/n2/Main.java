package nowcoder.didi.round2.n2;

import java.util.*;

/**
 * Created by zkf on 9/18/16.
 */
public class Main {
    private class Node implements Comparable<Node>{
        final int r, c;
        final boolean block;
        int len;
        Node prev;
        boolean visited = false;

        private Node(int r, int c, int blk) {
            this.r = r;
            this.c = c;
            this.block = blk == 0;
            len = Integer.MAX_VALUE;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(len, o.len);
        }

        public void visitNbrs() {
            if (r - 1 >= 0) visit(board[r-1][c], 3);
            if (r + 1 < n) visit(board[r+1][c], 0);
            if (c - 1 >= 0) visit(board[r][c-1], 1);
            if (c + 1 < m) visit(board[r][c+1], 1);
        }

        private void visit(Node nbr, int path) {
            if (!nbr.block && !nbr.visited && len + path < nbr.len) {
                heap.remove(nbr);
                nbr.len = len + path;
                nbr.prev = this;
                heap.add(nbr);
            }
        }

        @Override
        public String toString() {
            return "[" + r + "," + c + "]";
        }
    }

    private int m, n, p;
    private List<int[]> res;
    private Node[][] board;
    PriorityQueue<Node> heap = new PriorityQueue<>();
    private void deal() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            p = scanner.nextInt();
            res = new ArrayList<>();
            board = new Node[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    board[i][j] = new Node(i,j,scanner.nextInt());
                }
            }
            solve();
        }
    }

    private void solve() {
        heap.clear();
        Node st = board[0][0];
        st.prev = st;
        st.len = 0;
        heap.add(st);
        while (!heap.isEmpty()) {
            Node cur = heap.poll();
            cur.visited = true;
            if (cur.r == 0 && cur.c == m-1) break;
            cur.visitNbrs();
        }

        Node dst = board[0][m-1];
        if (dst.visited && dst.len <= p) {
            List<Node> list = new LinkedList<>();
            while (dst.prev != dst) {
                list.add(0, dst);
                dst = dst.prev;
            }
            list.add(0, dst);
            StringBuilder sb = new StringBuilder();
            for (Node n : list) {
                sb.append(',').append(n);
            }
            System.out.println(sb.substring(1));
        } else {
            System.out.println("Can not escape!");
        }
    }

    public static void main(String[] args) {
        new Main().deal();
    }
}
