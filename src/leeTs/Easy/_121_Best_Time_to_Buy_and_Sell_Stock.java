package leeTs.Easy;

public class _121_Best_Time_to_Buy_and_Sell_Stock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int maxProfit(int[] prices) {
		int maxDiff = 0;
		int diff = 0;
		for(int i = 0; i < prices.length - 1; i ++) {
			for(int j = i + 1; j < prices.length; j ++) {
				diff = prices[j] - prices[i];
				maxDiff = diff > maxDiff ? diff : maxDiff;
			}
		}
		return maxDiff;
	}
}
