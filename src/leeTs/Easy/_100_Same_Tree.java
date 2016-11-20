package leeTs.Easy;
import java.util.ArrayDeque;

public class _100_Same_Tree { // Why recursion is faster than iteration?
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public static boolean isSameTreeRecursively(TreeNode p, TreeNode q) {
		if(null == p || null == q) {
			if(p == q)
				return true;
			else
				return false;
		}
		else {
			if(p.val == q.val) {
				if(isSameTreeRecursively(p.left, q.left) && isSameTreeRecursively(p.right, q.right))
					return true;
				else
					return false;
			}
			else
				return false;
		}
	}
	public static class RootPair {
		TreeNode foo;
		TreeNode bar;
		RootPair(TreeNode l1, TreeNode l2) {
			foo = l1;
			bar = l2;
		}
		RootPair() {
			foo = null;
			bar = null;
		}
	}
	public static boolean isSameTreeIteratively(TreeNode p, TreeNode q) {
		ArrayDeque<RootPair> stack = new ArrayDeque<>();
		stack.push(new RootPair(p, q));
		RootPair curPair = new RootPair();
		while(!stack.isEmpty()) {
			curPair = stack.pop();
			if(null == curPair.foo || null == curPair.bar) {
				if(curPair.foo != curPair.bar)

					return false;
			}
			else {
				if(curPair.foo.val == curPair.bar.val) {
					stack.push(new RootPair(curPair.foo.left, curPair.bar.left));
					stack.push(new RootPair(curPair.foo.right, curPair.bar.right));
				}
				else
					return false;
			}
		}
		return true;
	}
}
