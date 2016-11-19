package leeTs.Easy;

public class _38_Count_and_Say {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String result = countAndSay(3);
	}

	public static String countAndSay(int n) {
		String cur = "1";
		int count = 1;
		char last = 0;
		for(int i = 1; i < n; i ++) {
			StringBuffer temp = new StringBuffer();
			last = cur.charAt(0);
			for(int j = 1; j < cur.length(); j++) {
				if(cur.charAt(j) == last)
					count ++;
				else {
					temp.append((char)('0' + count));
					temp.append(last);
					last = cur.charAt(j);
					count = 1;
				}
			}
			temp.append((char)('0' + count));
			temp.append(last);
			cur = temp.toString();
			count = 1;
		}
		return cur;
	}
}
