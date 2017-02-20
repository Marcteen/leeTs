package leeTs.Medium;

public class _86_Partition_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*Basically, we are forming two list, which contain element less and not less
	 * than the target respectively. So here we can traverse the list once and roll
	 * them to different sublist according to there value, and finally combine them
	 * together. It is also the essence of Quick sort*/
	public ListNode partition(ListNode head, int x) {
        if(null == head || null == head.next)
            return head;
        ListNode hat = new ListNode(0), target = head, cur = null, pre = null;
        hat.next = head;
        while(null != target && target.val < x) {
            hat = target;
            target = target.next;
        }
        if(null == target)
            return head;
        for(cur = target.next, pre = target; null != cur;) {
            if(cur.val < x) {
                if(hat.next == head)
                    head = cur;
                pre.next = cur.next;
                cur.next = target;
                hat.next = cur;
                hat = hat.next;
                cur = pre.next;
            }
            else {
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }

}
