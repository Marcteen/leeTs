package leeTs.Hard;

public class u_4_Median_of_Two_Sorted_Arrays {
	public static void main(String[] args) {
		
	}
	public static double findMedianSortedArrays(int[] num1, int[] num2) {
		int[] former;
		int[] latter;
		double result = 0;
		int joint;// 1-gap, 2-joint, 3-contain
		if(num1[0] > num2[0]) {
			former = num2;
			latter = num1;
			if(num1[0] < num2[num2.length - 1])
				if(num1[num1.length - 1] < num2[num2.length - 1])// num1 is within num2
					joint = 3;
				else//part of num1 is within num2
					joint = 2;
			else//no joint part, even if they are equal
				joint = 1;
		}
		else {
			former = num1;
			latter = num2;
			if(num2[0] < num1[num1.length - 1])
				if(num2[num2.length - 1] < num1[num1.length - 1])// num2 is within num1
					joint = 3;
				else//part of num2 is within num1
					joint = 2;
			else//no joint part, even if they are equal
				joint = 1;
		}
		int wholeLength = num1.length + num2.length;
		int median = wholeLength / 2;
		boolean isEven = (0 == wholeLength % 2);
		switch(joint) {
		case 1://no joint
			if(median < former.length) {//median in former
				result = former[median - 1];
			}
			else {
				result = latter[median - former.length - 1];
			}
		case 2://part of latter is in former
			int latterHeadinFormer = findPosition(former, latter[0]);
			int fomerEndinLatter = findPosition(latter, former[former.length - 1]);
		case 3://latter is within former	
		}
		return result;
	}
	public static int findPosition(int[] nums, int target) {// must be 
		int left = 0;
		int right = nums.length - 1;
		int middle = 0;
		boolean isleft = true;//trace last move of bound for determining the pos of a noexist target
		while(left <= right) {//still active when only one rest with left == right
			middle = (right - left) / 2 + left;//prevent overflow!
			if(nums[middle] > target) {
				right = middle - 1;
				isleft = false;
			}
			else
				if(nums[middle] < target) {
					left = middle + 1;
					isleft = true;
				}
				else
				{
					return middle + 1;
				}
		}
		if(isleft)
			return left;
		else
			return right;
	}
}
