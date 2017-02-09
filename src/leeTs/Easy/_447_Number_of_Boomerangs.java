package leeTs.Easy;

import java.util.ArrayList;
import java.util.HashMap;

public class _447_Number_of_Boomerangs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] input = {{0, 0}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		int result = numberOfBoomerangsNaive(input);// Integer doesn't support "reference passing like int"
		System.out.println(result);
		
	}
	
	public static int getDistance(int[] foo, int[] bar) {
        int distance = 0;
        for(int i = 0; i < foo.length; i ++) {
            distance += (int)Math.pow(foo[i] - bar[i], 2);
        }
        // distance = (int)Math.sqrt(distance); //Disaster, sqrt() generate float definitely but the integer conversion destroy it!! And it is unnecessary
        return distance;
    }

	
	public static int numberOfBoomerangs(int[][] points) {
		int result = 0;
		HashMap<Integer, Integer> track = new HashMap<>();
		int distance = 0;
		for(int i = 0; i < points.length; i ++) {
			for(int j = 0; j < points.length; j ++)
				if(i == j)
					continue;
				else {
					distance = getDistance(points[i], points[j]);
					if(track.containsKey(distance))// calculate the distance from each j to i, the HashMap will track each distances's entry
						track.put(distance, track.get(distance) + 1);
					else
						track.put(distance, 1);
				}
			for(int key : track.values())
				result += key * (key - 1); // choose two from each group and order matters, this conduct to a permutation formula.
			track.clear();
		}
		return result;
	}
	
	public static int numberOfBoomerangsNaive(int[][] points) {// way too slow!
        ArrayList<int[]> taken = new ArrayList<>();
        return getFit(points, 0, 3, taken);
    }
    
    public static int getFit(int[][] points, int head, int count, ArrayList<int[]> taken) {
        int num = 0;
    	if(0 == count) {
            for(int i = 0; i < taken.size(); i ++) {
                if(getDistance(taken.get(i), taken.get((i + 1) % taken.size())) == getDistance(taken.get(i), taken.get((i + 2) % taken.size())))
                    num += 2;
            }
            for(int i = 0; i < taken.size(); i ++)
            	System.out.println(taken.get(i)[0] + ", " + taken.get(i)[1]);
            System.out.println("get :" + num);
        }
        else{
            for(int i = head; i < points.length; i ++) {
                taken.add(points[i]);
                num += getFit(points, i + 1, count - 1, taken);// don't write i + 1 as head + 1!!!!!
                taken.remove(taken.size() - 1);
            }
        }
    	return num;
    }
}
