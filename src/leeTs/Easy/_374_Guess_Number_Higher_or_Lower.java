package leeTs.Easy;

public class _374_Guess_Number_Higher_or_Lower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = guessNumber(2);
	}
	
	public static int guess(int n) {// "My number" means the number to be guessed
		return 1;
	}
	
	public static int guessNumber(int n) {// mistaken the meaning of the question
		int gus = n / 2 + 1;
		int ground = 1;
		int ceiling = n;
		int result = 0;
		while(0 != (result = guess(gus))) {
			if(result > 0)
				ceiling = gus - 1;
			else
				ground = gus + 1;
			gus = ground + (ceiling - ground) / 2;
		}
		return gus;
	}

}
