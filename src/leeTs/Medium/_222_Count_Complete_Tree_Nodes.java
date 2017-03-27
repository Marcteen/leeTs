package leeTs.Medium;

public class _222_Count_Complete_Tree_Nodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int countNodes(TreeNode root) {
        if(null == root)
            return 0;
        else {
            int leftDepth = getDepth(root.left);
            int rightDepth = getDepth(root.right);
            // we don't need to subract 1 because its root has one node
            if(leftDepth == rightDepth)
                return (1 << leftDepth) + countNodes(root.right);
            else
                return (1 << rightDepth) + countNodes(root.left);
        }
    }
    
    /*the height of a complementary is decided by the
    most left brach*/
    public int getDepth(TreeNode root) {
        if(null == root)
            return 0;
        else
            return 1 + getDepth(root.left);
    }
}
