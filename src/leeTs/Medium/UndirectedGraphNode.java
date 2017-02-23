package leeTs.Medium;

import java.util.List;
import java.util.ArrayList;

public class UndirectedGraphNode {
	public int label;
	public List<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}
