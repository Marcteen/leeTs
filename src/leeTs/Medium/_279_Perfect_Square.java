package leeTs.Medium;

public class _279_Perfect_Square {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*the dp key: the solution of current number is surely can be construct
    from the previous solution by adding a square!!!!*/
    public int numSquares(int n) {
        if(n < 2)
            return n;
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i ++)
            dp[i] = Integer.MAX_VALUE;
        /*when handle i, the number before i must have been processed*/
        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j * j <= i; j ++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
