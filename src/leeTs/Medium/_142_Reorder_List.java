package leeTs.Medium;

public class _142_Reorder_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void reorderList(ListNode head) {
        if(null == head)
            return;
        ListNode slow = head, fast = head, temp = null;
        // fast slow pointers fit front-traversing-while clause well
        /*if there is even number of nodes, slow will be at the top of the
        lower half, otherwise be at the real middle of odd number of nodes*/
        while(null != fast && null != fast.next) {
            slow = slow.next;
            fast = fast.next.next;
        }// when termiate, slow will stop at the node that right before the ones need to be move
        fast = null;// use to construct a reverse list of second half
        while(null != slow.next) {
            temp = slow.next.next;
            slow.next.next = fast;
            fast = slow.next;
            slow.next = temp;
        }
        // the slow node 
        while(null != fast) {
            temp = fast.next;
            fast.next = head.next;
            head.next = fast;
            head = head.next.next;
            fast = temp;
        }
    }
}
