package leeTs.Easy;

public class _24_Swap_Nodes_in_Pairs {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		ListNode result = swapPairs(head);
	}
	
	public static ListNode swapPairs(ListNode head) {
		if(null == head)
			return head;
		else
			if(null == head.next)
				return head;
			else {
				ListNode hat = new ListNode(0);
				hat.next = head;
				ListNode pre = hat;
				ListNode mid = head;
				ListNode front = head.next;
				while(null != front && null != front.next) {
					pre.next = front;
					mid.next = front.next;
					front.next = mid;
					pre = mid;
					mid = mid.next;
					if(null != mid.next)// in case that only one element left
						front = mid.next;
					else
						front = null;
				}
				if(null != front) {
					pre.next = front;
					mid.next = front.next;
					front.next = mid;
				}
				return hat.next;
			}
	}

}
