package leeTs.Easy;
import java.util.ArrayDeque;

public class _168_Excel_Sheet_Column_Title {// StringBuffer can append() a charactor

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input = 27;
		String result = convertToTitle(input);
	}

	public static String convertToTitle(int n) {
		StringBuffer result = new StringBuffer();
		while(n > 0) {
			result.insert(0, (char)(n % 26 + 'A' - 1));
			n /= 26;
		}
		return result.toString();
	}
	
}
