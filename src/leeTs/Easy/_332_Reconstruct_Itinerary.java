package leeTs.Easy;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Map;
import java.util.HashMap;

public class _332_Reconstruct_Itinerary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> findItinerary(String[][] tickets) {
		List<String> result = new ArrayList<>();
		if(0 == tickets.length) {
			return result;
		}
		else {
			Map<String, Queue<String>> departToDest = new HashMap<>();
			for(int i = 0; i < tickets.length; i ++) {
				if(departToDest.containsKey(tickets[i][0])) {
					Queue<String> newEntry = departToDest.get(tickets[i][0]);
					newEntry.add(tickets[i][0]);
					departToDest.put(tickets[i][0], newEntry);
				}
				else {
					Queue<String> newEntry = new PriorityQueue<>();
					newEntry.add(tickets[i][1]);
					departToDest.put(tickets[i][0], newEntry);
				}
			}
			String site = "JFK";
		}
	}
	public static String Itinerary(Map<String, PriorityQueue<String>> departToDest) {
		
	}
}
