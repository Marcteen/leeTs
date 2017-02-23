package leeTs.Medium;

public class TreeNode {
	public int val;
	public TreeNode right;
	public TreeNode left;
	TreeNode(int x) {val = x;}
	public Object clone() {
		try{
			return super.clone();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
