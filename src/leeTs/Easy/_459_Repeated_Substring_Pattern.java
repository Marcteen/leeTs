package leeTs.Easy;

public class _459_Repeated_Substring_Pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "aba";
		boolean result = repeatedSubstringPattern(input);
		
	}
	
	public static boolean repeatedSubstringPattern(String str) {
        int length = str.length();
        int factor = length / 2;
        int rest = 0;
        while(factor > 0) {
            if(length % factor == 0) {
                rest = length / factor;
                String brick = str.substring(0, factor);
                StringBuilder refactor = new StringBuilder();
                for(int i = 0; i < rest ; i ++)
                	refactor = refactor.append(brick);// connect the potential brick, use builder here is much faster than cancating string !!
                if(refactor.toString().equals(str))// must be the same kind of object to be compared.
                    return true;
                else
                	factor -= 1;
            }
            else
                factor -= 1;
        }
        return false;
    }


}
