package leeTs.Medium;


public class _82_Remove_Duplicates_form_Sorted_List_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode deleteDuplicates(ListNode head) {
        if(null == head || null == head.next)
            return head;
        ListNode pre = head, cur = head.next, hat = new ListNode(0);
        hat.next = head;// we may delete head
        for(;null != cur; cur = cur.next)
            if(cur.val != pre.val)
                if(hat.next == pre) {// this means we didn't find any duplicates from hat to cur
                    hat = pre;
                    pre = cur;
                }
                else {
                    if(hat.next == head)
                        head = cur;
                    hat.next = cur;
                    pre = cur;
                }
            else// we spot an duplicate
                pre = cur;
        if(hat.next != pre) {// the list has duplicates in tail
            if(hat.next == head)
                head = cur;
            hat.next = cur;
        }
        return head;
    }

}
