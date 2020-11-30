/**
	Url: https://leetcode.com/problems/design-hashmap/
	Author: MiLinSoQ
	Time: 2020-11-30
	Title: Design HashMap
	No: 706
*/

/**
	設計一個 HsahMap (MyHashMap)， 必須實踐以下功能：
	1. put(key, value)
	2. get(key)
	3. remove(key)
	
	EX: 
		MyHashMap hashMap = new MyHashMap();
		hashMap.put(1, 1);          
		hashMap.put(2, 2);         
		hashMap.get(1);            // returns 1
		hashMap.get(3);            // returns -1 (not found)
		hashMap.put(2, 1);          // update the existing value
		hashMap.get(2);            // returns 1 
		hashMap.remove(2);          // remove the mapping for 2
		hashMap.get(2);            // returns -1 (not found) 
*/
public class Solution {
	
	public static void main(String args[]) {
		
		MyHashMap map = new MyHashMap();
		map.put(1, 1);
		System.out.println(map.toString());
		
		map.put(2, 2);
		System.out.println(map.toString());
		
		System.out.println(String.format("Get value: [ %d ]", map.get(1)));
		
		map.remove(2);
		System.out.println(map.toString());
		
		map.remove(1);
		System.out.println(map.toString());
		
		System.out.println(String.format("Get value: [ %d ]", map.get(1)));
		
		
	}	
}

class MyHashMap {
	
	private class Node {
		
		public int key;
		public int value;
		
		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	private Node[] data;
	private int size;

    /** Initialize your data structure here. */
    public MyHashMap() {
        this.data = new Node[10];
		this.size = 0;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
		if (this.size == this.data.length) resize(this.data.length * 2);
		
        for (int i = 0; i < this.size; i ++) {
			if (this.data[i].key == key) {
				this.data[i].value = value;
				return;
			}
		}
		
		this.data[size] = new Node(key, value);
		this.size ++;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
		for (int i = 0; i < this.size; i ++) {
			if (this.data[i].key == key) return this.data[i].value;
		}
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        for (int i = 0; i < this.size; i ++) {
			if (this.data[i].key == key) {
				this.data[i] = this.data[size - 1];
				size --;
				return;
			}
		}
    }
	
	private void resize(int newSize) {
		if (newSize < 1) throw new IllegalArgumentException("Resize failed, newSize is illegal.");
		
		Node[] newData = new Node[newSize];
		for (int i = 0; i < this.data.length; i ++) {
			newData[i] = this.data[i];
		}
		
		this.data = newData;
	}
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append(String.format("Hash Map -> size: [ %d ]\n", this.size));
		for (int i = 0; i < this.size; i ++) {
			res.append(String.format("key: [ %d ], value: [ %d ]\n", this.data[i].key, this.data[i].value));
			
		}
		return res.toString();
	}
}


 