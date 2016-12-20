package leeTs.Easy;
import java.util.Set;
import java.util.HashSet;
public class _217_Contains_Duplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean containsDuplicate(int[] nums) {
		HashSet<Integer> record = new HashSet<>();
		for(int i : nums) {
			if(!record.add(i))
				return true;
		}
		return false;
	}
	
}
