package leeTs.Medium;

import java.util.List;
import java.util.ArrayList;

public class _95_Unique_Binary_Search_Tree_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<TreeNode> result = generateTrees(3);
	}

	public static List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new ArrayList<>();
        if(0 == n)
            return result;
        TreeNode treetop = new TreeNode(0);
        TreeNode candidate = null, pre = null, newNode = null;
        int size = 0;
        /*if use a exits node here, we must copy it otherwise there is a loop in the tree, which can cause
        infinite copy in copyTree()!!!!!!!!!*/
        result.add(new TreeNode(1));
        for(int i = 2; i <= n; i++) {
            size = result.size();
            for(int j = 0; j < size; j ++) {
                newNode = new TreeNode(i);// eahc previous tree has a new node embedded
                candidate = result.get(j);
                treetop.right = candidate;
                /*The new larger node while take root and its right children to be its left child correspondingly
                , note the last null should also be contain*/
                for(pre = treetop; null != pre; pre = pre.right) {
                    newNode.left = pre.right;
                    pre.right = newNode;
                    //don't mistaken right and left!!
                    if(null != newNode.left) {/*since we don't need previous result. so just keep last one modified
                    , in this case the origin root won't drift, so it is ok*/
                        result.add(copyTree(treetop.right));
                        pre.right = newNode.left;
                    }
                    else
                    	pre = pre.right;// ensure the termination of loop
                }
            }
        }
        return result;
        
    }
    //Don't return wrong reference in copy method!!
    public static TreeNode copyTree(TreeNode root) {
        if(null == root)
            return null;
        TreeNode newRoot = new TreeNode(root.val);
        newRoot.left = copyTree(root.left);
        newRoot.right = copyTree(root.right);
        return newRoot;
    }
}
