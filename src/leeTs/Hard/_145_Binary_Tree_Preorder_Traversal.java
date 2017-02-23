package leeTs.Hard;
import leeTs.Medium.TreeNode;

import java.util.List;
import java.util.LinkedList;

public class _145_Binary_Tree_Preorder_Traversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//Why is this a hard??
	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if(null == root)
            return result;
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode left = null, right = null;
        stack.push(root);
        while(!stack.isEmpty()) {
            root = stack.pop();
            if(null == root.left && null == root.right)
                result.add(root.val);
            else {
                left = root.left;
                right = root.right;
                root.left = null;
                root.right = null;
                stack.push(root);
                if(null != right)
                    stack.push(right);
                if(null != left)
                    stack.push(left);
            }
        }
        return result;
    }

}
