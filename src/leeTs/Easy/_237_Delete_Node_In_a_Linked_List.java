package leeTs.Easy;
import java.util.LinkedList;
public class _237_Delete_Node_In_a_Linked_List {

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void deleteNode(ListNode node) { // What a misleading question!
		node.val = node.next.val;
	    node.next = node.next.next;
	}

}
