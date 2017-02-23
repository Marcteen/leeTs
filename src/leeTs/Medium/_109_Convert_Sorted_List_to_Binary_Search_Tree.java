package leeTs.Medium;

public class _109_Convert_Sorted_List_to_Binary_Search_Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*https://discuss.leetcode.com/topic/8141/share-my-o-1-space-and-o-n-time-java-code/4
	 * a genius solution in style of inorder traverse*/
	public TreeNode sortedListToBST(ListNode head) {
        if(null == head)
            return null;
        return construct(head, null);
    }
    
    public TreeNode construct(ListNode head, ListNode tail) {// tail is excluded
        if(head == tail)
            return null;
        ListNode slow = head, fast = head;
        TreeNode root = new TreeNode(0);
        /* It doesn't matter if fast is the last or null, fast is not used
        in passing on subpart and it always make sure that the two part's length
        difference is not greater than 1*/
        //Don't use null as tail!!!!!!
        while(fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        root.val = slow.val;
        root.left = construct(head, slow);
        root.right = construct(slow.next, tail);
        return root;
    }

}
