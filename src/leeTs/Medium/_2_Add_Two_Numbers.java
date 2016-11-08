package leeTs.Medium;

public class _2_Add_Two_Numbers {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(5);
		//l1.next = new ListNode(4);
		//l1.next.next = new ListNode(3);
		ListNode l2 = new ListNode(5);
		//l2.next = new ListNode(6);
		//l2.next.next = new ListNode(4);
		ListNode result = addTwoNumbers(l1, l2);
		System.out.println("The reuslt is:");
		while(null != result) {
			System.out.println(result.val);
			result = result.next;
		}
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);
		ListNode resultCur = result;
		int carry = 0;
		int sum;
		while(null != l1 && null != l2) {
			resultCur.next = new ListNode(0);
			resultCur = resultCur.next;
			sum = l1.val + l2.val + carry;
			if(sum >= 10) {
				sum -= 10;
				carry =1;
			}
			else {
				carry = 0;
			}
			resultCur.val = sum;
			l1 = l1.next;
			l2 = l2.next;
		}
		ListNode rest;
		if(null == l1)
			if(null == l2) {// two lists are of same lenght
				if(carry > 0) {
					resultCur.next = new ListNode(0);
					resultCur = resultCur.next;
					resultCur.val = carry;
				}
				return result.next;
			}
			else {// deal with remained l2
				rest = l2;
			}
		else
			rest = l1;
		while(null != rest) {// there may be carry in chain!
			resultCur.next = new ListNode(0);
			resultCur = resultCur.next;
			sum = rest.val + carry;
			if(sum >= 10) {
				sum -= 10;
				carry =1;
			}
			else {
				carry = 0;
			}
			resultCur.val = sum;
			rest = rest.next;
		}
		if(carry > 0) {//again the last carry
			resultCur.next = new ListNode(0);
			resultCur = resultCur.next;
			resultCur.val = carry;
		}
		return result.next;
	}

	public static class ListNode { // The static method addTwoNumbers can only access the static class
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
}
