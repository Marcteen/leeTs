package leeTs.Medium;

import java.util.LinkedList;

public class _173_Binary_Search_Tree_Iterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	LinkedList<TreeNode> stack = new LinkedList<>();
    public _173_Binary_Search_Tree_Iterator(TreeNode root) {
        while(null != root) {
            stack.push(root);
            root = stack.peek().left;
            stack.peek().left = null;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return stack.isEmpty() ? false : true;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode top = stack.pop();
        TreeNode root = top.right;
        // There may still exits some more tree node at its left
        while(null != root) {
            stack.push(root);
            root = stack.peek().left;
            stack.peek().left = null;
        }
        return top.val;
    }
}
