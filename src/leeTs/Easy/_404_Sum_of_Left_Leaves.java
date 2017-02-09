package leeTs.Easy;

public class _404_Sum_of_Left_Leaves {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int sumOfLeftLeaves(TreeNode root) {
		if(null == root)
			return 0;
		else {
			int ans = 0;
			if(isLeaves(root.left))
				ans += root.left.val;
			else
				ans += sumOfLeftLeaves(root.left);
			ans += sumOfLeftLeaves(root.right);
			
			return ans;
		}
	}
	
	public boolean isLeaves(TreeNode root) {
		if(null == root)
			return false;
		else
			if(null == root.left && null == root.right)
				return true;
			else 
				return false;
	}
}
