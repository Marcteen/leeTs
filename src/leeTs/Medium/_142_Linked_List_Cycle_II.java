package leeTs.Medium;

public class _142_Linked_List_Cycle_II {
	// a naive fast and slow pointer solution
	
	/*Say that fast's speed is two times of slow. When fast catch up slow, let the distance
    slow has moved be A + B(A before it enters circle), so fast has been walked 2A+2B, that is
    A + B difference. It is clear that fast goes more whole circle than slow(just like they both
    start at the catching up node and fast get more A + B(no matter how many circle it equals)
    step immediately and catch slow at the same position), so if slow goes more A step, it will 
    be at the entrance node of circle. Now we let another pointer goes from head with slow simultaneously,
    than they will meet at the target node.*/
    public ListNode detectCycleTricky(ListNode head) {
        ListNode slow = head, fast = head;
        while(null != fast && null != fast.next) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) {
                ListNode hat = head;
                while(hat != slow) {
                    hat = hat.next;
                    slow = slow.next;
                }
                return hat;
            }
        }
        return null;
    }
	public ListNode detectCycleNaive(ListNode head) {
        ListNode hat = new ListNode(0);
        hat.next = head;
        for(ListNode slow = head, fast = head; null != fast && null != fast.next; slow = slow.next, fast = fast.next.next) {
            if(slow == hat || fast == hat)
                return hat;
            /*each time fast catch up with slow, it run a circle, and hat is 
             * still not in the circle, so move it*/
            else if(slow == fast)
                hat = hat.next;
        }
        return null;
    }
}
