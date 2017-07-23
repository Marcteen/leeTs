package leeTs.Medium;

public class _Search_a_2D_Matrix_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean searchMatrix(int[][] matrix, int target) {
        if(null == matrix || 0 == matrix.length || 0 == matrix[0].length)
            return false;
        int m = matrix.length, n = matrix[0].length, i = 0, j = n - 1;
        while(i >= 0 && i < m && j >= 0 && j < n) {
            if(matrix[i][j] > target)
                j --;
            else if(matrix[i][j] < target)
                i ++;
            else
                return true;
        }
        return false;
    }
}
