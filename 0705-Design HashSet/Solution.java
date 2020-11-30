/**
	Url: https://leetcode.com/problems/design-hashset/
	Author: MiLinSoQ
	Time: 2020-11-30
	Title: Design HashSet
	No: 705
*/

/**
	設計一個 HsahSet (MyHashSet)， 必須實踐以下功能：
	1. add(value)
	2. contains(value)
	3. remove(value)
	
	HashSet 定義：內容不重複。
	
	EX: 
		MyHashSet hashSet = new MyHashSet();
		hashSet.add(1);         
		hashSet.add(2);         
		hashSet.contains(1);    // returns true
		hashSet.contains(3);    // returns false (not found)
		hashSet.add(2);          
		hashSet.contains(2);    // returns true
		hashSet.remove(2);          
		hashSet.contains(2);    // returns false (already removed)

*/
public class Solution {
	
	public static void main(String args[]) {
		
		MyHashSet set = new MyHashSet();
		
		set.add(66);
		set.add(61);
		set.add(62);
		set.add(63);
		set.add(64);
		set.add(65);
		set.add(67);
		set.add(68);
		set.add(69);
		set.add(70);
		set.add(72);
		set.add(71);
		
		
		System.out.println(set.toString());
		
		set.remove(66);
		System.out.println("Has 71? " + set.contains(71));
		
		System.out.println(set.toString());
		set.remove(65);
		System.out.println(set.toString());
		// set.add(66);
		// System.out.println("Has 66? " + set.contains(66));
		
		// System.out.println("Has -1? " + set.contains(-1));
		
		// set.add(1);
		// set.add(2);
		
		// System.out.println(set.toString());
		
		// System.out.println(String.format("Is contains 1: [ %b ]", set.contains(1)));
		// System.out.println(String.format("Is contains 3: [ %b ]", set.contains(3)));
		
		// set.add(2);
		
		// System.out.println(set.toString());
		// System.out.println(String.format("Is contains 2: [ %b ]", set.contains(2)));
		
		// set.remove(2);
		// System.out.println(set.toString());
		// System.out.println(String.format("Is contains 2: [ %b ]", set.contains(2)));
		
		// System.out.println(String.format("Add big car: [ %b ]", park.addCar(1)));
		
		// System.out.println(String.format("Add medium car: [ %b ]", park.addCar(2)));
		// System.out.println(String.format("Add medium car: [ %b ]", park.addCar(2)));
		
		// System.out.println(String.format("Add small car: [ %b ]", park.addCar(3)));
 		
	}
	
	
}

class MyHashSet {

	private int[] data;
	private int size;
	
    /** Initialize your data structure here. */
    public MyHashSet() {
        this.data = new int[10];
		this.size = 0;
		for (int i = 0; i < this.data.length; i ++) {
			this.data[i] = -1;
		}
		
    }
    
    public void add(int key) {
		if (contains(key)) return;
		if ((this.size) == this.data.length) resize(this.data.length * 2);
		this.data[size] = key;
        this.size ++;
    }
    
    public void remove(int key) {
        for (int i = 0; i < this.data.length; i ++) {
			if (this.data[i] == key) {
				this.data[i] = this.data[--this.size];
			}
		}
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        for (int i = 0; i < this.size; i ++) {
			if (this.data[i] == key) return true;
		}
		return false;
    }
	
	private void resize(int size) {
		int[] newData = new int[size];
		for (int i = 0; i < size; i ++) {
			newData[i] = -1;
		}
		for (int i = 0; i < this.data.length; i ++) {
			newData[i] = this.data[i];
		}
		this.data = newData;
	}
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append(String.format("HashSet =>  Size: [ %d ]\n", this.size));
		for (int i = 0; i < this.size; i ++) {
			res.append(this.data[i]);
			if (i != this.size - 1)
			 res.append(", ");
		}
		return res.toString();
	}
}

 