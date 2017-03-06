package leeTs.Medium;

public class _61_Rotate_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class ListNode {
		int val;
		ListNode next;
		
	}
	
	public ListNode rotateRight(ListNode head, int k) {
        ListNode newHead = null, tailSeeker = null;
        if(null == head)
            return head;
        int count = 0;
        if(null != head.next) {
            while(count != k && 0 != k) {// if count == k , k % count + 1 remains the same and terminates, otherwise it won' work!!!
                //may need reloop, so count must be initialized here!!!!
                for(tailSeeker = head, count = 0; count < k && null != tailSeeker.next; count ++, tailSeeker = tailSeeker.next);
                k %= count + 1;/*if k > list's length, now count + 1 is the length of the list,
                                    when k > count + 1, tailSeeker reaches last node.Otherwise k won't change.*/
            }
            if(0 != k) {
                for(newHead = head; null != tailSeeker.next; newHead = newHead.next, tailSeeker = tailSeeker.next);
                
                tailSeeker.next = head;
                head = newHead.next;
                newHead.next = null;
            }
        }
        return head;
    }
}
