package leeTs.Medium;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class _103_Binary_Tree_Zigzag_Level_Order_Traversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/* do the traverse as usual, we can insert the val to the sub result
	 * at one of two bound to make it be normal or inverse*/
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if(null == root)
            return result;
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> curLayer = null;
        int numCur = 1, numNext = 0, direction = 0;
        queue.offer(root);
        root = null;
        while(!queue.isEmpty()) {
            curLayer = new LinkedList<Integer>();
            for(int i = 0; i< numCur; i ++) {
                root = queue.poll();
                if(null != root.right) {// always offer from right to left
                    numNext ++;
                    queue.offer(root.right);
                }
                if(null != root.left) {
                    numNext ++;
                    queue.offer(root.left);
                }
                if(0 == direction)// from left to right, so insert at head to inverse it
                    curLayer.addFirst(root.val);
                else
                    curLayer.add(root.val);// the same
            }
            result.add(curLayer);
            numCur = numNext;
            numNext = 0;
            direction ++;
            direction %= 2;
        }
        return result;
    }

}
