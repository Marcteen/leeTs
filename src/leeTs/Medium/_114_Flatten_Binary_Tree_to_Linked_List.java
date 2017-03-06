package leeTs.Medium;

import java.util.LinkedList;

public class _114_Flatten_Binary_Tree_to_Linked_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.right = new TreeNode(3);
		flattenRecursive(root);
	}

	public static void flattenRecursive(TreeNode root) {
        if(null == root)
            return;
        flat(root, null);
    }
    /*the next need to be apped to the tail of subtree who's root
    is "root"*/
    public static void flat(TreeNode root, TreeNode next) {
        if(null != root.right)
        /*flatten the right, the near ancestor's right must be
        appended to it*/
            flat(root.right, next);
        if(null != root.left) {
            TreeNode right = root.right;
            root.right = root.left;
            /*it it has no right, child, the nearest ancestor's right is to be
            appended*/
            flat(root.left, right == null ? next : right);
            root.left = null;
        }
        else/*it has no child, just do the append, our passing direction make
        it the left tree's right bound element*/
            if(null == root.right)
                root.right = next;
    }
	
	public static void flattenIterative(TreeNode root) {
        if(null == root)
            return;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        /*Think about it in recursion, for the node root, if it has left child,
        its right pointer must point to it left child, or if it has right child, it
        must be appended, otherwise, its right must point to the nearest ancestor's right child.*/
        while(!stack.isEmpty()) {
            root = stack.pop();
        /*according to the description above, we have the following push order*/
            if(null != root.right)
                stack.push(root.right);
            if(null != root.left)
                stack.push(root.left);
            root.left = null;
            if(!stack.isEmpty())
                root.right = stack.peek();
        }
    }
}
