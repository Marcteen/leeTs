package leeTs.Easy;

public class _155_Min_Stack {// way too slow!! 
	/*we just need to keep track whether a pushed value will change the min value
	 * and if so, just push the previous min to the same stack too*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	public class MinStack {

	    private StackElement top;
	    private int minVal;

	    /** initialize your data structure here. */
	    public MinStack() {
	        top = null;
	        minVal = Integer.MAX_VALUE;
	    }
	    
	    public void push(int x) {
	        if (x <= minVal) {
	            // x is minimum. This means 'min' is now second minimum. Push it on stack.
	            // Update min. This way, the next time we pop the minimum value, we know
	            // the second minimum value is right below the one we poped. Then we can just
	            // pop that second minimum value and update 'min' (Because we pushed the second
	            // minimum value to the stack twice).
	            this.plainPush(minVal);
	            minVal = x;
	        }
	        // Push this element to the stack always.
	        this.plainPush(x);
	    }
	    
	    public void pop() {
	        // If the next element to pop is the minimum element, we need to
	        // reassign the minimum value to the value of the element right
	        // below the currently popped element, and pop that new min as well
	        // to avoid duplicate.
	        if (top.val == minVal) {
	            this.plainPop();  // Pop the minimum element
	            minVal = this.top();  // Second minimum element value
	            this.plainPop();  // Pop the second minimum element
	        } else {
	            this.plainPop();  // Just pop it. No need to update minimum value.
	        }
	    }
	    
	    public int top() {
	        return top.val;
	    }
	    
	    public int getMin() {
	        return minVal;
	    }
	    
	    private void plainPush(int x) {
	        if (top == null) {
	            top = new StackElement(x);
	        } else {
	            StackElement newTop = new StackElement(x);
	            newTop.next = top;
	            top = newTop;
	        }
	    }
	    
	    public void plainPop() {
	        if (top == null || top.next == null) {
	            return;
	        }
	        top = top.next;
	    }

	    private class StackElement {
	        public int val;
	        public StackElement next;
	        public StackElement(int val) {
	            this.val = val;
	            this.next = null;
	        }
	    }
	}
}
