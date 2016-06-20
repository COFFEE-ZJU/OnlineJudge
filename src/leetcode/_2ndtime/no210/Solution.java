package leetcode._2ndtime.no210;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Whiteboard coding!
 */
public class Solution {
    private static class Course {
        Set<Course> canTakeAfter = new HashSet<>();
        int preReq = 0;
        int id;
        Course(int id) {this.id = id;}
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses < 1) return new int[0];

        Course[] cs = new Course[numCourses];
        for(int i = 0; i < numCourses; i++)
            cs[i] = new Course(i);

        for(int[] req : prerequisites) {
            Course before = cs[req[1]], after = cs[req[0]];
            if (before.canTakeAfter.add(after))
                after.preReq++;
        }

        Queue<Course> canTake = new LinkedList<>();
        for(Course c : cs) {
            if (c.preReq == 0)
                canTake.add(c);
        }

        int cnt = 0;
        int[] res = new int[numCourses];
        while (!canTake.isEmpty()) {
            Course cur = canTake.poll();
            res[cnt++] = cur.id;

            for (Course c : cur.canTakeAfter) {
                c.preReq--;
                if (c.preReq == 0) canTake.add(c);
            }
        }

        if (cnt != numCourses) return new int[0];
        else return res;
    }
}