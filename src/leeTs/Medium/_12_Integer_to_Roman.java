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
		for(int index = 0; index <= 6; index += 2) {
			factor = num / base[index];
		    if(factor < 4)
		        while(factor -- > 0)
		            result.append(rome[index]);
		    else
		        if(4 == factor)
		            result.append(rome[index] + "" + rome[index - 1]);
		        else
		            if(factor < 9) {
		                result.append(rome[index - 1] + "");// remember the append() of StringBuilder!
		                factor -= 5;
		                while(factor -- > 0)
		                    result.append(rome[index]);
		            }
		            else
		                result.append(rome[index] + "" + rome[index - 2]);
		    num %= base[index];
		}
		return result.toString();
    }

}
