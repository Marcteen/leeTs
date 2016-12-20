package leeTs.Easy;

public class _205_Isomorphic_Strings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean result = isIsomorphic(new String("sdf"), new String("dsf"));
	}

	public static boolean isIsomorphic(String s, String t) {
		char[] mapS2T = new char[256];// The default value is zero
		char[] mapT2S = new char[256];
		int unMatched = 256;
		for(int i = 0; unMatched > 0 && i < s.length(); i ++) {
			if(0 == mapS2T[s.charAt(i)]) {
				mapS2T[s.charAt(i)] = t.charAt(i);
				unMatched --;
			}
			else
				if(mapS2T[s.charAt(i)] != t.charAt(i))
					return false;
			if(0 == mapT2S[t.charAt(i)])
				mapT2S[t.charAt(i)] = s.charAt(i);
			else
				if(mapT2S[t.charAt(i)] != s.charAt(i))
					return false;
		}
		return true;
	}
}
