package leeTs.Medium;

public class _106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] postorder = new int[]{-1};
		int[] inorder = new int[]{-1};
		TreeNode result = buildTree(inorder, postorder);
	}
	
	//Iteratively(Not understand yet): https://discuss.leetcode.com/topic/4746/my-comprehension-of-o-n-solution-from-hongzhi
	public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if(0 == postorder.length || 0 == inorder.length)
            return null;
        return build(inorder, postorder, 0, inorder.length, 0, postorder.length);
    }
    
    public static TreeNode build(int[] inorder, int[] postorder, int inLow, int inHigh, int postLow, int postHigh) {//xxHigh is exclusive
        if(postLow < postHigh && inLow < inHigh) {
            int mid = 0;// latter we use mid as relative offset, so it must always start with zero!!
            //we can cache the inorder in HashMap for optimization!!!
          //Don't forget the upper bound is exclusive!!!!!
            for(; inLow + mid < inHigh && postorder[postHigh - 1] != inorder[inLow + mid]; mid ++);
            if(inLow + mid == inHigh)
                return null;
            TreeNode root = new TreeNode(postorder[postHigh - 1]);
            // don't forget mid is relative offset!!!!!!!!
            root.left = build(inorder, postorder, inLow, inLow + mid, postLow, postLow + mid);
            root.right = build(inorder, postorder, inLow + mid + 1, inHigh, postLow + mid, postHigh - 1);
            return root;
        }
        else 
            return null;
    }
}
