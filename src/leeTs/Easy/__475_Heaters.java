package leeTs.Easy;
import java.util.Arrays;

public class __475_Heaters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = -2;
		System.out.println(Integer.toBinaryString(a) + " " + Integer.toBinaryString(a >> 1) + " " + Integer.toBinaryString(a >>> 4));		
	}

	public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        
        int i = 0, j = 0, res = 0;
        while (i < houses.length) {
            while (j < heaters.length - 1
                && Math.abs(heaters[j + 1] - houses[i]) <= Math.abs(heaters[j] - houses[i])) {// find the location, in order it is very neat
                j++;
            }
            res = Math.max(res, Math.abs(heaters[j] - houses[i]));
            i++;
        }
        
        return res;
    }
	
}
