package leeTs.Easy;
import java.util.List;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;

public class _107_Binary_Tree_Level_Order_Traversal_II {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
		
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new LinkedList<>(); // To use the generic, polymorphic and match the function result type
		ArrayDeque<TreeNode> view = new ArrayDeque<>();
		if(null == root)
			return result;
		else
		    view.offer(root);
		TreeNode curNode = null;
		ArrayList<Integer> curResult = null;
		int curLayerSize = 0;
		while(!view.isEmpty()) {
			curResult = new ArrayList<Integer>();
			// this is enough for control the layer information, wirte down the size before we pop it!
			curLayerSize = view.size();
			for(int i = 0; i < curLayerSize; i ++) {
				curNode = view.poll();
				curResult.add(curNode.val);
				if(null != curNode.left) // though it affect the view's size, we won't update the variable size before the loop terminates
					view.offer(curNode.left);
				if(null != curNode.right)
					view.offer(curNode.right);
			}
			result.add(0, curResult);
		}
		return result;
	}
}
