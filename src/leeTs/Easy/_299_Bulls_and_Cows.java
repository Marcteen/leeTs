package leeTs.Easy;

public class _299_Bulls_and_Cows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String getHint(String secret, String guess) {
		int A = 0;
		int B = 0;
		int[] candidates = new int[10];
		int secretDigit = 0;
		int guessDigit = 0;
		for(int i = secret.length() - 1; i >= 0; i --) {
			if(secret.charAt(i) == guess.charAt(i))
				A ++;
			else {
				secretDigit = secret.charAt(i) - '0';
				guessDigit = guess.charAt(i) - '0';
				if(candidates[guessDigit] > 0)
					B ++;
				if(candidates[secretDigit] < 0)
					B ++;
				candidates[guessDigit] --;// get prepared for the following digits
				candidates[secretDigit] ++;
			}
		}
		//return String.format("%dA%dB", A, B);// too slow!
		return A + "A" + B + "B";// much faster!
	}
	
}
