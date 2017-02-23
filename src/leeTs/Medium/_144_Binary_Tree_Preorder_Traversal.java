package leeTs.Medium;

import java.util.List;
import java.util.LinkedList;

public class _144_Binary_Tree_Preorder_Traversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//Why is this a medium?
	public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if(null == root)
            return result;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            root = stack.pop();
            result.add(root.val);
            if(null != root.right)
                stack.push(root.right);
            if(null != root.left)
                stack.push(root.left);
        }
        return result;
    }

}
