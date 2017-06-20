package leeTs.Hard;
import java.util.LinkedList;


public class _42_Trapping_Rain_Water {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int trap(int[] height) {
        if(null == height || 0 == height.length)
            return 0;
        LinkedList<Integer> stack = new LinkedList<>();
        int i = 0, ground = 0, lastBound = 0, allDrop = 0, currentDrop = 0;
        while(i < height.length) {
            //keep the stack as a non assending array, otherwise collect the rain drop
            if(stack.size() == 0 || height[stack.peek()] >= height[i])
                stack.push(i ++);
            else {
                //the former is the base height of this water layer
                ground = stack.pop();
                /*if stack is empty, then there is no other bound for the
                gurl, no need to compute*/
                if(stack.size() > 0) {
                    currentDrop = (Math.min(height[i], height[stack.peek()]) - height[ground]) * (i - stack.peek() - 1);
                    allDrop += currentDrop;
                }
            }
        }
        return allDrop;
    }
}
