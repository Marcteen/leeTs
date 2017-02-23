package leeTs.Easy;

public class _122_Best_Time_to_Buy_and_Sell_Stock_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int maxProfit(int[] prices) {
        int accum = 0, sum = 0, cur = 0;
        /*Any selected transaction are equal to the (i - 1, i) transaction chains
        , so all we need is to avoid the prices[i] < prices[i - 1]*/
        for(int i = 1; i < prices.length; i ++) {
            cur = prices[i] - prices[i - 1];
            if(cur < 0) {
            /*Detected a decrese, must distract it*/
                sum += accum;
                accum = 0;
            }
            else
                accum += cur;
        }
        sum += accum;
        return sum;
    }
}
