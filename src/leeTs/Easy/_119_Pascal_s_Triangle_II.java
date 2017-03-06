package leeTs.Easy;
import java.util.ArrayList;
import java.util.List;
public class _119_Pascal_s_Triangle_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> getRow(int rowIndex) {
		List<Integer> result = new ArrayList<>();
		for(int i = 0; i <= rowIndex; i ++)
			result.add(1);
		int numRuns = rowIndex - 1;
		for(int i = 1; i <= numRuns; i ++)
			for(int j = rowIndex - i; j < rowIndex; j ++) {
				 result.set(j, result.get(j) + result.get(j + 1));
			}
		return result;
	}
}
