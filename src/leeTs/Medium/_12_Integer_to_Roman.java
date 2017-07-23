package leeTs.Medium;

public class _12_Integer_to_Roman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String intToRoman(int num) {// note that the range of num is [0, 3999], which makes it more easy
        char[] rome = "MDCLXVI".toCharArray();
		int[] base = {1000, 500, 100, 50, 10, 5, 1};
		int factor = 0;
		StringBuilder result = new StringBuilder();
		for(int i = 0; i <= 6; i += 2) {
			factor = num / base[i];
		    if(factor < 4)
		        while(factor -- > 0)
		            result.append(rome[i]);
		    else
		        if(4 == factor)
		            result.append(rome[i] + "" + rome[i - 1]);
		        else
		            if(factor < 9) {
		                result.append(rome[i - 1] + "");// remember the append() of StringBuilder!
		                factor -= 5;
		                while(factor -- > 0)
		                    result.append(rome[i]);
		            }
		            else
		                result.append(rome[i] + "" + rome[i - 2]);
		    num %= base[i];
		}
		return result.toString();
    }

}
