package leeTs.Medium;

public class _147_Insertion_Sort_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// Why is this a medium
	public ListNode insertionSortList(ListNode head) {
        if(null == head)
            return null;
        ListNode sortedHat = new ListNode(0), pre = null, temp = null;
        while(null != head) {
            for(pre = sortedHat; null != pre.next && pre.next.val <= head.val; pre = pre.next);
            temp = head.next;
            head.next = pre.next;
            pre.next = head;
            head = temp;
        }
        return sortedHat.next;
    }
}
