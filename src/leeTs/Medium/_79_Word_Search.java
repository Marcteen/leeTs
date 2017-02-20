package leeTs.Medium;

public class _79_Word_Search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'},
			{'A', 'D', 'E', 'F'}};
		String word = "ABCCED";
	}
	
	public boolean exist(char[][] board, String word) {
		// Don't mistaken != with == !!!!!
        if(null == board || 0 == board.length || null == word)
            return false;
        if(0 == word.length())
            return true;
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i ++)
            for(int j = 0; j < n; j ++)
                if(word.charAt(0) == board[i][j])// to make it easier, always start at first char
                    if(trace(board, word, 1, i, j, m, n))
                        return true;
        return false;
    }
	    
    public boolean trace(char[][] board, String word, int pos, int i, int j, int m, int n) {
        if(pos == word.length())
            return true;
        else {
            char c = board[i][j];
            board[i][j] = 0;
// Once we found a way in one direction, we should immediately terminated and return!!!!!!!!! 
            if(j > 0 && board[i][j - 1] == word.charAt(pos))
                if(trace(board, word, pos + 1, i, j - 1, m, n))
                    return true;
            if(j < n - 1 && board[i][j + 1] == word.charAt(pos))
                if(trace(board, word, pos + 1, i, j + 1, m, n))
                    return true;
            if(i > 0 && board[i - 1][j] == word.charAt(pos))
                if(trace(board, word, pos + 1, i - 1, j, m, n))
                    return true;
            if(i <  m - 1 && board[i + 1][j] == word.charAt(pos))
                if(trace(board, word, pos + 1, i + 1, j, m, n))
                    return true;
            board[i][j] = c;
            return false;
        }
    }

}
