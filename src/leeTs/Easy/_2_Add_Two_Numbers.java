package leeTs.Easy;

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
		while(true) {
			sum = 0;
			if(null != l1)// equals will compare the content of the object, so here we use == 
				sum = l1.val + l2.val;
			sum += carry;// the sum of this digit and former's carry
			carry = 0;
			if(sum >= 10) {
				sum -= 10;
				carry = 1;
			}
			resultCur.val = sum;
			if(null != l1.next || carry > 0) {// the condition for next digit
				resultCur.next = new ListNode(0);
				l1 = l1.next;
				l2 = l2.next;
				resultCur = resultCur.next;
			}
			else
				break;
		}
		return result;
	}

	public static class ListNode { // The static method addTwoNumbers can only access the static class
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
}
