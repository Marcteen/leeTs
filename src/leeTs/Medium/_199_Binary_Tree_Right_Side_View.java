package leeTs.Medium;

import java.util.List;
import java.util.LinkedList;

public class _199_Binary_Tree_Right_Side_View {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*use the layer wise traverse, and only take each layer's last value*/
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if(null == root)
            return result;
        LinkedList<TreeNode> queue = new LinkedList<>();
        int size = 0;
        queue.offer(root);
        while(!queue.isEmpty()) {
            for(size = queue.size(); size > 0; size --) {
                root = queue.poll();
                if(null != root.left)
                    queue.offer(root.left);
                if(null != root.right)
                    queue.offer(root.right);
            }
            //take the last one
            result.add(root.val);
        }
        return result;
    }

}
