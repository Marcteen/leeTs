package leeTs.Medium;

public class _63_Unique_Path_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(null == obstacleGrid)
            return 0;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if(1 == obstacleGrid[m - 1][n - 1])
            return 0;
        int[] dp = new int[m];
        dp[m - 1] = 1;
        for(int j = n - 1; j >= 0; j --) {
            if(1 == obstacleGrid[m - 1][j])
                dp[m - 1] = 0;
            for(int i = m - 2; i >= 0; i --)
                if(1 == obstacleGrid[i][j])
                    dp[i] = 0;
                else
                    dp[i] += dp[i + 1];
        }
        return dp[0];
    }
}
