package leeTs.Hard;

import leeTs.Medium.ListNode;

public class _23_Merge_k_Sorted_Lists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*use the thought of merging sort, treat each list as a single element*/
	public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;
        return mergeBranch(lists, 0, lists.length - 1);
    }
    public ListNode mergeBranch(ListNode[] lists, int start, int end) {
        if(start == end) {
            return lists[start];
        } else if(start + 1 == end) {
            return mergeBinary(lists[start], lists[end]);  
        } else {
            int mid = start + (end - start) / 2;
            return mergeBinary(mergeBranch(lists, start, mid), mergeBranch(lists, mid + 1, end));
        }
    }
    public ListNode mergeBinary(ListNode foo, ListNode bar) {
        ListNode hat = new ListNode(0), cur = hat;
        while(null != foo && null != bar) {
            if(foo.val < bar.val) {
                cur.next = foo;
                foo = foo.next;
            } else {
                cur.next = bar;
                bar = bar.next;
            }
            cur = cur.next;
            cur.next = null;
        }
        if(null == foo)
            foo = bar;
        cur.next = foo;
        return hat.next;
    }

}
