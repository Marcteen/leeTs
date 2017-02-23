package leeTs.Medium;

import java.util.LinkedList;
import java.util.HashMap;

public class _133_Clone_Graph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// use BFS
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(null == node)
            return null;
        LinkedList<UndirectedGraphNode> src = new LinkedList<>();
        LinkedList<UndirectedGraphNode> dst = new LinkedList<>();
        // we can use label as key too for they are unique.
        HashMap<UndirectedGraphNode, UndirectedGraphNode> visited = new HashMap<>();
        UndirectedGraphNode result = new UndirectedGraphNode(node.label);
        UndirectedGraphNode cur = null, newNeighbor = null;
        src.offer(node);
        dst.offer(result);
        visited.put(node, result);
        while(!src.isEmpty()) {
            node = src.poll();
            cur = dst.poll();
            for(UndirectedGraphNode si : node.neighbors) {
                // if it is visited, we can reach it but never go from it again
                if(visited.containsKey(si))
                    newNeighbor = visited.get(si);
                else {
                    newNeighbor = new UndirectedGraphNode(si.label);
                    visited.put(si, newNeighbor);
                    src.offer(si);
                    dst.offer(newNeighbor);
                }
                //It is created in its constructor
                cur.neighbors.add(newNeighbor);
            }

        }
        return result;
    }
}
