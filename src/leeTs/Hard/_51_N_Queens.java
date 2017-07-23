package leeTs.Hard;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class _51_N_Queens {

	public static void main(String[] args) {
		int n = 5;
		List<List<String>> result = solveNQueens(n);
		for(List<String> si : result) {
			for(String ssi : si) {
				System.out.println(ssi);
			}
			System.out.println("__________________");
		}
	}
	
	private static void helper(char[] sample, int r, boolean[] cols, boolean[] d1, boolean[] d2, 
            List<String> board, List<List<String>> res) {
		if (r == sample.length) {
			ArrayList<String> one = new ArrayList<>();
			for(String si : board) {
				one.add(new String(si));
			}
			res.add(one);
		}
		else {
		for (int c = 0; c < sample.length; c++) {
			/*The diagonal use i - j (the \ direction) and i + j (the / direction)
			 * to index validation, the corespongind range is [ - (n - 1), n - 1]
			 * and [0, 2n - 1]*/
		    int id1 = r - c + sample.length - 1, id2 = r + c;//2*board.length - r - c - 1;
		    if (!cols[c] && !d1[id1] && !d2[id2]) {
		        sample[c] = 'Q';
		        board.add(new String(sample));
		        sample[c] = '.';
		        cols[c] = true; d1[id1] = true; d2[id2] = true;
		        helper(sample, r+1, cols, d1, d2, board, res);
		        cols[c] = false; d1[id1] = false; d2[id2] = false;
		        board.remove(board.size() - 1);
		    }
		}
	}
}

	public static List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new ArrayList<>();
		char[] sample = new char[n];
		Arrays.fill(sample, '.');
		helper(sample, 0, new boolean[n], new boolean[2*n - 1], new boolean[2*n - 1], 
		new ArrayList<String>(), res);
		return res;
	}
}
