package leeTs.Easy;

public class _206_Reverse_Linked_List {

	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static ListNode reverseListIteratively(ListNode head) {
		if(null == head)
			return head;
		else {
			ListNode newHead = new ListNode(0);
			ListNode temp;
			for(;null != head; head = temp) {
				temp = head.next;
				head.next = newHead.next;
				newHead.next = head;			
			}
			return newHead.next;
		}
	}
	
	public static ListNode reverseListNaiveRecursively(ListNode head) {
		if(null == head)
			return head;
		else {
			if(null == head.next)
				return head;
			else {
				ListNode tail = reverseListNaiveRecursively(head.next);
				ListNode temp = tail;
				while(null != temp.next)
					temp = temp.next;
				temp.next = head;
				head.next = null;
				return tail;
			}
		}
	}
	
	public static ListNode reverseList(ListNode head) { // this is fast for removing the forward to the list's end in each recursion.
		if(null == head) {
			return head;
		}
		else {
			return reverse(head, null);
		}
	}
	
	public static ListNode reverse(ListNode head, ListNode tail) {
		if(null == head.next) {
			return head;
		}
		else {
			ListNode end = head.next;
			ListNode rest = reverse(head.next, end);
			end.next = head;
			tail = head;
			tail.next = null;
			return rest;
		}
	}
}
