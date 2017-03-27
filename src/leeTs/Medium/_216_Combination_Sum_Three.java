package leeTs.Medium;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
public class _216_Combination_Sum_Three {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a = new ArrayList<>();
	}
	/*no much trick, just a regular and near procedure*/
	public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new LinkedList<>();
        getCombination(k, n, 0, 1, result, new ArrayList<Integer>(3));
        return result;
    }
    public static void getCombination(int k, int n, int sum, int start, List<List<Integer>> result, List<Integer> combine) {
        if(combine.size() == k) {
            if(sum == n)
                result.add(new ArrayList<Integer>(combine));
        }
        else {
            for(int i = start; i <= 9; i ++) {
                combine.add(i);
                getCombination(k, n, sum + i, i + 1, result, combine);
                combine.remove(combine.size() - 1);
            }
        }
    }
}
