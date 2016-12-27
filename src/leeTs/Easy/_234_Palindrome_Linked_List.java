package leeTs.Easy;

public class _234_Palindrome_Linked_List {

	public class ListNode {
		int val;
		ListNode next;
		ListNode (int x) {
			val = x;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isPalindrome(ListNode head) {
		if(null == head)
			return true;
		else
			if(null == head.next)
				return true;
			else {
				ListNode hat = new ListNode(0);
				ListNode step = hat;
				ListNode stepPre = null;
				ListNode stepNext = head;
				ListNode steps = hat;
				boolean even = true;
				hat.next = head;
				while(null != steps.next) {
					steps = steps.next;
					if(null != steps.next)
						steps = steps.next;
					else
						even = false;
					stepPre = step;// Reverse the former half list with step
					step = stepNext;
					stepNext = step.next;
					step.next = stepPre;
				}
				if(false == even)// if the list's length is not even, step must locate at the very center, so rewind it(Now the former half is already reversed)
					step = step.next;
				steps = stepNext;// the head of the latter half of the list
				while(null != steps) {
					if(step.val == steps.val) {
						step = step.next;
						steps = steps.next;
					}
					else
						return false;
				}
				return true;
			}
	}
	
}
