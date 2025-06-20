
/*
Time Complexity - O(NL + ML) - N is the length of Dict and M is the length of sentence and L is length of every words
Spcae Complexity - O(N * L)
*/
//class TrieNode{
//    boolean isEnd;
//    TrieNode [] children;
//    TrieNode(){
//        this.children = new TrieNode[26];
//    }
//}
public class LongestWord_in_Dictionary_LC_720 {
    String max="";
    public String longestWord(String[] words) {
        TrieNode root = new TrieNode();
        for(String word: words) {
            insert(word, root);
        }
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return max;
    }

    private void insert(String word, TrieNode root) {
        TrieNode curr = root;

        for(int i = 0; i<word.length(); i++) {
            char ch = word.charAt(i);
            if(curr.children[ch-'a'] == null) {
                curr.children[ch-'a'] = new TrieNode();
            }
            curr = curr.children[ch-'a']; // move to next children
        }
        curr.isEnd = true;
    }

    private void dfs(TrieNode root, StringBuilder sb) {
        //base case
        if(sb.length() > max.length()) {
            max = sb.toString();
        }

        //logic
        //iterate all 26 nodes to check present node
        for(int i = 0; i<26;i++) {
            if(root.children[i] != null && root.children[i].isEnd) { //word found checkthe length
                //action
                int len = sb.length();
                char ch =(char)(i+'a');
                sb.append(ch);
                //recurse
                dfs(root.children[i],sb);
                //backtrack
                sb.setLength(len);
            }
        }
    }
}
