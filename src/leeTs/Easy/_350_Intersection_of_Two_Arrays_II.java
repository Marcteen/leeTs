package leeTs.Easy;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.ArrayList;

public class _350_Intersection_of_Two_Arrays_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1};
		int[] nums2 = {1, 1};
		int[] result = intersect(nums1, nums2);
	}

	public static int[] intersect(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map1 = new HashMap<>();
		HashMap<Integer, Integer> map2 = new HashMap<>();
		HashSet<Integer> set2 = new HashSet<>();
		for(int num : nums1) {
			if(map1.containsKey(num)) 
				map1.put(num, map1.get(num) + 1);
			else
				map1.put(num, 1);
		}
		for(int num : nums2) {
			if(map2.containsKey(num))
				map2.put(num, map2.get(num) + 1);
			else
				map2.put(num, 1);
		}
		int length = 0;
		for(int num : map2.keySet()) {
			if(map1.containsKey(num)) {
				set2.add(num);
				length += Math.min(map1.get(num), map2.get(num));
			}
		}
		int[] result = new int[length];
		int index = 0;
		for(int num : set2) {
			for(int i = Math.min(map1.get(num), map2.get(num)); i > 0; i --)
				result[index ++] = num;
		}
		return result;
	}
	
	public int[] intersectOrderly(int[] nums1, int[] nums2) {
		ArrayList<Integer> result = new ArrayList<>();
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		for(int i = 0, j = 0; i < nums1.length && j < nums2.length;) {
			if(nums1[i] > nums2[j])
				j ++;
			else
				if(nums1[i] < nums2[j])
					i ++;
				else {
					result.add(nums1[i]);
					i ++;
					j ++;
				}
		}
		int[] intersection = new int[result.size()];
		for(int i = 0; i < intersection.length; i ++)
			intersection[i] = result.get(i);
		return intersection;
	}
	
}
