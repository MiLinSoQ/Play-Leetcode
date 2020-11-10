 /**
	Url: https://leetcode.com/problems/design-add-and-search-words-data-structure/
	Author: MiLinSoQ
	Time: 2020-11-10
	Title: Design Add and Search Words Data Structure
	No: 211
*/

import java.util.TreeMap;

/**
	實作一個 WordDictionary class，提供一些方法，與 Trie 類似
	addWord		-> 丟入元素。
	search		-> 搜尋是否有這個元素。
	
	search 傳入的 String 遇到，String 中有 '.' 及代表任何字母。
	
	
	EX:
		WordDictionary wordDictionary = new WordDictionary();
		wordDictionary.addWord("bad");
		wordDictionary.addWord("dad");
		wordDictionary.addWord("mad");
		wordDictionary.search("pad"); 	// return False
		wordDictionary.search("bad"); 	// return True
		wordDictionary.search(".ad"); 	// return True
		wordDictionary.search("b.."); 	// return True
*/
public class Solution {
	
	public static void main(String args[]) {
		WordDictionary dict = new WordDictionary();
		dict.addWord("bad");
		dict.addWord("dad");
		dict.addWord("mad");
		
		
		System.out.println(String.format("Has [ pad ]: %b", dict.search("pad")));
		System.out.println(String.format("Has [ bad ]: %b", dict.search("bad")));
		System.out.println(String.format("Has [ .ad ]: %b", dict.search(".ad")));
		System.out.println(String.format("Has [ b.. ]: %b", dict.search("b..")));
		
		// Trie trie = new Trie();
		// trie.insert("apple");
		
		// System.out.println(String.format("Has 'apple': [ %b ].", trie.search("apple")));
		// System.out.println(String.format("StartWith 'app': [ %b ].", trie.startsWith("app")));
	}
}

class WordDictionary {

	private class Node {
		public boolean isWord;
		public TreeMap<Character, Node> next;
		
		public Node(boolean isWord) {
			this.isWord = isWord;
			this.next = new TreeMap();
		}
		
		public Node() {
			this(false);
		}
	}

	private Node root;
	private int size;
	
	public WordDictionary() {
		this.root = new Node();
		this.size = 0;
	}
	
	public void addWord(String word) {
		Node cur = this.root;
		for (int i = 0; i < word.length(); i ++) {
			char c = word.charAt(i);
			if (cur.next.get(c) == null) {
				cur.next.put(c, new Node());
			}
			cur = cur.next.get(c);
		}
		if (!cur.isWord) {
			cur.isWord = true;
			size ++;
		}
	}
	
	public boolean search(String word) {
        return match(this.root, word, 0);
    }
	
	private boolean match(Node node, String word, int index) {
		if (word.length() == index) {
			return node.isWord;
		}
		
		char c = word.charAt(index);
		if (c != '.') {
			if (node.next.get(c) == null) return false;
			return match(node.next.get(c), word, index + 1);
		} else {
			for (char nextChar: node.next.keySet()) {
				if (match(node.next.get(nextChar), word, index + 1)) {
					return true;
				}
			}
			return false;
		}
	}
}
