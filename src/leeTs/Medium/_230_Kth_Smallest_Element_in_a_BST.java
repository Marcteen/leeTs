package leeTs.Medium;

public class _230_Kth_Smallest_Element_in_a_BST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	public int kthSmallest(TreeNode root, int k) {
        int[] parcel = getKth(root, new int[]{0, 0}, k);
        return parcel[1];
    }
    
    int[] getKth(TreeNode root, int[] parcel, int k) {
        if(null == root)
            return parcel;
        int[] leftParcel = getKth(root.left, parcel, k);
        /*find the target at the left child tree*/
        if(leftParcel[0] == 1)
            return leftParcel;
        int curIndex = leftParcel[1] + 1;
        /*this node is just the target*/
        if(curIndex == k) 
            return new int[]{1, root.val};
        /*find the target in right child tree*/
        return getKth(root.right, new int[]{0, curIndex}, k);
    }
	
}
