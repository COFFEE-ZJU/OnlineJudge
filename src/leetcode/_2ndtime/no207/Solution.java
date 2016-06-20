package leetcode._2ndtime.no207;

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
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 1) return true;

        Course[] cs = new Course[numCourses];
        for(int i = 0; i < numCourses; i++)
            cs[i] = new Course();

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
        while (!canTake.isEmpty()) {
            cnt++;
            Course cur = canTake.poll();

            for (Course c : cur.canTakeAfter) {
                c.preReq--;
                if (c.preReq == 0) canTake.add(c);
            }
        }

        return cnt == numCourses;
    }
}