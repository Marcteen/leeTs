package leeTs.Easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;


public class _104_Maximum_Depth_of_Binary_Tree { // again recursion is faster than iteration OMG..

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class QueueNode { // the static function can only access the static inner class!!
		int layer;
		TreeNode node;
		QueueNode(int curLayer, TreeNode curNode) {
			layer = curLayer;
			node = curNode;
		}
	}
	
	public int maxDepth(TreeNode root) { 
		ArrayDeque<QueueNode> view = new ArrayDeque<>();
		if(null == root)
			return 0;
		else
		    view.offer(new QueueNode(1, root));
		int maxLayer = 1;
		QueueNode curNode = new QueueNode(1, null);
		while(!view.isEmpty()) {
			curNode = view.poll();
			if(curNode.layer > maxLayer) 
				maxLayer = curNode.layer;
			if(null != curNode.node.left)
				view.offer(new QueueNode(curNode.layer + 1, curNode.node.left));
			if(null != curNode.node.right)
				view.offer(new QueueNode(curNode.layer + 1, curNode.node.right));
		}
		return maxLayer;
	}
	
}
