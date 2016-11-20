package leeTs.Easy;
//remember: Math.max(a, b), Math.abs(a)
public class _110_Balanced_Binary_Tree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isBalanced(TreeNode root) {
		if(null == root)
			return true;
		else
		{
			int left = getdepth(root.left);
			int right = getdepth(root.right);
		
			if(-1 == left || -1 == right)
				return false;
			else
				if(Math.abs(left - right) <= 1)
					return true;
				else
					return false;
		}
	}
	public int getdepth(TreeNode root) {
		if(null == root)
			return 0;
		else
		{
			int left = getdepth(root.left);
			int right = getdepth(root.right);
			if(-1 == left || -1 == right)
				return -1;
			else
				if(Math.abs(left - right) <= 1)
					return 1 + Math.max(left, right);
				else
					return -1;
		}
	}
}
