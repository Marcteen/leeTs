package leeTs.Medium;

public class _48_Rotate_Image {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = new int[4][4];
		System.out.println(mat.length);
	}
	//well the rotate can actually be done with symmetric and mirror-swap in horizon or vertical
	public void rotate(int[][] matrix) {
        int step = matrix.length - 1, layer = matrix.length / 2, rotateI = 0, rotateJ = 0;
        for(int base = 0; base < layer; base ++) {// indicate which layer we are rotating
            for(int pace = 0; pace < step; pace ++) {// control steps in each layer, which we rotate a row, so 
                rotateI = 0;// in one layer, each pair start at 0 row (regard of outter layers,as well as the inner ones..)
                rotateJ = pace;
                for(int i = 0; i < 3; i ++) { // each pair need in swap anti-clockwise 3 times
                    //swap (i, j) whith (j, step - i)
                    //though rotateI is set to 0 zero at the begin of each pair, we still need it for anti-clockwise rotating 
                    swap(matrix, rotateI + base, rotateJ + base, rotateJ + base, step - rotateI + base);
                    rotateI = rotateI + step - rotateJ;// do the anti-clockwise rotating like we dicard the outter layer, but still when performing the real swaping to the matrix, we need use base as offset to get the real coordinate
                    rotateJ = rotateJ + rotateI - step;
                    rotateI -= rotateJ;
                }
            }
            step -= 2;// to the inner layer
        }
    }
    
    public void swap(int[][] matrix, int fooI, int fooJ, int barI, int barJ) {
        matrix[fooI][fooJ] ^= matrix[barI][barJ];
        matrix[barI][barJ] ^= matrix[fooI][fooJ];
        matrix[fooI][fooJ] ^= matrix[barI][barJ];
    }
}
