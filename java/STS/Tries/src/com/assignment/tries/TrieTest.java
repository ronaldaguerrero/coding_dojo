package com.assignment.tries;

import java.util.Set;

public class TrieTest {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insertWord("car");
        trie.insertWord("card");
        trie.insertWord("chip");
        trie.insertWord("trie");
        trie.insertWord("try");
//        trie.isWordValid("try");
//        trie.printAllKeys();
        
//        get first HashMap key(s):
//        Set<Character> keys = trie.root.children.keySet();
//        for(Character key : keys) {
//        	System.out.println(key);
        
//        get children key(s) of specific HashMap:
        Set<Character> keys = trie.root.children.get('c').children.keySet();
	        for(Character key : keys) {
	        	System.out.println(key);
        }
    }
}