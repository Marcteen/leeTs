package leeTs.Medium;

public class _238_Product_of_Array_Except_Self {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int[] productExceptSelf(int[] nums) {
        int product[] = new int[nums.length], tailProduct = 1;
        for(int i = 0; i < nums.length; i ++) {
            product[i] = 1;
        }
        for(int i = 1; i < nums.length; i ++) {
            /*product[i - i] lacks of nums[i - 1], which is just we need*/
            product[i] = nums[i - 1] * product[i - 1];
        }
        tailProduct = nums[nums.length - 1];
        for(int i = nums.length - 2; i >= 0; i --) {
            product[i] *= tailProduct;
            tailProduct *= nums[i];
        }
        return product;
    }
}
