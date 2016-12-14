package leeTs.Easy;

public class _203_Remove_Linked_List_Elements {

	public static class ListNode{
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode removeElements(ListNode head, int val) {
		ListNode hat = new ListNode(0);
		hat.next = head;
		ListNode pre = hat;
		for(ListNode cur = head; null != cur; cur = cur.next) {
			if(cur.val == val) {
				pre.next = cur.next;
			}
			else
				pre = cur;
		}
		return hat.next;
	}

}
