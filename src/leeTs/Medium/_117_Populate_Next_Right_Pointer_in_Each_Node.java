package leeTs.Medium;

public class _117_Populate_Next_Right_Pointer_in_Each_Node {

	public void connect(TreeLinkNode root) {
        TreeLinkNode nextTop = null, prev = null;
        for(TreeLinkNode top = root; null != top; top = nextTop) {
            nextTop = null;
            /*Because it for any binary tree, so we need
            to check its left and right child every time.
            Also the start of next cur is not always in left bound*/
            prev = null;
            for(TreeLinkNode cur = top; cur != null; cur = cur.next) {
                if(null != cur.left) {
                    if(null != prev)
                        prev.next = cur.left;
                    prev = cur.left;
                    if(null == nextTop)// get the left bound for next layer
                        nextTop = prev;
                }
                if(null != cur.right) {
                    if(null != prev)
                        prev.next = cur.right;
                    prev = cur.right;
                    if(null == nextTop)
                        nextTop = prev;
                }
            }
        }
    }
}
