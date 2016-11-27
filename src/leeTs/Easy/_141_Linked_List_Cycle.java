package leeTs.Easy;

public class _141_Linked_List_Cycle {

	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x ;
			next = null;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean hasCycle(ListNode head) {
		ListNode hat = new ListNode(0);
		hat.next = head;
		ListNode pre = hat;
		ListNode cur = head;
		while(null != cur) {
			pre = cur;
			cur = cur.next;
			if(null != cur) {
			    if(cur == cur.next)
			        return true;
			    else
			        pre.next = pre;
			}
			else
			    return false;
		}
		return false;
	}

}
