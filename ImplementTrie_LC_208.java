/*
Time Complexity - All Three functions are O(l) where l is length of string
Space Complexity - O(1)
*/
public class ImplementTrie_LC_208 {
    class TrieNode{
        boolean isEnd;
        TrieNode [] children;
        TrieNode() {

            this.children = new TrieNode[26];
        }
    }
    private TrieNode root; // inital root
    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root; //curr is used to traverse down the path, do not manipulate the root.
        //iterate over the string
        for(int i = 0; i<word.length(); i++) {
            char ch = word.charAt(i);
            //check if current trienode has child ch
            if(curr.children[ch-'a'] == null) {
                //insert child node if null
                curr.children[ch-'a'] = new TrieNode();
            }
            curr = curr.children[ch-'a']; //move current to child
        }
        curr.isEnd = true; //at end of word mark isEnd true
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(curr.children[ch-'a'] == null){
                return false;
            }
            curr = curr.children[ch-'a']; //keep moving current to children
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if(curr.children[ch-'a'] == null){
                return false;
            }
            curr = curr.children[ch-'a'];
        }
        return true;
    }
}
