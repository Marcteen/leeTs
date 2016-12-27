package leeTs.Easy;
import java.util.LinkedList;
public class _235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.left.right = new TreeNode(2);
		root.right = new TreeNode(4);
		lowestCommonAncestor(root, root.left.left, root.right);
	}
	
	public static TreeNode lowestCommonAncestorBst(TreeNode root, TreeNode p, TreeNode q) {
		while(null != root) {
			if((root.val - (long)p.val) * (root.val - (long)q.val) <= 0)
				return root;
			else
				root = p.val > root.val ? root.right : root.left;
		}
		return null;
	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(null == root)
			return null;
		else {
			LinkedList<TreeNode> curPath = new LinkedList<>();
			LinkedList<TreeNode> pPath = new LinkedList<>();
			LinkedList<TreeNode> qPath = new LinkedList<>();
			TreeNode LCA = null;
			traceAllTheWay(root, curPath, pPath, qPath, p, q);
			while(pPath.peek() == qPath.peek()) {
				LCA = pPath.poll();
				qPath.poll();
				if(pPath.isEmpty() || qPath.isEmpty())
				    break;
			}
			return LCA;
		}
	}
	
	public static void traceAllTheWay(TreeNode root, LinkedList<TreeNode> curPath, LinkedList<TreeNode> pPath, LinkedList<TreeNode> qPath, TreeNode p, TreeNode q){
		curPath.add(root);
		if(root == p)
			pPath.addAll(curPath); // The copy instance of curPath doesn't work here.
		else
			if(root == q)
				qPath.addAll(curPath);
		if(!pPath.isEmpty() && !qPath.isEmpty())
			return;
		else {
			if(null != root.left)
				traceAllTheWay(root.left, curPath, pPath, qPath, p, q);
			if(pPath.isEmpty() || qPath.isEmpty())
				if(null != root.right)
					traceAllTheWay(root.right, curPath, pPath, qPath, p, q);
			curPath.removeLast();
		}
	}
}
