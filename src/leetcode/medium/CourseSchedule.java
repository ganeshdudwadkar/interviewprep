package leetcode.medium;

// https://leetcode.com/problems/course-schedule/

/*

207. Course Schedule

There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:

Input: 2, [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
Note:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.

 */

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {

    /* Topological Sort
    Explanation for the DFS solution : the solution basically starts at every node in the graph which corresponds to a
    course and traverses all the courses (nodes) that can be taken subsequently. If we ever encounter the a course we
    have already visited , then we know there is a cycle. Note that in the solution , as the recursion unwinds all the
    visited status is set to false. Hence every time DFS is started in the canFinish function, the visted boolean array
    is guaranteed to be all false. That is why this method works.
     */

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> allPrereqs = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) { // initialize
            allPrereqs.add(i, new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            allPrereqs.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }


        for(int i=0;i<numCourses;i++){
            System.out.println("Course " + i + " allPrereqs : " + allPrereqs.get(i));
        }
        boolean[] visiting = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            // System.out.println("Starting with course " + i);
            if (!canAttend(allPrereqs, visiting, i))
                return false;
        }
        return true;
    }

    private boolean canAttend(List<List<Integer>> allPrereqs, boolean[] visiting, int course) {
        if (visiting[course])
            return false; // cycle
        visiting[course] = true;

        List<Integer> coursePrereqs = allPrereqs.get(course);// get current course allPrereqs list
        // System.out.println("Exploring Course " + course + " allPrereqs " + coursePrereqs);
        for (int coursePrereq : coursePrereqs) {
            if (!canAttend(allPrereqs, visiting, coursePrereq))
                return false;
        }
        visiting[course] = false;
        return true;
    }

    public static void main(String[] args) {
        CourseSchedule obj = new CourseSchedule();
        CourseScheduleOptimized objOpt = new CourseScheduleOptimized();
        int[][] prerequisites = new int[][]{
                {0, 1}, {0, 2}, {1, 2}
        };
        System.out.println(obj.canFinish(3, prerequisites));
        System.out.println(objOpt.canFinish(3, prerequisites));
    }
    /*

    Input :
    3
    [[0,1],[0,2],[1,2]]

    Output :

    Course 0 prereqs : [1, 2]
    Course 1 prereqs : [2]
    Course 2 prereqs : []
    Starting with course 0
    Exploring Course 0 prereqs [1, 2]
    Exploring Course 1 prereqs [2]
    Exploring Course 2 prereqs []
    Exploring Course 2 prereqs []
    Starting with course 1
    Exploring Course 1 prereqs [2]
    Exploring Course 2 prereqs []
    Starting with course 2
    Exploring Course 2 prereqs []

     */

}

class CourseScheduleOptimized {

    // Improved Version : with track of visited (12ms)

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // make dependency list for each course
        List<List<Integer>> allPrereqs = new ArrayList<>();
        for (int course = 0; course < numCourses; course++) {
            allPrereqs.add(course, new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            allPrereqs.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        for (int course = 0; course < numCourses; course++) {
            System.out.println("Course " + course + " allPrereqs : " + allPrereqs.get(course));
        }
        boolean[] visiting = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses]; // this will help not visit the same visited course

        for (int course = 0; course < numCourses; course++) {
            //System.out.println("Starting with course " + course);
            if (!visited[course] && !canAttend(allPrereqs, visiting, visited, course))
                return false;
        }
        return true;
    }

    private boolean canAttend(List<List<Integer>> allPrereqs, boolean[] visiting, boolean[] visited, int course) {
        if (visiting[course])
            return false;
        visiting[course] = true;

        List<Integer> coursePrereqs = allPrereqs.get(course);// get current course allPrereqs list
        //System.out.println("Exploring Course " + course + " allPrereqs " + coursePrereqs);
        for (int coursePrereq : coursePrereqs) {
            if (!canAttend(allPrereqs, visiting, visited, coursePrereq))
                return false;
        }
        visiting[course] = false;
        visited[course] = true;
        return true;
    }

    /*
    Input :
    3
    [[0,1],[0,2],[1,2]]

    Output :

    Course 0 prereqs : [1, 2]
    Course 1 prereqs : [2]
    Course 2 prereqs : []
    Starting with course 0
    Exploring Course 0 prereqs [1, 2]
    Exploring Course 1 prereqs [2]
    Exploring Course 2 prereqs []
    Exploring Course 2 prereqs []
    Starting with course 1
    Starting with course 2
     */

}