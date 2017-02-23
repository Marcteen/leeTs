package leeTs.Medium;

public class _129_Sum_Root_to_Leaf_Numbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int sumNumbers(TreeNode root) {
        return leafPathSum(root, 0);
    }
    
    public int leafPathSum(TreeNode root, int prefix) {
        if(null == root)
            return 0;
        else if(null == root.left && null == root.right)
            return prefix * 10 + root.val;
        else
            return leafPathSum(root.left, prefix * 10 + root.val) + leafPathSum(root.right, prefix * 10 + root.val);
    }
}
