package leeTs.Easy;

public class _36_Valid_Sudoku {

	public static void main(String[] args) {
		char[][] input = new char[9][9];
		input[0] = "..4...63.".toCharArray();
		input[1] = ".........".toCharArray();
		input[2] = "5......9.".toCharArray();
		input[3] = "...56....".toCharArray();
		input[4] = "4.3.....1".toCharArray();
		input[5] = "...7.....".toCharArray();
		input[6] = "...5.....".toCharArray();
		input[7] = ".........".toCharArray();
		input[8] = ".........".toCharArray();
		boolean result = isValidSudoku(input);
			
	}

	public static boolean isValidSudoku(char[][] board) {
		int[] isSpot = new int[10];
		for(int i = 0; i < 10; i ++)
			isSpot[i] = -1;
		for(int i = 0; i < 9; i ++) {// search the row
			for(int j = 0; j < 9; j ++) {
				if('.' != board[i][j])
					if(isSpot[board[i][j] - '0'] != i) //use  relatively steady i as flag
						isSpot[board[i][j] - '0'] = i;
					else
						return false;
			}
		}
		for(int i = 0; i < 9; i ++) {// search the column
			for(int j = 0; j < 9; j ++) {
				if('.' != board[j][i])
					if(isSpot[board[j][i] - '0'] != i + 10) //use  relatively steady i as flag
						isSpot[board[j][i] - '0'] = i + 10;
					else
						return false;
			}
		}
		for(int i = 0; i < 7; i += 3) {
			for (int j = 0; j < 7; j += 3) {
				for(int a = 0; a < 3; a ++) {
					for(int b = 0; b < 3; b ++) {
						if('.' != board[i + a][j + b])
							if(isSpot[board[i + a][j + b] - '0'] !=   j + 100 * i) //use i0j as flag
								isSpot[board[i + a][j + b] - '0'] = j + 100 * i; // using 100 is faster than 1000!
							else
								return false;
					}
				}
			}
		}
		return true;
	}
}
