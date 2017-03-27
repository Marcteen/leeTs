package leeTs.Medium;

public class _62_Unique_Path {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(uniquePaths(9, 9));
	}
	// using dp, the "right and down" constrain make it very easy to slove
	public static int uniquePaths(int m, int n) {
        int[] dp = new int[m];// use for each col's number of path, swipe it from right to left
        for(int i = 0; i < m; i++)
            dp[i] = 1;
        for(int i = n - 1; i > 0; i --){// swipe it, so we don't need store dp for all grid
            for(int j = m - 2; j >= 0; j --)// collect the right and down step
                dp[j] += dp[j + 1];
        }
        return dp[0];
    }
	// simple but too slow
	public int uniquePathsRecursively(int m, int n) {
        return tarverse(0, 0, m, n);
    }
    
    public int tarverse(int i, int j, int m, int n) {
        if(i == m)
            return 0;
        else
            if(j == n)
                return 0;
            else
                {
                    if(m - 1 == i && n - 1 == j)
                        return 1;
                    else
                        return tarverse(i + 1, j, m, n) + tarverse(i, j + 1, m, n);
                }
    }

}
