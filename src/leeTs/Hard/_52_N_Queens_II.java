package leeTs.Hard;

public class _52_N_Queens_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*Nothing specail but just remove the case generating
	 * from 51*/
	private static int helper(int n, int r, boolean[] cols, boolean[] d1, boolean[] d2) {
		if (r == n) {
			return 1;
		}
		else {
    		int count = 0;
    		for (int c = 0; c < n; c++) {
    			/*The diagonal use i - j (the \ direction) and i + j (the / direction)
    			 * to index validation, the corespongind range is [ - (n - 1), n - 1]
    			 * and [0, 2n - 1]*/
    		    int id1 = r - c + n - 1, id2 = r + c;//2*board.length - r - c - 1;
    		    if (!cols[c] && !d1[id1] && !d2[id2]) {
    		        cols[c] = true; d1[id1] = true; d2[id2] = true;
    		        count += helper(n, r+1, cols, d1, d2);
    		        cols[c] = false; d1[id1] = false; d2[id2] = false;
    		    }
    		}
    		return count;
		}
    }

	public static int totalNQueens(int n) {
		return helper(n, 0, new boolean[n], new boolean[2*n - 1], new boolean[2*n - 1]);
	}
}
