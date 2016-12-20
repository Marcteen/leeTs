package leeTs.Easy;
import java.util.ArrayDeque;

public class _232_Implement_Queue_using_Stack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		push(1);
		int i = pop();
		boolean r = empty();
	}
	
	static ArrayDeque<Integer> in = new ArrayDeque<>();
	static ArrayDeque<Integer> out = new ArrayDeque<>();
 	
	public static void push(int x) {
		in.push(x);
	}

	public static int pop() {
		if(out.isEmpty()) {
			int size = in.size();
			for(int i = 0; i < size; i ++)
				out.push(in.pop());
		}
		return out.pop();
	}
	
	public static int peek() { //checkout the element that will be poll next
		if(out.isEmpty()) {
			int size = in.size();
			for(int i = 0; i < size; i ++)
				out.push(in.pop());
		}
		return out.peek();
	}
	
	public static boolean empty() {
		if(in.isEmpty() && out.isEmpty())
			return true;
		else
			return false;
	}
}
