package leeTs.Easy;

public class _165_Compare_Version_Numbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	public static int compareVersion(String version1, String version2) {
		int i = 0;
		int j = 0;
		int value1 = 0;
		int value2 = 0;
		char char1 = 0;
		char char2 = 0;
		while(true) {
			while(i < version1.length() && '.' != version1.charAt(i)) {
				value1 *= 10;
				value1 += (version1.charAt(i) - '0');
				i ++;
			}
			while(j < version2.length() && '.' != version2.charAt(j)) {
				value2 *= 10;
				value2 += (version2.charAt(j) - '0');
				j ++;
			}
			if(value1 > value2)
				return 1;
			else
				if(value1 < value2)
					return -1;
				else{
					if(i >= version1.length() && j >= version2.length())
						return 0;
					else {
						value1 = 0;
						value2 = 0;
						j ++;
						i ++;
					}
						
				}
		}
	}
}
