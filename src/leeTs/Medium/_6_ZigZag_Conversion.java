package leeTs.Medium;

public class _6_ZigZag_Conversion {
	public static void main(String[] args) {
		String input = new String("Ilovecoding!");
		String output = convert(input, 2);
		System.out.println(output);
	}
	
	public static String convert(String s, int numRows) {
		if(1 == numRows){
			return s;
		}
		else {
			StringBuffer result = new StringBuffer();
			
			for(int j = 0; j < s.length(); j += 2 * numRows - 2) { //deal with the first row
				result.append(s.charAt(j));
			}
			
			for(int row = 2;row < numRows;row ++) { //deal with the middle rows
				int i = 0; //// divide to two equal-difference array
				for(int j = row - 1; j < s.length(); j += 2 * numRows - 2) {
					result.append(s.charAt(j));
					i = j + 2 * (numRows - row);
					if(i < s.length())
						result.append(s.charAt(i));
				}
			}
			
			for (int j = numRows - 1; j < s.length(); j += 2 * numRows - 2) { //deal with the last line
				result.append(s.charAt(j));
			}
			
			return result.toString();
		}
		
	}
}
