package leeTs.Medium;

public class _210_Course_Schedule_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        if(0 == numCourses || null == prerequisites)
            return result;
        LinkedList<Integer> freeCourse = new LinkedList<Integer>();
        int[] inDegree = new int[numCourses];
        boolean[][] adjacent = new boolean[numCourses][numCourses];
        int curCourse = 0, resultIndex = 0;
        for(int[] pair : prerequisites) {
            inDegree[pair[0]] ++;
            adjacent[pair[1]][pair[0]] = true;
        }
        for(int i = 0; i < numCourses; i ++) {
            if(0 == inDegree[i]) {
                freeCourse.offer(i);
            }
        }
        while(!freeCourse.isEmpty()) {
            curCourse = freeCourse.poll();
            numCourses --;
            result[resultIndex ++] = curCourse;
            for(int i = 0; i < result.length; i ++) {
                if(adjacent[curCourse][i]) {
                /*be careful about the bracket, the degree check only
                 * occurs for adjacent courses*/
                    inDegree[i] --;
                    if(0 == inDegree[i])
                        freeCourse.add(i);
                }
            }
        }
        if(0 == numCourses)
            return result;
        else
            return new int[0];
    }

}
