package leeTs.Medium;

public class _116_Populating_Next_Right_Pointers_in_Each_Node {

	
	/*connect layer by layer, from top down, they are promised in sequence*/
    public void connect(TreeLinkNode root) {
        TreeLinkNode top = root, pre = null, cur = null;
        while(null != top) {// we connect top and its next pointed node's children
            cur = top;
            while(null != cur) {
                if(null != cur.left) {// it is not the last layer
                    if(null != pre)
                        pre.next = cur.left;
                    else//prone to be ignored
                        pre = cur.right;
                    cur.left.next = cur.right;
                    pre = cur.right;//prone to be ignored
                }
                // we have ensurance that its neigbour has been connected earlier
                cur = cur.next;
            }
            pre = null;
            top = top.left;
        }
    }
}
