package leeTs.Easy;
import java.util.List;
import java.util.ArrayList;

public class _412_Fizz_Buzz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer j =  new Integer(16);
		int k = 2 * 8;
		System.out.println( j == k ? "Yes" : "No");
	}

	public List<String> fizzBuzz(int n) {
		int three = 0;
		int five = 0;
		ArrayList<String> result = new ArrayList<>();
		for(int i = 1; i <= n ; i ++) {
			if(3 ==  ++ three)
				three = 0;
			if(5 == ++ five)
				five = 0;
			if(0 == three)
				if(0 == five)
					result.add("FizzBuzz");
				else
					result.add("Fizz");
			else
				if(0 == five)
					result.add("Buzz");
				else
					result.add(i + "");		
		}
		return result;
	}
}
