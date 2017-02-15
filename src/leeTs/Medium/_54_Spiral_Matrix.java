package leeTs.Medium;

import java.util.ArrayList;
import java.util.List;

public class _54_Spiral_Matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] input = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		List<Integer> result = spiralOrder(input);
	}

	public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(null == matrix || matrix.length == 0)
            return result;
        int rowUpper = 0, rowLower = matrix.length - 1, colUpper = 0, colLower = matrix[0].length - 1, i = 0, j = 0;
        /* used two pairs of bound to shrink the path for spiral tarverse*/
        /* way too many parameters change in layers(outter to inner), so no use of relative index*/
        while(rowUpper <= rowLower && colUpper <= colLower) {// Consider the extreme case that there is only one element
            for(j = colUpper, i = rowUpper; j <= colLower; j ++)
                result.add(matrix[i][j]);
            rowUpper ++;// shrink
            for(i = rowUpper, j = colLower; i <= rowLower; i ++)/* we relocate the index to new shrinked bound so that
            the shrink in and after each layer is pretty smooth, and more easy to understand than use counter!!*/
                result.add(matrix[i][j]);
            colLower --;
            for(j = colLower, i = rowLower; j >= colUpper; j --)
                result.add(matrix[i][j]);
            rowLower --;
            for(i = rowLower, j = colUpper; i >= rowUpper; i --)
                result.add(matrix[i][j]);
            colUpper ++;
        }
        return result;
    }
	
}
