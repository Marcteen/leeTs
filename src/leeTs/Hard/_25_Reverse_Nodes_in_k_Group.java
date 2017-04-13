package leeTs.Hard;

public class _25_Reverse_Nodes_in_k_Group {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*nothing special, just reconstruct the list with few hat node*/
	public ListNode reverseKGroup(ListNode head, int k) {
        if(null == head || k < 2)
            return head;
        int step = 1;
        ListNode hat = new ListNode(0), prev = hat, cur = head, next = head;
        ListNode newHat = new ListNode(0), newNext = null, newLast = null;
        hat.next = head;
        while(null != next) {
            next = next.next;
            step ++;
            /*now [prev, next] is the sub list to be reversed*/
            if(step == k && next != null) {
                next = next.next;
                newLast = cur;
                while(cur != next) {
                    newNext = cur.next;
                    cur.next = newHat.next;
                    newHat.next = cur;
                    cur = newNext;
                }
                /*connect the rest list to the tail of reversed list*/
                newLast.next = next;
                /*connect the reversed list to the previous result*/
                prev.next = newHat.next;
                prev = newLast;
                newHat.next = null;
                cur = next;
                step = 1;
            }
        }
        return hat.next;
    }

}
