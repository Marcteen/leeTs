package leeTs.Easy;

public class _83_Remove_Duplicates_from_Sorted_List {

	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static ListNode deleteDuplicates(ListNode head) {
		if(null == head)
			return head;
		else {
				int last = head.val;
				ListNode pre = head;
				for(ListNode cur = head.next; null != cur;) {
					if(last == cur.val)
						pre.next = cur.next;
					else {
						last = cur.val;
						pre = pre.next;
					}
					cur = cur.next;
				}
		}
		return head;
	}
}
