package leeTs.Medium;

public class _105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] preorder = new int[]{2, 1, 3, 4};
		int[] inorder = new int[]{1, 2, 3, 4};
		TreeNode result = buildTree(preorder, inorder);
	}
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(0 == preorder.length || 0 == inorder.length)
            return null;
        return build(preorder, inorder, 0, preorder.length, 0, inorder.length);
    }
    
    public static TreeNode build(int[] preorder, int[] inorder, int preLow, int preHigh, int inLow, int inHigh) {//xxHigh is exclusive
        if(preLow < preHigh && inLow < inHigh) {
            int mid = 0;// latter we use mid as relative offset, so it must always start with zero!!
            //we can cache the inorder in HashMap for optimization!!!
            for(; inLow + mid < inHigh && preorder[preLow] != inorder[inLow + mid]; mid ++);
            if(inLow + mid == inHigh)
                return null;
            TreeNode root = new TreeNode(preorder[preLow]);
            // don't forget mid is relative offset!!!!!!!!
            root.left = build(preorder, inorder, preLow + 1, preLow + mid + 1, inLow, inLow + mid);
            root.right = build(preorder, inorder, preLow + mid + 1, preHigh, inLow + mid + 1, inHigh);
            return root;
        }
        else 
            return null;
    }
}
