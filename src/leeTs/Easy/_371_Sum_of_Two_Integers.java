package leeTs.Easy;

public class _371_Sum_of_Two_Integers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int getSum(int a, int b) {
		int intersection = a & b;
		intersection <<= 1;
		int exclusiveOr = a ^ b;
		int temp = 0;
		while(0 != intersection) {
			temp = exclusiveOr ^ intersection; // the sum of last sum without bypass and corresponding bypass
			intersection = exclusiveOr & intersection;// check next bypass
			intersection <<= 1;
			exclusiveOr = temp;
		}
		return exclusiveOr;
	}

}
