package leeTs.Medium;

import java.util.Arrays;

public class _64_Minimum_Path_Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	// be careful about the initialization of dp
	public int minPathSum(int[][] grid) {
        if(null == grid)
            return 0;
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[m];
        dp[m - 1] = grid[m - 1][n - 1];
        for(int i = m - 2; i >= 0; i --)
            dp[i] = grid[i][n - 1] + dp[i + 1];
        for(int j = n - 2; j >= 0; j --) {
            dp[m - 1] += grid[m - 1][j];
            for(int i = m - 2; i >= 0; i --)
                dp[i] = grid[i][j] + Math.min(dp[i + 1], dp[i]);
        }
        return dp[0];
    }
}
