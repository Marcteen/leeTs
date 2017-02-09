package leeTs.Medium;

public class _11_Container_With_Most_Water {

	public int maxAreaNaive(int[] height) {// way too slow when height[] is large
        int[] max = new int[1];
        int[] selectedIndex = new int[2];
        combination(height, 0, 2, selectedIndex, max);
        return max[0];
    }
    
    public void combination(int[] height, int start, int count, int[] selectedIndex, int[] max) {
        if(0 == count) {
            int volume = Math.abs(selectedIndex[0] - selectedIndex[1]) * Math.min(height[selectedIndex[0]], height[selectedIndex[1]]);
            if(volume > max[0])
                max[0] = volume;
        }
        else {
            for(int i = start; i < height.length; i ++) {
                selectedIndex[2 - count] = i;
                combination(height, i + 1, count - 1, selectedIndex, max);
            }
        }
    }
    /*Consider it as a dynamic programming problem and you get the clear proof.
	assume h[from] < h[to], then the largest volume we can get, using 'from' as one
 	side, is (to - from + 1) * h[from]. then we can say:
	opt[from][to] = max(opt[from + 1][to], (to - from + 1) * h[from]).*/
    public int maxArea(int[] height) {
    	int head = 0, tail = height.length - 1;
    	int maxArea = 0;
    	int area = 0;
    	while(tail > head) {
    		area = (tail - head) * Math.min(height[head], height[tail]);
    		if(area > maxArea)
    			maxArea = area;
    		/*As Buckets effect reveals, the capacity of a bucket depends
    		 * on the shortest board, so , we HAVE to move the shortest side.*/
    		if(height[head] < height[tail])
    			head ++;
    		else
    			tail --;
    	}
    	return maxArea;
    }
}
