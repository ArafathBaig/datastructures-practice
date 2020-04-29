package Trie;

import java.util.ArrayList;
import java.util.List;

public class Tries {
    public static void main(String[] args) {

        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.query("app"));


    }
}

class Trie{
    TrieNode root;

    public Trie(){
        this.root = new TrieNode();
    }

    public int query(String s) {
        TrieNode current = root;
        for (int i = 0; i < s.length(); i++) {
            if(current == null){
                return 0;
            }
            current =  current.next(s.charAt(i));
        }
        if(current != null)
        return current.terminating;
        else
            throw new RuntimeException("String is not available");
    }

    public void insert(String s){
        TrieNode current = root;
        for(int i = 0; i < s.length();i++){
            if(current.trieNodes[s.charAt(i)- 'a'] == null){
                current.trieNodes[s.charAt(i) - 'a'] = new TrieNode();
            }

            current = current.next(s.charAt(i));
        }
        current.terminating++;
    }

    public void delete(String s){
        TrieNode current = root;
        for (int i = 0; i < s.length(); i++) {
            if(current == null){
                return;
            }
            current =  current.next(s.charAt(i));
        }
        if(current.terminating != 0)
            current.terminating--;
        else
            throw new RuntimeException("String does not exist");
    }

    public void update(final String absolete, final String updated){
        delete(absolete);
        insert(updated);
    }
}

class TrieNode {

    int terminating;
     TrieNode[] trieNodes = new TrieNode[26];

    public TrieNode next(char c){
        return trieNodes[c-'a'];
    }


}
