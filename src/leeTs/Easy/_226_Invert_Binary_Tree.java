package leeTs.Easy;
import java.util.ArrayDeque;

public class _226_Invert_Binary_Tree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public TreeNode invertTreeIterative(TreeNode root) {
		ArrayDeque<TreeNode> trace = new ArrayDeque<>();
		TreeNode cur;
		TreeNode temp;
		if(null != root)
			trace.push(root);
		while(!trace.isEmpty()) {
			cur = trace.pop();
			temp = cur.left;
			cur.left = cur.right;
			cur.right = temp;
			if(null != cur.left)
				trace.push(cur.left);
			if(null != cur.right)
				trace.push(cur.right);
		}
		return root;
	}

	public TreeNode invertTree(TreeNode root) {
		if(null == root)
			return root;
		else
		{
			invert(root);
			return root;
		}
	}
	public void invert(TreeNode root) {
		if(null == root)
			return;
		if(null != root.left || null != root.right) {
			TreeNode temp = root.right;
			root.right = root.left;
			root.left = temp;
		}
		invert(root.left);
		invert(root.right);	
	}
	
}
