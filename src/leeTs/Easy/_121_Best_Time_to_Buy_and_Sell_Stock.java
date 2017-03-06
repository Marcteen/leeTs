package leeTs.Easy;

public class _121_Best_Time_to_Buy_and_Sell_Stock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxProfitAdvance(int[] prices) {
        int cur = 0, max = 0;
        /*the transaction of buy at i and sell at j can be
        done buy and sell from i to j step by step, and the
        difference in this way(prices[i] - prices[i]) forms
        any max subarray sum problem.*/
        for(int i = 1; i < prices.length; i ++) {
            /*cur will increase or some k day the minus profit
            make the transaction chain contain the any part before
            k cannot fill in k day's decrease, so it will be cut off
            and find some other profit excluding k and after. If the
            max profite is before k, it must have been save by max*/
            cur = Math.max(0, cur += prices[i] - prices[i - 1]);
            max = cur > max ? cur : max;
        }
        return max;
    }
	//keep the min so far, sell with current day and save maximums
	public int maxProfitNeat(int[] prices) {
        int min = Integer.MAX_VALUE, max = 0, cur = 0;
        for(int i = 0; i < prices.length; i ++) {
            if(prices[i] < min)
                min = prices[i];
            else {
                cur = prices[i] - min;
                if(cur > max)
                    max = cur;
            }
        }
        return max;
    }
}
