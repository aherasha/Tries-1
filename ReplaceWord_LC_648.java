/*
Time Complexity - O(NL + ML) - N is the length of Dict and M is the length of sentence and L is length of every words
Spcae Complexity - O(N * L)
*/

import java.util.List;

class TrieNode{
    boolean isEnd;
    TrieNode [] children;
    TrieNode() {
        this.children = new TrieNode[26];
    }
}
public class ReplaceWord_LC_648 {
    private TrieNode root;
    public String replaceWords(List<String> dictionary, String sentence) {
        this.root = new TrieNode();
        StringBuilder result = new StringBuilder();
        for(String word: dictionary) {
            insert(word);
        }
        String [] strArr = sentence.split(" ");

        for(String word : strArr) {
            //Search for replacement
            StringBuilder replacement = new StringBuilder();
            TrieNode curr = root;
            for(int i = 0; i<word.length(); i++) { //cattle
                char ch = word.charAt(i);
                if(curr.children[ch-'a'] == null || curr.isEnd){
                    break;
                }
                replacement.append(ch);
                curr = curr.children[ch-'a'];
            }
            if(curr.isEnd) {
                result.append(replacement.toString());
            } else {
                result.append(word);
            }
            result.append(" ");
        }
        return result.toString().trim();

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
}