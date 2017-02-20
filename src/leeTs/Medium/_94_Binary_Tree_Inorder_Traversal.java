package leeTs.Medium;

import java.util.List;
import java.util.LinkedList;

public class _94_Binary_Tree_Inorder_Traversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(1);
		List<Integer> result = inorderTraversal(root);
	}

	/*Inorder is its left first, itself, then the right, don't mess up right and left*/ 
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        root = null;
        TreeNode temp = null;
        while(!stack.isEmpty() || null != root) {// for there was only one in stack and poped!!!!
            if(null == root)// stuck, get back!
                root = stack.pop();
            else {
                if(null == root.left) {// left stuck, handle itself and move to the left
                    result.add(root.val);
                    root = root.right;
                }
                else {
                    temp = root.left;
                    root.left = null;// still got right, save itself and the right
                    stack.push(root);// don't mistaken it with add()!!!!!!
                    root = temp;
                }
            }
        }
        return result;
    }
}
