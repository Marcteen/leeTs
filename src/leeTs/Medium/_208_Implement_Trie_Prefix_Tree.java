package leeTs.Medium;

import java.util.HashMap;

public class _208_Implement_Trie_Prefix_Tree {
/*In constuctor, don't mistake memeber variable with local variable declaration!!*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_208_Implement_Trie_Prefix_Tree tree = new _208_Implement_Trie_Prefix_Tree();
		tree.search("a");
}
/*["Trie","search"]
[[],["a"]], this means it news a trie tree first and searches "a"*/
	class TrieNode {
        public char val;
        public HashMap<Character, TrieNode> childs;
        public TrieNode(char c) {
            val = c;
            childs = new HashMap<>();
        }
    }
    
    TrieNode root;
    /** Initialize your data structure here. */
    public _208_Implement_Trie_Prefix_Tree() {
        // the root node does not store any char
        TrieNode root = new TrieNode('a');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(null == word || word.length() == 0)
            return;
        TrieNode cur = root;
        for(char c : word.toCharArray()) {
            if(!cur.childs.containsKey(c))
                cur.childs.put(c, new TrieNode(c));
            cur = cur.childs.get(c);
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(null == word || word.length() == 0)
            return false;
        TrieNode cur = root;
        for(char c : word.toCharArray()) {
            if(!cur.childs.containsKey(c))
                return false;
            cur = cur.childs.get(c);
        }
        return cur.childs.isEmpty();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(null == prefix || prefix.length() == 0)
            return false;
        TrieNode cur = root;
        for(char c : prefix.toCharArray()) {
            if(!cur.childs.containsKey(c))
                return false;
            cur = cur.childs.get(c);
        }
        return true;
    }
}
