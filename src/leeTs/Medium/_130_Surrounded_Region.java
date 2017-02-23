package leeTs.Medium;

import java.util.LinkedList;

public class _130_Surrounded_Region {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//Both recursive DFS and iterative BFS implemented
	public void solve(char[][] board) {
        if(null == board || board.length < 3 || board[0].length < 3)
            return;
        int m = board.length, n = board[0].length;
        
        for(int j = 0; j < n; j ++) {
            if(board[0][j] == 'O')
                edgeZeroMasking(board, 0, j, m, n);
            if(board[m - 1][j] == 'O')
                edgeZeroMasking(board, m - 1, j, m, n);
        }
        for(int i = 0; i < m; i ++) {
            if(board[i][0] == 'O')
                edgeZeroMasking(board, i, 0, m, n);
            if(board[i][n - 1] == 'O')
                edgeZeroMasking(board, i, n - 1, m, n);
        }
        
        for(int i = 0; i < m; i ++)
            for(int j = 0; j < n; j ++)
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                else if(board[i][j] == '*')
                    board[i][j] = 'O';
    }
	public void edgeZeroMaskingBFS(char[][] board, int i, int j, int m, int n) {
        board[i][j] = '*';
        LinkedList<Integer> iQueue = new LinkedList<>();
        LinkedList<Integer> jQueue = new LinkedList<>();
        iQueue.offer(i);
        jQueue.offer(j);
        while(!iQueue.isEmpty()) {
            i = iQueue.poll();
            j = jQueue.poll();
            if(i > 0 && board[i - 1][j] == 'O') {
                board[i - 1][j] = '*';
                iQueue.offer(i - 1);
                jQueue.offer(j);
            }
            if(i < m - 1 && board[i + 1][j] == 'O') {
                board[i + 1][j] = '*';
                iQueue.offer(i + 1);
                jQueue.offer(j);
            }
            if(j > 0 && board[i][j - 1] == 'O') {
                board[i][j - 1] = '*';
                iQueue.offer(i);
                jQueue.offer(j - 1);
            }
            if(j < n - 1 && board[i][j + 1] == 'O') {
                board[i][j + 1] = '*';
                iQueue.offer(i);
                jQueue.offer(j + 1);
            }
        }
        
    }
    //exclude the bound can avoid it from over flow
    public void edgeZeroMasking(char[][] board, int i, int j, int m, int n) {
        board[i][j] = '*';
        if(i > 1 && board[i - 1][j] == 'O')
            edgeZeroMasking(board, i - 1, j, m, n);
        if(i < m - 2 && board[i + 1][j] == 'O')
            edgeZeroMasking(board, i + 1, j, m, n);
        if(j > 1 && board[i][j - 1] == 'O')
            edgeZeroMasking(board, i, j - 1, m, n);
        if(j < n - 2 && board[i][j + 1] == 'O')
            edgeZeroMasking(board, i, j + 1, m, n);
    }
}
