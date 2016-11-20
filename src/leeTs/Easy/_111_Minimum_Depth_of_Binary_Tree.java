package leeTs.Easy;

public class _111_Minimum_Depth_of_Binary_Tree { // should notice it requirs the leaf node!

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		TreeNode input = new TreeNode(0);
		int result = minDepth(input);
	}
	
	public static int minDepth(TreeNode root) {
		if(null == root) {
			return 0;
		}
		else
		{// must reach a leaf node !
			int leftMinDepth = 0;
			int rightMinDepth = 0;
			if(null == root.left)
				if(null == root.right)
					return 0;
				else 
					return 1 + minDepth(root.right);
			else
				if(null == root.right)
					return 1 + minDepth(root.left);
				else {
					leftMinDepth = minDepth(root.left);
					rightMinDepth = minDepth(root.right);
					return 1 + (leftMinDepth > rightMinDepth ? rightMinDepth : leftMinDepth);
				}
		}
	}

}
