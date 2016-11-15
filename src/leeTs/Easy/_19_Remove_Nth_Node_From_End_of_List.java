package leeTs.Easy;

public class _19_Remove_Nth_Node_From_End_of_List {

	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {val = x;}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode front = head;
		ListNode nBehind = head;
		ListNode nmBehind = head;
		for(int i = 0;i < n - 1;i++)
			front = front.next;
		while(null != front.next) {
			front = front.next;
			nmBehind = nBehind;
			nBehind = nBehind.next;
		}
		if(nmBehind == nBehind)
			head = head.next;
		else
			nmBehind.next = nBehind.next;
		return head;
	}
}
