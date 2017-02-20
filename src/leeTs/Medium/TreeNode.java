package leeTs.Medium;

public class TreeNode {
	int val;
	TreeNode right;
	TreeNode left;
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
