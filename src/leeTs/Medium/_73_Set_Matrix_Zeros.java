package leeTs.Medium;

public class _73_Set_Matrix_Zeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//use col0 and row0 to store the symbol of zero-setting rather than number of non-zeros !!!
    public void setZeroesNeat(int[][] matrix) {
        if(null == matrix || matrix.length == 0)
            return;
        int m = matrix.length, n = matrix[0].length, col0 = matrix[0][0];
        for(int i = 0; i < m; i ++) {// the row0 is checked first, so no worry about overwrite
            if(0 == matrix[i][0])// take care of col0 to make matrix[..][0] available for all row
                col0 = 0;
            for(int j = 1; j < n; j ++)
                if(0 == matrix[i][j]) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
        }
        for(int i = m - 1; i >= 0; i --)// to avoid overwrite row0 and col1, we start from lower bound !!!!!!!!!
            for(int j = n - 1; j > 0; j --)
                if(0 == matrix[i][0] || 0 == matrix[0][j])
                    matrix[i][j] = 0;
        if(0 == col0)
            for(int i = 0; i < m; i++)
                matrix[i][0] = 0;
    }
	// tricky, found a available row and col to store the non-zeroes
	public void setZeroes(int[][] matrix) {
        if(null == matrix || matrix.length == 0)
            return;
        int m = matrix.length, n = matrix[0].length, zi, zj = 0;
        boolean found = false;
        fi:
        for(zi = 0; zi < m; zi ++)
            for(zj = 0; zj < n; zj ++)// not suppose to reach definately, so zj need front initialize
                if(0 == matrix[zi][zj]) {
                    found = true;
                    break fi;
                }
        if(!found)
            return;
        for(int i = 0; i < m; i ++)
            matrix[i][zj] = matrix[i][zj] == 0 ? 0 : 1;// must keep track of its original info
        for(int j = 0; j < n; j ++)
            matrix[zi][j] = matrix[zi][j] == 0 ? 0 : 1;
        for(int i = 0; i < m; i ++)
            if(i != zi)
                for(int j = 0; j < n; j ++)
                    if(j != zj)
                        if(0 != matrix[i][j]) {
                            matrix[zi][j] ++;
                            matrix[i][zj] ++;
                        }
        for(int j = 0; j < n; j ++)
            if(j != zj && matrix[zi][j] < m)
                for(int i = 0; i < m; i ++)
                    if(i != zi)
                        matrix[i][j] = 0;
        for(int i = 0; i < m; i ++)
            if(i != zi && matrix[i][zj] < n)
                for(int j = 0; j < n; j ++)
                    if(j != zj)
                        matrix[i][j] = 0;
        for(int i = 0; i < m; i ++)// don't forget to clear the sum
            matrix[i][zj] = 0;
        for(int j = 0; j < n; j ++)
            matrix[zi][j] = 0;
    }
}
