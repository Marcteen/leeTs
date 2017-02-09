package leeTs.Easy;

import java.util.ArrayDeque;
import java.util.HashMap;

public class _437_Path_Sum_III {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(-3);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(2);
		root.right.right = new TreeNode(11);
		root.left.left.left = new TreeNode(3);
		root.left.left.right = new TreeNode(-2);
		root.left.right.right = new TreeNode(1);
		int result = pathSum(root, 8);
		
	}

	public static int pathSum(TreeNode root, int sum) {
		if(null == root)
			return 0;
		ArrayDeque<TreeNode> stack = new ArrayDeque<>();
		int result = 0;
		stack.push(root);
		TreeNode cur = null;
		while(!stack.isEmpty()) {
			cur = stack.pop();
			if(null != cur.left)
				stack.push(cur.left);
			if(null != cur.right)
				stack.push(cur.right);
			result += sum(cur, sum);
		}
		return result;
	}
	
	public static int sum(TreeNode root, int sum) {
		if(null == root) {
			return 0;
		}
		else {
			int numPath = 0;
			if(sum - root.val == 0)
				numPath = 1;
			numPath += sum(root.left, sum - root.val)
			// sum() here mistaken as pathSum first, be careful of ctrl + c & ctrl + v !!
					+ sum(root.right, sum - root.val);
			return numPath;
		}
	}
	
	public static int pathSumPreFixSum(TreeNode root, int sum) {
		if(null == root) {
			return 0;
		}
		else {
			HashMap<Integer, Integer> trace = new HashMap<>();
			trace.put(0, 1);
			return search(root, 0, sum, trace);
		}
	}
	
	public static int search(TreeNode root, int curSum, int target, HashMap<Integer, Integer> trace) {
		if(null == root) {
			return 0;
		}
		else{
			curSum += root.val;
			int compatible = 0;
			/*Could be replaced by 
			 * compatible = trace.getOrDefault(curSum - target, 0) // in jdk1.8
			 * */
			if(trace.containsKey(curSum - target))// Found some wanted paths, because the map is formed up incrementally, it will only search the prefix sum before this node!
				compatible = trace.get(curSum - target);
			if(trace.containsKey(curSum))
				trace.put(curSum, trace.get(curSum) + 1);
			else
				trace.put(curSum, 1);
			compatible += search(root.left, curSum, target, trace);
			compatible += search(root.right, curSum, target, trace);
			trace.put(curSum, trace.get(curSum) - 1);
			return compatible;
		}
	}
}
