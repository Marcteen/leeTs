package leeTs.Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.ArrayDeque;

public class _102_Binary_Tree_Level_Order_Traversal {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public class QueueNode {
		int layer;
		TreeNode node;
		QueueNode(int curLayer, TreeNode curNode) {
			layer = curLayer;
			node = curNode;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>(); // To use the generic, polymorphic and match the function result type
		ArrayDeque<QueueNode> view = new ArrayDeque<>();
		if(null == root)
			return result;
		else
		    view.offer(new QueueNode(0, root));
		int curLayer = 0;
		QueueNode curNode = new QueueNode(0, null);
		ArrayList<Integer> curResult = new ArrayList<>();
		while(!view.isEmpty()) {
			curNode = view.poll();
			if(curNode.layer != curLayer) {
				curLayer = curNode.layer;
				result.add(curResult);
				curResult = new ArrayList<Integer>();
			}
			curResult.add(curNode.node.val);
			if(null != curNode.node.left)
				view.offer(new QueueNode(curLayer + 1, curNode.node.left));
			if(null != curNode.node.right)
				view.offer(new QueueNode(curLayer + 1, curNode.node.right));
		}
		result.add(curResult);
		return result;
	}
}
