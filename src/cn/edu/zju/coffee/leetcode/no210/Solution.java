package cn.edu.zju.coffee.leetcode.no210;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {
	
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses <= 0) return new int[0];
        
        List<Integer>[] postCoursesList = new List[numCourses];
        List<Integer> availCourses = new LinkedList<Integer>();
        int[] prereqs = new int[numCourses];
        
        for(int i = 0; i < prerequisites.length; i++){
        	if(postCoursesList[prerequisites[i][1]] == null)
        		postCoursesList[prerequisites[i][1]] = new LinkedList<Integer>();
        	
        	postCoursesList[prerequisites[i][1]].add(new Integer(prerequisites[i][0]));
        	prereqs[prerequisites[i][0]] ++;
        }
        
        for(int i = 0; i < numCourses; i++)
        	if(prereqs[i] == 0) availCourses.add(new Integer(i));
        
        int idx = 0;
        while(idx < numCourses){
        	int curSize = availCourses.size();
        	if(idx == curSize) return new int[0];
        	
        	for(; idx < curSize; idx++){
        		int cno = availCourses.get(idx);
        		List<Integer> postCourses = postCoursesList[cno];
        		if(postCourses == null) continue;
        		for(Integer post: postCourses){
        			prereqs[post] --;
        			if(prereqs[post] == 0)
        				availCourses.add(post);
        		}
        	}
        }
        
        Integer[] resI = availCourses.toArray(new Integer[0]);
        int[] res = new int[numCourses];
        for(int i = 0; i < numCourses; i++)
        	res[i] = resI[i];
        return res;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	int[] res = solution.findOrder(4, new int[][]{new int[]{1,0}, new int[]{2,0}, new int[]{3,1}, new int[]{3,2}});
    	System.out.println(Arrays.toString(res));
	}
}