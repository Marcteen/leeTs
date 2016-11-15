package leeTs.Easy;

public class _21_Merge_Two_Sorted_List {

	public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);
		ListNode cur = result;
		ListNode rest = new ListNode(0);
		while(null != l1 && null != l2) {
			if(l1.val > l2.val) {
				cur.next = l2;
				l2 = l2.next;
			}
			else {
				cur.next = l1;
				l1 = l1.next;
			}
			cur = cur.next;
		}
		if(null != l1)
			rest = l1;
		else
			rest = l2;
		while(null != rest){
			cur.next = rest;
			rest = rest.next;
			cur = cur.next;
		}
		return result.next;
	}
}
