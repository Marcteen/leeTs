package leeTs.Medium;

public class _59_Spiral_Matrix_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	public int[][] generateMatrix(int n) {
        int count = n * n;
        int[][] spiral = new int[n][n];
        int rowMin = 0, rowMax = n - 1, colMin = 0, colMax = rowMax, i = 0, j = 0;
        for(int num = 1; num <= count;) {
            for(j = colMin; j <= colMax; j ++)// when it done , j will greater than colMax, so we use colMax next, so as i
                 spiral[rowMin][j] = num ++;
            rowMin ++;
            
            for(i = rowMin; i <= rowMax; i ++)
                spiral[i][colMax] = num ++;
            colMax --;
            
            for(j = colMax; j >= colMin; j --)
                spiral[rowMax][j] = num ++;
            rowMax --;
            
            for(i = rowMax; i >= rowMin; i --)
                spiral[i][colMin] = num ++;
            colMin ++;
        }
        return spiral;
    }
}
