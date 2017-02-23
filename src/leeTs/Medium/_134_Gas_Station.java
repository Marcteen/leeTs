package leeTs.Medium;

public class _134_Gas_Station {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int canCompleteCircuit(int[] gas, int[] cost) {
		/*We don't need to care about the end, just traverse the array,
		 * start from the node i with diff = gas - cost >= 0, if we found, the passed
		 * node's diff made up nextSum, if we reach j which diff + nextSum < 0, means
		 * the real start can only be after j (if it is before j, then we already pass
		 * it and no way we would get stuck). So in this case we set start = j + 1, and
		 * merge prevSum to node j, and it will start from next first node of which
		 * diff >= 0. When it terminate, if nextSum > prevSum which means we can go from
		 * start to node 0, and the last breaker node 's diff can be fill and reach the start.
		 * it will get the first next*/
        int prevSum = 0, nextSum = 0, start = 0, sum = 0;
        for(int i = 0; i < gas.length; i ++) {
            sum = (gas[i] - cost[i]);
            if(sum < 0) {
                if(nextSum >= Math.abs(sum))
                    nextSum += sum;
                else {
                    prevSum += (nextSum + sum);
                    start = i + 1;
                    nextSum = 0;
                }
            }
            else
                nextSum += sum;
        }
        return nextSum + prevSum >= 0 ? start : -1;
    }

}
