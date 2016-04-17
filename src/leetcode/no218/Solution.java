package leetcode.no218;

import java.util.*;

public class Solution {
    private static class Building implements Comparable<Building>{
        int left, right, height;
        Building(int[] data) {
            left = data[0];
            right = data[1];
            height = data[2];
        }

        @Override
        public int compareTo(Building o) {
            return Integer.compare(o.height, height);
        }
    }

    private static class Point {
        List<Building> toMoveIn = new LinkedList<>();
        List<Building> toMoveOut = new LinkedList<>();

        int height = 0;
    }

    private TreeMap<Integer, Point> pointMap = new TreeMap<>();
    private PriorityQueue<Building> curBuildings = new PriorityQueue<>();

    private Point getChangeByPoint(int idx) {
        Point point = pointMap.get(idx);
        if (point == null) {
            point = new Point();
            pointMap.put(idx, point);
        }

        return point;
    }

    public List<int[]> getSkyline(int[][] buildings) {
        if (buildings == null || buildings.length == 0)
            return Collections.emptyList();

        pointMap.clear();

        for (int[] b : buildings) {
            Building building = new Building(b);
            Point moveIn = getChangeByPoint(building.left);
            Point moveOut = getChangeByPoint(building.right);
            moveIn.toMoveIn.add(building);
            moveOut.toMoveOut.add(building);
        }

        curBuildings.clear();
        for (Point point : pointMap.values()) {
            for (Building b : point.toMoveIn)
                curBuildings.add(b);
            for (Building b : point.toMoveOut)
                curBuildings.remove(b);

            point.height = curBuildings.isEmpty() ?
                    0 : curBuildings.peek().height;
        }

        List<int[]> res = new LinkedList<>();
        int prevHeight = -1;
        for (Map.Entry<Integer, Point> ent : pointMap.entrySet()) {
            int idx = ent.getKey();
            Point point = ent.getValue();
            if (point.height == prevHeight)
                continue;

            prevHeight = point.height;
            res.add(new int[]{idx, point.height});
        }

        return res;
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
