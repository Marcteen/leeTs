package leeTs.Medium;

import java.util.LinkedList;
import java.util.HashMap;

public class _207_Course_Schedule {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] input = new int[][]{{1, 0}};
		System.out.println(canFinish(2, input));
	}
	
	
	//follow the concept shown here https://www.cs.usfca.edu/~galles/visualization/TopoSortIndegree.html
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses < 2)
            return true;
        int[] inDegree = new int[numCourses];
        int curCourse = 0;
        boolean[][] adjacent = new boolean[numCourses][numCourses];
        LinkedList<Integer> freeCourses = new LinkedList<>();
        for(int[] pair : prerequisites) {
            inDegree[pair[0]] ++;
            adjacent[pair[1]][pair[0]] = true;
        }
        for(int i = 0; i < numCourses; i ++) {
            if(0 == inDegree[i]) {
                freeCourses.offer(i);  
            }
        }
        //we use frees node to relief others, and add new free nodes
        while(!freeCourses.isEmpty()) {
            curCourse = freeCourses.poll();
            numCourses --;//this means we set a course free
            for(int i = 0; i < inDegree.length; i ++) {
                if(true == adjacent[curCourse][i]) {
                    // fulfill the constrain
                    inDegree[i] --;
                    if(0 == inDegree[i])
                        freeCourses.add(i);//find a new free node
                }
            }
        }
        // if we relief all courses
        return numCourses == 0;
    }
}
