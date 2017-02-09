package leeTs.Easy;

public class _345_Reverse_Vowels_of_a_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String reverseVowels(String s) {
		char[] result = s.toCharArray();
		String vowels = "AEIOUaeiou";
		char temp = 0;
		for(int front = 0, back = result.length - 1; front < back; front ++, back --) {
			while(front < back && !vowels.contains(result[front] + ""))
				front ++;
			while(back > front && !vowels.contains(result[back] + ""))
				back --;
			temp = result[front];
			result[front] = result[back];
			result[back] = temp;
		}
		return String.valueOf(result);
	}
	
}
