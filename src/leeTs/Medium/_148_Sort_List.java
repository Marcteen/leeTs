package leeTs.Medium;

import java.util.LinkedList;

public class _148_Sort_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode input = new ListNode(3);
		input.next = new ListNode(2);
		input.next.next = new ListNode(4);
		ListNode result = sortListIterativeFS(input);
	}
	//Though iterative, it still too slow to pass the last test case
	public static ListNode sortListIterativeFS(ListNode head) {
        ListNode connect = null;
        LinkedList<ListNode> nodeStack = new LinkedList<>(), connectStack = new LinkedList<>();
        nodeStack.push(head);
        ListNode prevHat = null, prevCur = null, pre = null;
        connectStack.push(connect);
        while(!nodeStack.isEmpty()) {
            head = nodeStack.pop();
            connect = connectStack.pop();
            /*this means it have some former result to append behind it, because each time
            we push (prev, largerHead) then (largerHead.next, ealierToBeAppend), so the former
            first node of upper stack layer is the result to be append to it. when head is null, it
            has no more follwer to be split to sub problem, thus the pushing terminates.*/
            /*only when chain-poping need append the pre head, otherwise it may switch to some
            middle element's prev part, when pushing in this part, we need to keep the connect
            which appended by the second part's result be keep until chain-poping again*/
            /*That is to say, let 0 be the index of stack top, the connect of layer i only append
            the result of layer i - 1, otherwise we set pre = null to prevent wrong appending*/
            if(null != connect  && null != pre)
                connect.next = pre;// reuse of template variable
            if(null != head) {
                prevHat = new ListNode(0);
                prevCur = prevHat;
                pre = head;
                for(ListNode cur = head.next; null != cur;) {
                    if(cur.val < head.val) {
                        prevCur.next = cur;
                        pre.next = cur.next;
                        cur = cur.next;
                        prevCur = prevCur.next;
                        prevCur.next = null;
                    }
                    else {
                        pre = cur;
                        cur = cur.next;
                    }
                }
                /*we use head as the middle element*/
                nodeStack.push(prevHat.next);
                connectStack.push(head);
                /*We sort the second part first, so make it at the top of stack*/
                nodeStack.push(head.next);
                connectStack.push(connect);
                /*still pushing, so it is its sub part to be handle next
                 * can't append it to it subpart, when push, we need to keep
                 * connect unchanged*/
                pre = null;
            }
            else
            /*in this way, to node to be connected behind it became the firsNode, no need to push*/
                pre = connect;/*replace head = connect, pre = head*/
        }
        return pre;
    }
	// a recursive fast sort, may be too slow
	public ListNode sortFS(ListNode toSort, ListNode connect) {
        if(null == toSort)
            return connect;
        ListNode prevHat = new ListNode(0), prevCur = prevHat, pre = toSort;
        for(ListNode cur = toSort.next; null != cur;) {
            if(cur.val < toSort.val) {
                prevCur.next = cur;
                pre.next = cur.next;
                cur = cur.next;
                prevCur = prevCur.next;
                prevCur.next = null;
            }
            else {
                pre = cur;
                cur = cur.next;
            }
        }
        toSort.next = sortFS(toSort.next, connect);
        return sortFS(prevHat.next, toSort);
    }
}
