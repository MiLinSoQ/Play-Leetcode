 /**
	Url: https://leetcode.com/problems/min-stack/
	Author: MiLinSoQ
	Time: 2020-11-09
	Title: Min Stack
	No: 155
*/
// import java.util.Array;
/**
	設計一個最小堆疊，提供一些方法。
	
	push(x) -> 丟元素到這個堆疊中。
	pop()	-> 丟出元素。
	top()	-> 取得最上層的元素。
	getMin()-> 取得堆疊中最小的元素。
	
	EX:
			
	
*/
public class Solution {
	
	public static void main(String args[]) {
		
		MinStack stack = new MinStack();
		
		stack.push(5);
		stack.push(-3);
		stack.push(2);
		stack.pop();
		stack.push(6);
		System.out.println(stack.toString());
		
		
		System.out.println("Get min: " + stack.getMin());
		
		System.out.println("top: " + stack.top());
	}
}

class MinStack {
		
	private int[] data;
	private int size;
		
	public MinStack(){
		this.data = new int[10];
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
		
	public int getSize() {
		return this.size;
	}
		
	public void push(int value) {
		this.data[size] = value;
		this.size ++;
		if (size == this.data.length) resize();
	}
		
	public void pop() {
		if (isEmpty()) throw new IllegalArgumentException("pop() failed, Stack is empty.");
		this.data[this.size] = -1;
		this.size --;
	}
		
	public int getMin() {
		if (isEmpty()) throw new IllegalArgumentException("getMin() failed, Stack is empty.");
		int min = this.data[0];
		
		for (int i = 1; i < this.size; i ++) {
			if (this.data[i] < min) {
				min = this.data[i];
			}
		}
		return min;
	}
	
	public int top() {
		if (isEmpty()) throw new IllegalArgumentException("top() failed, Stack is empty.");
		return this.data[size - 1];
	}
	
	private void resize() {
		int[] newData = new int[this.data.length * 2];
		
		for (int i = 0; i < this.data.length; i ++) {
			newData[i] = this.data[i];
		}
		this.data = newData;
	}
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		
		res.append(String.format("Min Stack ->  size: [ %d ].\n", getSize()));
		res.append("Tail [ ");
		for (int i = 0; i < this.size; i ++) {
			res.append(this.data[i]);
			if (i == this.size - 1) {
				res.append(" ] Top");
			} else {
				res.append(", ");
			}
		}
		return res.toString();
	}
}