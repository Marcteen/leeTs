package leeTs.Easy;

public class _476_Number_Compliment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int findComplement(int num) {
        if(num == 0)
            return 1;
        int rest = num;
        int count = 0;
        while(rest > 0) {
            rest >>>= 1;// rightly shift ignoring the symbol bit
            count ++;
        }
        int whole = (int)(Math.pow(2, count) - 1);// minus 1 first can prevent 2^31 overflow int type!!!
        return whole - num;
    }
	
	public int findComplementNeat(int num) {
        return ~num & ((Integer.highestOneBit(num) << 1) - 1);
    }

}
