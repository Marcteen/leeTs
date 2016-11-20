package leeTs.Easy;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class _113_Path_Sum_II {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(1);
		List<List<Integer>> result = pathSum(root, 22);
	}

	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> curPath = new LinkedList<>();
		if(null == root)
			return result;
		else {
			int rest = sum - root.val;
			curPath.add(root.val);
			if(null == root.left && null == root.right) { // this is an left, check out whether a solution is in
				if(0 == rest) 
					result.add(new LinkedList(curPath)); // always pass the reference stack value, so need a copy
			}
			else {
				if(null != root.left)
					checkSumPath(root.left, rest, result, curPath);
				if(null != root.right)
					checkSumPath(root.right, rest, result, curPath);
			}
			return result;
		}
	}
	
	public static void checkSumPath(TreeNode root, int sumRest, List<List<Integer>> result, List<Integer> curPath) {
		int rest = sumRest - root.val;
		curPath.add(root.val);
		if(null == root.left && null == root.right) { // this is an left, check out whether a solution is in
			if(0 == rest) 
				result.add(new LinkedList(curPath)); // always pass the reference stack value, so need a copy
		}
		else {
			if(null != root.left)
				checkSumPath(root.left, rest, result, curPath);
			if(null != root.right)
				checkSumPath(root.right, rest, result, curPath);
		}
		curPath.remove(curPath.size() - 1);
	}
}
