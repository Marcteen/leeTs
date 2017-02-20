package leeTs.Medium;

public class _92_Reverse_Linked_List_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	public ListNode reverseBetween(ListNode head, int m, int n) {
        if(null == head || m == n)
            return head;
        ListNode hat = new ListNode(0), target = null, cur = null;
        hat.next = head;
        int i = 1;
        for(target = head; i < m; i ++) {
            hat = target;
            target = target.next;
        }
        
        for(cur = target.next; i < n; i ++) {
            if(hat.next == head)
                head = cur;
            target.next = cur.next;
            cur.next = hat.next;
            hat.next = cur;
            cur = target.next;
        }
        return head;
    }
}
