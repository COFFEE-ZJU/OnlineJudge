package cn.edu.zju.coffee.leetcode.no218;

import java.util.*;

public class Solution {
    private PriorityQueue<Point> queue = new PriorityQueue<>();
    public List<int[]> getSkyline(int[][] buildings) {
        if (buildings == null || buildings.length == 0)
            return Collections.emptyList();

        int curX = 0, curI = 0;
        int len = buildings.length;
        List<int[]> res = new LinkedList<>();
        queue.clear();
        while (!(queue.isEmpty() && curI == len)) {
            long q = queue.isEmpty() ? Long.MAX_VALUE : queue.peek().x;
            long b = curI == len ? Long.MAX_VALUE : buildings[curI][0];
            if (b <= q) {
                int[] bd = buildings[curI++];
                curX = bd[0];
                queue.add(new Point(bd[2], bd[1]));
                Point peek = queue.peek();
                if (peek.height <= bd[2])
                    res.add(new int[]{bd[0], bd[2]});
            } else {
                Point point = queue.poll();
                if (point.x > curX) {
                    curX = point.x;
                    res.add(new int[]{point.x, point.height});
                }
            }
            if (queue.isEmpty())
                res.add(new int[]{curX, 0});
        }

        List<int[]> res2 = new LinkedList<>();
        int[] prev = null;
        for (int[] pt : res){
            if (prev == null) {
                prev = pt;
                continue;
            }

            int[] pta = null;
            if (pt[1] >= prev[1] && (res2.isEmpty() || res2.get(res2.size()-1)[1] != prev[1]))
                pta = prev;
            else
                pta = new int[]{prev[0], pt[1]};


            if (pta != null && (res2.isEmpty() || res2.get(res2.size()-1)[1] != pta[1])){
                if (res2.isEmpty())
                    res2.add(pta);
                else {
                    int[] pp = res2.remove(res2.size()-1);
                    if (pp[0] == pta[0])
                        res2.add(pp);
                    else if (pp[1] == pta[1])
                        res2.add(pta);
                    else {
                        res2.add(pp);
                        res2.add(pta);
                    }
                }
            }

            if (pt[1] == 0)
                prev = null;
            else
                prev = pt;
        }
        return res;
    }

    private static class Point implements Comparable<Point>{
        final int height;
        final int x;

        private Point(int height, int x) {
            this.height = height;
            this.x = x;
        }

        @Override
        public int compareTo(Point o) {
            return Integer.compare(o.height, height);
        }
    }
	
	public static void main(String[] args) {
		Solution sol = new Solution();
        List<int[]> res = sol.getSkyline(new int[][]{
                new int[]{1,2,1},
                new int[]{1,2,2},
                new int[]{1,2,3},
        });
        for (int[] r : res)
            System.out.println(Arrays.toString(r));

        res = sol.getSkyline(new int[][]{
                new int[]{0, 2, 3},
                new int[]{2, 5, 3},
        });
        for (int[] r : res)
            System.out.println(Arrays.toString(r));

        res = sol.getSkyline(new int[][]{
                new int[]{2, 9, 10},
                new int[]{3, 7, 15},
                new int[]{5, 12, 12},
                new int[]{15, 20, 10},
                new int[]{19, 24, 8}
        });
        for (int[] r : res)
            System.out.println(Arrays.toString(r));
    }
}
