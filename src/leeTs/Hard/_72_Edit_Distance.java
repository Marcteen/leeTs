package leeTs.Hard;

public class _72_Edit_Distance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length(), delete = 0, insert = 0, replace = 0;
        //we must use the exclude index to the editDistance array to cover the "empty string to sth"!!!
        int[][] editDistance = new int[word1.length() + 1][word2.length() + 1];
        // no early reference for them, so initialize here
        for(int i = 0; i <= len1; i ++)
            editDistance[i][0] = i;
        for(int i = 0; i <= len2; i ++)
            editDistance[0][i] = i;
        for(int i = 0; i < len1; i ++) {
            for(int j = 0; j < len2; j ++) {
                if(word1.charAt(i) == word2.charAt(j))
                    //no other edit cost because of the equal
                    editDistance[i + 1][j + 1] = editDistance[i][j];
                else {
                    /*delete the words.charAt(i) to make they equal,
                    so what we need here is the cost of words1[0, i - 1] to words2[0, j]*/
                    delete = editDistance[i][j + 1];
                    /*append a word to words1 to make word1.charAt(i + 1) equals to
                    word2.charAt(j), so we need cost from words1[0, i] to words2[0, j - 1]*/
                    insert = editDistance[i + 1][j];
                    /*make word1.charAt(i) equals to word2.charAt(j), we need word1[0, i - 1] to word2[0, j - 1]*/
                    replace = editDistance[i][j];
                    editDistance[i + 1][j + 1] = Math.min(delete, Math.min(insert, replace)) + 1;
                }
            }
        }
        return editDistance[len1][len2];
    }

}
