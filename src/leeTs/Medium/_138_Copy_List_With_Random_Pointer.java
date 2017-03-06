package leeTs.Medium;

import java.util.HashMap;

public class _138_Copy_List_With_Random_Pointer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/* we can also use map to copy all node in head first, then do the connect of
	next and random pointer. The other way is just append the new node right behind
	its origin, then do the random connect and extraction*/
	public RandomListNode copyRandomList(RandomListNode head) {
        if(null == head)
            return null;
        HashMap<RandomListNode, RandomListNode> visited = new HashMap<>();
        RandomListNode result = new RandomListNode(0), cur = result;
        for(; null != head; head = head.next) {
            if(visited.containsKey(head)) {
                cur.next = visited.get(head);
            }
            else {
                cur.next = new RandomListNode(head.label);
                visited.put(head, cur.next);
            }
            if(null != head.random) {
                if(visited.containsKey(head.random))
                    cur.next.random = visited.get(head.random);
                else {
                    cur.next.random = new RandomListNode(head.random.label);
                    visited.put(head.random, cur.next.random);
                }
            }
            cur = cur.next;
        }
        return result.next;
    }
	
}
