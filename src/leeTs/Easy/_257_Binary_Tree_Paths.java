package leeTs.Easy;
import java.util.List;
import java.util.ArrayList;
import java.util.ArrayDeque;

public class _257_Binary_Tree_Paths {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	
	public class StackNode {
		TreeNode node;
		String prefix;
		StackNode(TreeNode x, String s) {
			node = x;
			prefix = s;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<String> binaryTreePathIteratively(TreeNode root) {
		List<String> result = new ArrayList<>();
		if(null == root)
			return result;
		else {
			ArrayDeque<StackNode> stack = new ArrayDeque<>();
			stack.add(new StackNode(root, ""));
			StackNode cur;
			while(!stack.isEmpty()) {
				cur = stack.pop();
				if(null == cur.node.right && null == cur.node.left) 
					result.add(cur.prefix + cur.node.val);
				else {
					if(null != cur.node.left)
						stack.push(new StackNode(cur.node.left, cur.prefix + cur.node.val + "->"));
					if(null != cur.node.right)
						stack.push(new StackNode(cur.node.right, cur.prefix + cur.node.val + "->"));
				}
			}
			return result;
		}
	}
	
	public List<String> binaryTreePaths(TreeNode root) {//SingleTake
		List<String> result = new ArrayList<>();
		if(null == root)
			return result;
		else {
			if(null == root.left && null == root.right) {
				result.add(root.val + "");
				return result;
			}
			if(null != root.left)
				for(String suffix : binaryTreePaths(root.left))
					result.add(root.val + "->" + suffix);
			if(null != root.right)
				for(String suffix : binaryTreePaths(root.right))
					result.add(root.val + "->" + suffix);
			return result;
		}
		
	}

	public List<String> binaryTreePathsRecursively(TreeNode root) {
		List<String> result = new ArrayList<>();
		if(null == root)
			return result;
		else {
			if(null == root.left && null == root.right)
				result.add(root.val + "");
			if(null != root.left)
				traverse(root.left, result, root.val + "->");
			if(null != root.right)
				traverse(root.right, result, root.val + "->");
			return result;
		}
	}
	/* Do not form a StringBuffer to 
	 * hold the corresponding path, for 
	 * it will bring much cost to edit it, and weird case of the arrow emerges*/
	public void traverse(TreeNode root, List<String> result, String curPrefix) { 
		if(null == root.right && null == root.left) 
			result.add(curPrefix + root.val);
		else{
			if(null != root.left)
				traverse(root.left, result, curPrefix + root.val + "->");
			if(null != root.right)
				traverse(root.right, result, curPrefix + root.val + "->");
		}
	}
	
}
