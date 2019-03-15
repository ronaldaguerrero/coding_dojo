package com.assignment.tries;

import java.util.HashMap;

public class Trie {
    public Node root;
    
    public Trie() {
        this.root = new Node();
    }
    
    public void insertWord(String word) {
        // gets the root node:
        Node currentNode = this.root;
        
        // iterates over every character in the word(input):
        for(int i = 0; i < word.length(); i++) {
            // currentLetter is just the character / letter at the iteration:
            Character currentLetter = word.charAt(i);
            // ask if the current letter is in the map of the current node:
            Node child = currentNode.children.get(currentLetter);
            if(child == null) {
            	// created node:
                child = new Node();
                currentNode.children.put(currentLetter, child); 
            } 
            // found node:
            currentNode = child;
        }
        currentNode.isCompleteWord = true;
    }
    
    public boolean isPrefixValid(String prefix){
    	if(searchNode(prefix) == null) 
            return false;
        else
            return true;
    }
    
    public boolean isWordValid(String word) {
    	if(searchNode(word) == null) 
            return false;
        else
        	return true;
    }

	private Node searchNode(String input) {
		HashMap<Character, Node> children = root.children; 
        Node t = null;
        for(int i=0; i < input.length(); i++){ // to access each character of the input
            char c = input.charAt(i); // stores i inside c
            if(children.containsKey(c)){ // checks children HashMap if it contains c 
                t = children.get(c); // stores c in t 
                children = t.children; // moves HashMap down trie
            }else{
            	System.out.println(false);
            	return null;
            }
        }
        System.out.println(true);
        return t;
    }
	
	public void printAllKeys() { // only printing keySet from first node...
		HashMap<Character, Node> children = root.children;
			for (Character c : children.keySet()) {
				System.out.println(c);
			}
		}
 	
}