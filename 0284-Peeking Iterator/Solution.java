/**
	Url: https://leetcode.com/problems/peeking-iterator/
	Author: MiLinSoQ
	Time: 2020-12-01
	Title: Peeking Iterator
	No: 284
*/
import java.util.*;
/**
	

*/
public class Solution {
	
	public static void main(String args[]) {
		
		
		// Set<Integer> set = new HashSet<Integer>();
		
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(1);
		list.add(2);
		list.add(3);
		
		PeekingIterator iterator = new PeekingIterator(list.iterator());
		
		System.out.println("Peek: " + iterator.peek());
		
		System.out.println("Peek: " + iterator.next());
		
		System.out.println("has null: " + iterator.hasNext());
		
		System.out.println("Peek: " + iterator.next());
		
		System.out.println("has null: " + iterator.hasNext());
		
		System.out.println("Peek: " + iterator.next());
		
		System.out.println("has null: " + iterator.hasNext());
		
	}
	
	
}
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
	
	private Integer next;
	private Iterator<Integer> iterator;
	
	public PeekingIterator(Iterator<Integer> iterator) {
		
	    this.iterator = iterator;
		
		if (this.iterator.hasNext())
			this.next = iterator.next();
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return this.next;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		Integer res = this.next;
		this.next = (this.iterator.hasNext() ? this.iterator.next() : null);
		return res;
	}
	
	@Override
	public boolean hasNext() {
	    return this.next != null;
	}
}
 