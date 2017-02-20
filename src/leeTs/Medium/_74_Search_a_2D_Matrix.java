package leeTs.Medium;

public class _74_Search_a_2D_Matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean searchMatrix(int[][] matrix, int target) {
        if(null == matrix || 0 == matrix.length)
            return false;
        int m = matrix.length, n = matrix[0].length, low = 0, high = m * n - 1, i = 0, j = 0, mid;
        while(low <= high) {
            mid = low + (high - low) / 2;
            i = mid / n;
            j = mid % n;// a - (a / b) * b == a % b!!!!!!!!!!!!!
            if(matrix[i][j] > target)
                high = mid - 1;
            else
                if(matrix[i][j] < target)
                    low = mid + 1;
                else
                    return true;
        }
        return false;
    }

}
