package google.codejam.no5254487;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

import google.codejam.CodejamUtils;

public class MainC {
    private static class Interval {
        final int left, right;
        int excludeSize = 0;

        private Interval(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
    private static class Range {
        Interval holdingInterval = null;
        // 0, not held; 1, held by single Interval; 2, held by multiple Interval
        int holdingState = 0;
        final int left, right;
        Range prev, next;

        private Range(int left, int right) {
            this.left = left;
            this.right = right;
        }

        private int size() {
            return right - left;
        }
    }

    private long N, L1, R1, A, B, C1, C2, M;
    public void deal(Scanner scanner, Writer writer) throws IOException {

        int t = scanner.nextInt();
        for(int tt = 0; tt < t; tt++){
            System.out.println("solving case " + tt);
            N = scanner.nextInt();
            L1 = scanner.nextInt();
            R1 = scanner.nextInt();
            A = scanner.nextInt();
            B = scanner.nextInt();
            C1 = scanner.nextInt();
            C2 = scanner.nextInt();
            M = scanner.nextInt();

            long res = solve();

            writer.write(String.format("Case #%d: %s\n", tt+1, res));
        }
    }

    private SortedSet<Integer> cutPoints = new TreeSet<>();
    private List<Interval> intervals = new ArrayList<>();
    private Map<Integer, Range> rangeMap = new HashMap<>();
    private long solve() {
        cutPoints.clear();
        intervals.clear();
        rangeMap.clear();

        long x = L1, y = R1;
        for (int i = 0; i < N; i++) {
            int left = (int)Math.min(x, y), right = (int)Math.max(x, y) + 1;
            intervals.add(new Interval(left, right));
            cutPoints.add(left);
            cutPoints.add(right);
            long nx = (A * x + B * y + C1) % M;
            long ny = (A * y + B * x + C2) % M;
            x = nx; y = ny;
        }
        Integer prev = null;
        Range prevRange = null;
        for (Integer cutPoint : cutPoints) {
            if (prev == null) {
                prev = cutPoint;
                continue;
            }
            Range range = new Range(prev, cutPoint);
            if (prevRange != null) {
                range.prev = prevRange;
                prevRange.next = range;
            }
            rangeMap.put(prev, range);
            prev = cutPoint;
            prevRange = range;
        }

        long totalSize = 0;
        for (Interval inter : intervals) {
            Range cur = get1stRange(inter.left);
            while (cur != null && cur.left < inter.right) {
                if (cur.holdingState == 0) {
                    inter.excludeSize += cur.size();
                    cur.holdingState = 1;
                    cur.holdingInterval = inter;
                    totalSize += cur.size();
                } else if (cur.holdingState == 1) {
                    cur.holdingState = 2;
                    cur.holdingInterval.excludeSize -= cur.size();

                    cutOut(cur);
                }

                cur = cur.next;
            }
        }

        long maxExcludeSize = 0;
        for (Interval inter : intervals) {
            maxExcludeSize = Math.max(maxExcludeSize, inter.excludeSize);
        }

        return totalSize - maxExcludeSize;
    }

    private List<Integer> keys = new ArrayList<>();
    private Range get1stRange(int left) {
        keys.clear();
        Range range = rangeMap.get(left);
        while (range != null && range.holdingState == 2) {
            keys.add(range.left);
            range = range.next;
        }
        for (Integer k : keys)
            rangeMap.put(k, range);
        return range;
    }

    private void cutOut(Range range) {
        if (range.prev != null) {
            range.prev.next = range.next;
        }
        if (range.next != null) {
            range.next.prev = range.prev;
        }
    }

    public static void main(String[] args) throws IOException {
        String fileName = "C-large-practice";
        Scanner scanner = CodejamUtils.getScanner(fileName, MainC.class);
        Writer writer = CodejamUtils.getWriter(fileName, MainC.class);

        new MainC().deal(scanner, writer);

        scanner.close();
        writer.close();
    }
}
