package leeTs.Easy;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.ArrayDeque;

public class _332_Reconstruct_Itinerary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static List<String> findItineraryRecursively(String tickets[][]) {
		Map<String, PriorityQueue<String>> flights = new HashMap<>();
		List<String> path = new LinkedList<>();
		for(int i = 0; i < tickets.length; i ++) {
			// only available in jdk1.8: flights.putIfAbsent(tickets[i][0], new PriorityQueue<String>());
			if(!flights.containsKey(tickets[i][0]))
				flights.put(tickets[i][0], new PriorityQueue<String>());
			flights.get(tickets[i][0]).add(tickets[i][1]);
		}
		dfs("JFK", flights, path);
		return path;
	}
	
	public static void dfs(String depature, Map<String, PriorityQueue<String>> flights, List<String> path) { // use the method "print the Eulerian path adversely described in http://blog.csdn.net/u013480600/article/details/44805491"
		Queue<String> arrivals = flights.get(depature);
		while(null != arrivals && !arrivals.isEmpty())// in this problem, only the start point and end point's out degree differ from its in degree, so we surely get stucked first at end. Remove it and we will stuck at next end without this anterior end.
			dfs(arrivals.poll(), flights, path);
		((LinkedList<String>)path).addFirst(depature);
	}
	
	// the iteratively solution
	public static List<String> findItineraryIteratively(String tickets[][]) {
		ArrayDeque<String> backTracking = new ArrayDeque<>();
		Map<String, PriorityQueue<String>> flights = new HashMap<>();
		List<String> path = new LinkedList<>();
		for(int i = 0; i < tickets.length; i ++) {
			if(!flights.containsKey(tickets[i][0]))
				flights.put(tickets[i][0], new PriorityQueue<String>());
			flights.get(tickets[i][0]).add(tickets[i][1]);
		}
		String departure = "JFK";
		while(true) {
			PriorityQueue<String> arrivals = flights.get(departure);
			if(null != arrivals && !arrivals.isEmpty()) {
				backTracking.push(departure);
				departure = arrivals.poll();
			}
			else{
				((LinkedList<String>)path).addFirst(departure);
				if(flights.containsKey(departure))// it may have no destination
					flights.remove(departure);
				if(!backTracking.isEmpty()) // retreating to the very beginning, so no former exists, terminate.
					departure = backTracking.pop();
				else
					break;
			}
		}
		return path;
	}

}
