package leeTs.Medium;

public class _96_Unique_Binary_Search_Trees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//it is not the rang matters, it is only number of numbers matters !!!
	/*Let t(n) donates the number of unique BST given 1 ~ n, and them
    must consist of tree with root nodes 1 ~ n, so we can get t(n) by
    sum each of them's number up. For example, give n = 3, we have
    1(zero left, 2 left) , 2(1 left, 1 right), 3(2 left, 0 right).
    let t(0) = t(1) = 1, so t(3) = t(0) * t(2) + t(1) * t(1) + t(2) * t(0),
    this is how we use dp !!!*/
    public int numTrees(int n) {
        int[] result = new int[n + 2];// in case that n = 0 and 1
        result[0] = 1;
        result[1] = 1;
        int sum = 0;
        for(int i = 2; i <= n; i ++) {
            sum = 0;
            for(int j = 0; j < i; j ++)
                sum += result[j] * result[i - j - 1];
            result[i] = sum;
        }
        return result[n];
    }
}
