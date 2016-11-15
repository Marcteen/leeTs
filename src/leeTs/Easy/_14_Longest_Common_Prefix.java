package leeTs.Easy;

public class _14_Longest_Common_Prefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static String longestCommonPrefix(String[] strs) {
		if(0 == strs.length)
			return "";
		else {
			StringBuffer result = new StringBuffer();
			for(int i = 0;i < strs[0].length();i++) {
				for(int j = 1;j < strs.length; j ++) {
					if (i < strs[j].length()) {
						if(strs[j].charAt(i) != strs[0].charAt(i)) // find the first different char at the i
							return result.toString();
					}
					else
						return result.toString(); // the shortest
				}
				result.append(strs[0].charAt(i));// means no various char find at i
			}
			return result.toString();
		}
	}

}
