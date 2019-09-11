package leetcode.medium;

// https://leetcode.com/problems/course-schedule-ii/

/*

210. Course Schedule II

There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

Example 1:

Input: 2, [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
             course 0. So the correct course order is [0,1] .
Example 2:

Input: 4, [[1,0],[2,0],[3,1],[3,2]]
Output: [0,1,2,3] or [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
             courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
             So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CourseScheduleII {

    private List<List<Integer>> allPrereqs = new ArrayList<>();
    private Stack<Integer> ordered = new Stack<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        for (int course = 0; course < numCourses; course++) {
            allPrereqs.add(course, new ArrayList<Integer>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            allPrereqs.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        /*
        for(int course=0;course<numCourses;course++){
            System.out.println("Course " + course + " allPrereqs : " + allPrereqs.get(course));
        } */

        boolean[] visited = new boolean[numCourses];
        boolean[] visiting = new boolean[numCourses];

        boolean isCycle = false;
        for (int course = 0; course < numCourses; course++) {
            if (!isCycle && !visited[course]) {
                isCycle = exploreOrder(course, visited, visiting);
            }
        }
        if (isCycle) {
            return new int[0];//failed
        }
        int[] res = new int[numCourses];
        //System.out.println(ordered);
        for (int course = numCourses - 1; course >= 0; course--) {
            res[course] = ordered.pop();
        }
        return res;
    }

    private boolean exploreOrder(int course, boolean[] visited, boolean[] visiting) {
        if (visiting[course]) {
            //System.out.println("Cycle found");
            return true;
        }
        visiting[course] = true;
        //System.out.println("Exploring course " + course);
        List<Integer> coursePrereqs = allPrereqs.get(course);
        boolean isCycle = false;
        for (int coursePrereq : coursePrereqs) {
            if (!isCycle) isCycle = exploreOrder(coursePrereq, visited, visiting);
        }
        if (!visited[course]) {
            ordered.push(course);
        }
        visiting[course] = false;
        visited[course] = true;
        return isCycle;
    }

    public static void main(String[] args) {
        CourseScheduleII obj = new CourseScheduleII();
        CourseScheduleIIClean objOpt = new CourseScheduleIIClean();
        int[][] prerequisites = new int[][]{
                {1, 0}, {2, 0}, {3, 1}, {3, 2}
        };
        System.out.println(Arrays.toString(obj.findOrder(4, prerequisites)));
        System.out.println(Arrays.toString(objOpt.findOrder(4, prerequisites)));

    }
}

class CourseScheduleIIClean {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) adj.add(i, new ArrayList<>());
        for (int i = 0; i < prerequisites.length; i++) adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        boolean[] visited = new boolean[numCourses];
        boolean[] isLoop = new boolean[numCourses];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            if (!topologicalSort(adj, i, stack, visited, isLoop)) return new int[0];
        }
        int i = 0;
        int[] result = new int[numCourses];
        while (!stack.isEmpty()) {
            result[i++] = stack.pop();
        }
        return result;
    }

    private boolean topologicalSort(List<List<Integer>> adj, int v, Stack<Integer> stack, boolean[] visited, boolean[] isLoop) {
        if (visited[v]) return true;
        if (isLoop[v]) return false;
        isLoop[v] = true;
        for (Integer u : adj.get(v)) {
            if (!topologicalSort(adj, u, stack, visited, isLoop)) return false;
        }
        visited[v] = true;
        stack.push(v);
        return true;
    }
}