package leeTs.Medium;

import java.util.LinkedList;

public class _108_Convert_Sorted_Array_To_Binary_Search_Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*for construct a tree in iterative, before go to the child, we
    can construct the child to the current node, then push instantiated
    child and its range to the stacks if there is still available range.*/
    public TreeNode sortedArrayToBSTIteratively(int[] nums) {
        if(0 == nums.length)
            return null;
        LinkedList<TreeNode> nodeStack = new LinkedList<>();
        LinkedList<Integer> startStack = new LinkedList<>();
        LinkedList<Integer> endStack = new LinkedList<>();
        int start = 0, end = 0, mid = 0;
        TreeNode root = new TreeNode(0);
        TreeNode cur = null;
        nodeStack.push(root);
        startStack.push(0);
        endStack.push(nums.length - 1);
        while(!nodeStack.isEmpty()) {
            cur = nodeStack.pop();
            start = startStack.pop();
            end = endStack.pop();
            mid = start + (end - start) / 2;
            cur.val = nums[mid];
            /*We connect child to parent before we go to child,
            thus make the link in tree more easy to mantain*/
            if(start < mid) {
                cur.left = new TreeNode(0);
                nodeStack.push(cur.left);
                startStack.push(start);
                endStack.push(mid - 1);
            }
            if(mid < end) {
                cur.right = new TreeNode(0);
                nodeStack.push(cur.right);
                startStack.push(mid + 1);
                endStack.push(end);
            }
        }
        return root;
    }
	public TreeNode sortedArrayToBST(int[] nums) {
        if(0 == nums.length)
            return null;
        return construct(nums, 0, nums.length - 1);
    }
    
    public TreeNode construct(int[] nums, int start, int end) {
        if(start > end)
            return null;
        // It is a array, so we can calculate the middle, but we shouldn't exclude the end!!!!
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = construct(nums, start, mid - 1);
        root.right = construct(nums, mid + 1, end);
        return root;
    }
}
