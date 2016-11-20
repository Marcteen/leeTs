package leeTs.Easy;
import java.util.List;
import java.util.ArrayList;
public class _118_Pascal_s_Triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> curResult = new ArrayList<>();
		List<Integer> lastResult = new ArrayList<>();
		if(0 == numRows) {
			return result;
		}
		else {
			curResult.add(1);
			result.add(new ArrayList(curResult));
			for(int i = 1; i < numRows; i ++) {
				curResult.clear();
				curResult.add(1);
				for(int j = 1; j < i; j ++) {
					lastResult = result.get(i - 1);
					curResult.add(lastResult.get(j - 1) + lastResult.get(j));
				}
				curResult.add(1);
				result.add(new ArrayList(curResult));
			}
		}
		return result;
	}
	
	public List<List<Integer>> generateCompact(int numRows) {
		List<List<Integer>> allrows = new ArrayList<List<Integer>>();
    	ArrayList<Integer> row = new ArrayList<Integer>();
    	for(int i = 0; i < numRows; i++)
    	{
    		row.add(0, 1); // noted that the new element is insert at the head
    		for(int j = 1; j < row.size() - 1; j++)
    			row.set(j, row.get(j) + row.get(j+1));
    		allrows.add(new ArrayList<Integer>(row));
    	}
    	return allrows;
	}
}
