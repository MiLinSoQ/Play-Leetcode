/**
	Url: https://leetcode.com/problems/implement-stack-using-queues/
	Author: MiLinSoQ
	Time: 2020-12-01
	Title: Implement Stack using Queue
	No: 225
*/
import java.util.*;
/**
	設計一個 Stack (MyStack)，利用 Queue 當作資料結構。
	需要實作以下功能：
	1. void push(int x)
	2. int pop()
	3. int top()
	4. boolean empty()
	
	
	EX: 
		Input
		["MyStack", "push", "push", "top", "pop", "empty"]
		[[], [1], [2], [], [], []]
		Output
		[null, null, null, 2, 2, false]

		Explanation
		MyStack myStack = new MyStack();
		myStack.push(1);
		myStack.push(2);
		myStack.top(); // return 2
		myStack.pop(); // return 2
		myStack.empty(); // return False	

*/
public class Solution {
	
	public static void main(String args[]) {
		
		MyStack stack = new MyStack();
		
		stack.push(1);
		System.out.println(stack.toString());
		stack.push(2);
		System.out.println(stack.toString());
		stack.push(3);
		System.out.println(stack.toString());
		stack.pop();
		System.out.println(stack.toString());
		
		System.out.println("top: " + stack.top());
		
		// stack.pop();
		System.out.println("Is empty: " + stack.empty());
		
	}
}

class MyStack {

	private Queue<Integer> data;
	
    /** Initialize your data structure here. */
    public MyStack() {
        this.data = new LinkedList();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        this.data.offer(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
		Queue queue = new LinkedList();
		int size = this.data.size();
		if (size == 0) return -1;
		
		int index = 0;
		int last = -1;
		while (!this.data.isEmpty()) {
			index ++;
			if (index == size) {
				
				System.out.println("index: " + index);
				last = this.data.poll();
			} else {
				queue.offer(this.data.poll());
			}
			
		}
		this.data = queue;
        return last;
    }
    
    /** Get the top element. */
    public int top() {
        Queue queue = new LinkedList();
		int size = this.data.size();
		if (size == 0) return -1;
		
		int index = 0;
		int last = -1;
		while (!this.data.isEmpty()) {
			if (++index == size) {
				System.out.println("last: " + this.data.peek());
				last = this.data.peek();
			}
			queue.offer(this.data.poll());
		}
		this.data = queue;
        return last;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return this.data.isEmpty();
    }
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		
		res.append(String.format("Stack -> size: [ %d ].\n", this.data.size()));
		int index = 0;
		res.append("[ ");
		for (int i : this.data) {
			res.append(i);
			if (++index != (this.data.size()))
				res.append(", ");
		}
		res.append(" ] Top.");
		
		return res.toString();
	}
}
