 /**
	Url: https://leetcode.com/problems/implement-trie-prefix-tree/
	Author: MiLinSoQ
	Time: 2020-11-10
	Title: Implement Trie (Prefix Tree)
	No: 208
*/

import java.util.TreeMap;

/**
	實作一個 Trie class，提供一些方法。
	insert		-> 丟入元素。
	seatch		-> 搜尋是否有這個元素。
	startWith	-> 搜尋是否有包含這個元素。
	
	EX:
		Trie trie = new Trie();

		trie.insert("apple");
		trie.search("apple");   // returns true
		trie.search("app");     // returns false
		trie.startsWith("app"); // returns true
		trie.insert("app");   
		trie.search("app");     // returns true
	
*/
public class Solution {
	
	public static void main(String args[]) {
		Trie trie = new Trie();
		trie.insert("apple");
		
		System.out.println(String.format("Has 'apple': [ %b ].", trie.search("apple")));
		System.out.println(String.format("StartWith 'app': [ %b ].", trie.startsWith("app")));
	}
}

class Trie {

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
	
	public Trie() {
		this.root = new Node();
		this.size = 0;
	}
	
	public void insert(String word) {
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
		Node cur = this.root;
		for (int i = 0; i < word.length(); i ++) {
			char c = word.charAt(i);
			if (cur.next.get(c) == null) return false;
			cur = cur.next.get(c);
		}
		return cur.isWord;
	}
	
	public boolean startsWith(String prefix) {
		Node cur = this.root;
		for (int i = 0; i < prefix.length(); i ++) {
			char c = prefix.charAt(i);
			if (cur.next.get(c) == null) return false;
			cur = cur.next.get(c);
		}
		return true;
	}
}
