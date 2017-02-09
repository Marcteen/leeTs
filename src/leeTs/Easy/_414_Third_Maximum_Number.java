package leeTs.Easy;
import java.util.PriorityQueue;
import java.util.HashSet;

public class _414_Third_Maximum_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int thirdMax(int[] nums) {
		PriorityQueue<Integer> trace = new PriorityQueue<>();
		HashSet<Integer> deDup = new HashSet<>();
		for(int n : nums) {
			if(deDup.add(n)) {// not an duplicated number
				trace.add(n);
				if(trace.size() > 3)
					trace.poll();
			}
		}
		if(trace.size() < 3)
			while(trace.size() > 1)
				trace.poll();
		return trace.poll();
	}
}
