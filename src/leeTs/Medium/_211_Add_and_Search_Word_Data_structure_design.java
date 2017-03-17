package leeTs.Medium;

public class _211_Add_and_Search_Word_Data_structure_design {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*Well actually this node's char is store at its parent's pointer*/
	class TrieNode {
        boolean isTail;
        TrieNode[] childs;
        TrieNode() {
            childs = new TrieNode[26];
        }
    }
    
    TrieNode root;
    /** Initialize your data structure here. */
    public _211_Add_and_Search_Word_Data_structure_design() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode curNode = root;
        int diff = 0;
        for(char c : word.toCharArray()) {
            diff = c - 'a';
            if(null == curNode.childs[diff])
                curNode.childs[diff] = new TrieNode();
            curNode = curNode.childs[diff];
        }
        curNode.isTail = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchDot(word.toCharArray(), 0, root);
    }
    
    public boolean searchDot(char[] chars, int curIndex, TrieNode root) {
    	//reach the end, no char to be find in this node
        if(curIndex == chars.length)
            return root.isTail;
        else {
            if('.' != chars[curIndex])
                return null != root.childs[chars[curIndex] - 'a'] && searchDot(chars, curIndex + 1, root.childs[chars[curIndex] - 'a']);
            else {
                for(int i = 0; i < 26; i ++) {
                    if(null != root.childs[i] && searchDot(chars, curIndex + 1, root.childs[i]))
                        return true;
                }
            }
        }
        return false;
    }

}
