package leeTs.Easy;

public class _292_Nim_Game {// It doesn't require to take the last stone by itself.

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/* if the first player can avoid the multiple of
	 * 4, he will will. Because he will always have a
	 * way to avoid the multiple of 4(take 1 - 3 stones), which is a dead
	 * for up coming competitor.*/
	public boolean canWinNim(int n) {
		return (n % 4) != 0;
	}
}
