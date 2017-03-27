package leeTs.Medium;

public class _221_Maximal_Square {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*use dp, when a elements is 1, it can enlarge a exist square only
    when its left and upper elements are all have made a square, otherwise
    it has it self as a square of 1 length*/
    public int maximalSquare(char[][] matrix) {
        if(null == matrix || 0 == matrix.length || 0 == matrix[0].length)
            return 0;
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        int max = 0;
        for(int i = 1; i <= matrix.length; i ++)
            for(int j = 1; j <= matrix[0].length; j ++) {
        /*must check every element and use one more warp at upper at left to simply
        the pending procedure.*/
                if('1' == matrix[i - 1][j - 1]) {
                /*Note that it is a char martix!!!*/
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    max = Math.max(dp[i][j], max);
                }
            }
        /*we need area, not lenght only*/
        return max * max;
    }
}
