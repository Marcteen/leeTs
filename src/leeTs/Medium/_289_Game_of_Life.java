package leeTs.Medium;

public class _289_Game_of_Life {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] input = new int[1][2];
		gameOfLife(input);
	}
	public static void gameOfLife(int[][] board) {
        if(null == board || 0 == board.length || 0 == board[0].length)
            return;
        int m = board.length, n = board[0].length, count = 0;
        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j ++) {
                count = countNeighbor(board, i, j);
                if(board[i][j] == 1){
                    if(count < 2 || count > 3)
                        board[i][j] = 2;
                        
                }
                else if(board[i][j] == 0)
                    if(count == 3)
                        board[i][j] = -1;
            }
        }
        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j ++) {
                if(board[i][j] == 2)
                    board[i][j] = 0;
                else if(board[i][j] == -1)
                    board[i][j] = 1;
            }
        }
    }
    public static int countNeighbor(int[][] board, int i, int j) {
        int m = board.length, n = board[0].length;
        int count = 0;
        if(i > 0) {
            if(j > 0 && board[i - 1][j - 1] > 0)
                count ++;
            if(board[i - 1][j] > 0)
                count ++;
            if(j < n - 1 && board[i - 1][j + 1] > 0)
                count ++;
        }
        if(j > 0 && board[i][j - 1] > 0)
            count ++;
        if(j < n - 1 && board[i][j + 1] > 0)
            count ++;
        if(i < m - 1) {
            if(j > 0 && board[i + 1][j - 1] > 0)
                count ++;
            if(board[i + 1][j] > 0)
                count ++;
            if(j < n - 1 && board[i + 1][j + 1] > 0)
                count ++;
        }
        return count;
    }
}
