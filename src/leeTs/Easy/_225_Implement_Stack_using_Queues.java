package leeTs.Easy;
import java.util.Queue;
import java.util.LinkedList;
public class _225_Implement_Stack_using_Queues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		push(1);
		int i = pop();
		boolean r = empty();
	}
	static Queue<Integer> foo = new LinkedList<>();
	static Queue<Integer> bar = new LinkedList<>();
	
	public static void push(int x) {
		if(foo.isEmpty())
			bar.add(x);
		else
			foo.add(x);
	}
	
	public static int pop() {
		int size = foo.size() + bar.size();
		if(foo.isEmpty()) {
			for(int i = 0; i < size - 1; i ++)
				foo.add(bar.poll());
			return bar.poll();
		}
		else {
			for(int i = 0; i < size - 1; i ++)
				bar.add(foo.poll());
			return foo.poll();
		}
	}
	
	public int top() {
		int size = foo.size() + bar.size();
		int top = 0;
		if(foo.isEmpty()) {
			for(int i = 0; i < size - 1; i ++)
				foo.add(bar.poll());
			top = bar.peek();
			foo.add(bar.poll());
		}
		else {
			for(int i = 0; i < size - 1; i ++)
				bar.add(foo.poll());
			top = foo.peek();
			bar.add(foo.poll());
		}
		return top;
	}
	
	public static boolean empty() {
		if(bar.isEmpty() && foo.isEmpty())
			return true;
		else
			return false;
	}

}
