package leeTs.Easy;

public class _112_Path_Sum {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean hasPathSum(TreeNode root, int sum) {
		if(null == root)
			return false;
		else {
			int rest = sum - root.val;
			if(null == root.left && null == root.right) {// this is an leaf node
				if(0 == rest)
					return true;
				else
					return false;
			}
			else
				return hasPathSum(root.left, rest) || hasPathSum(root.right, rest);
		}
	}
}
