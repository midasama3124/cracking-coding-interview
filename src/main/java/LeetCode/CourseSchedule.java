package LeetCode;

import java.util.Stack;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Array saves number of prerequisites for each course
        int[] inDegree = new int[numCourses];
        for (int[] pair : prerequisites) {
            inDegree[pair[0]]++;
        }
        // Build a stack and count the times we are allowed to pop
        // an element to build a topological sort
        Stack<Integer> stack = new Stack<>();
        // Push into stack those element with no prerequisites
        for (int c = 0; c < inDegree.length; c++) {
            if (inDegree[c] == 0)
                stack.push(c);
        }
        // Pop elements as long as there are no more prerequisites to comply with
        int count = 0;
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            count++;
            // Update array with number of prerequisites
            for (int[] pair : prerequisites) {
                if (pair[1] == curr) {
                    if (--inDegree[pair[0]] == 0) {
                        stack.push(pair[0]);
                    }
                }
            }
        }
        // If counter matches number of courses, it means that the graph
        // is acyclic, i.e. the syllabus is consistent
        return count == numCourses;
    }
}
