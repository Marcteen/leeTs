package leeTs.Easy;

public class _101_Symmetric_Tree {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean isSymmetric(TreeNode root) {
		if(null == root)
			return true;
		if(null == root.left || null == root.right) {
			if(root.left == root.right)
				return true;
			else
				return false;
		}
		else {
			TreeNode p = root.left;
			TreeNode q = root .right;
			if(p.val == q.val) {
				if(isSameTree(p.left, q.right) && isSameTree(p.right, q.left))
					return true;
				else
					return false;
			}
			else
				return false;
		}
	}
	
	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if(null == p || null == q) {
			if(p == q)
				return true;
			else
				return false;
		}
		else {
			if(p.val == q.val) {
				if(isSameTree(p.left, q.right) && isSameTree(p.right, q.left))
					return true;
				else
					return false;
			}
			else
				return false;
		}
	}
}
