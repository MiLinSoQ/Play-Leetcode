/**
	Url: https://leetcode.com/problems/implement-queue-using-stacks/
	Author: MiLinSoQ
	Time: 2020-11-30
	Title: Implement Queue using Stacks
	No: 232
*/
import java.util.*;
/**
	設計一個 Queue (MyQueue)，利用 Stack 當作資料結構，必須實踐以下功能：
	1. push(value)
	2. pop()  	丟出最前面的元素
	3. peek() 	查看最前面的元素
	4. empty()
	
	HashSet 定義：內容不重複。
	
	EX: 
		Input
		["MyQueue", "push", "push", "peek", "pop", "empty"]
		[[], [1], [2], [], [], []]
		Output
		[null, null, null, 1, 1, false]

		Explanation
		MyQueue myQueue = new MyQueue();
		myQueue.push(1); // queue is: [1]
		myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
		myQueue.peek(); // return 1
		myQueue.pop(); // return 1, queue is [2]
		myQueue.empty(); // return false

*/
public class Solution {
	
	public static void main(String args[]) {
		
		MyQueue queue = new MyQueue();
		
		queue.push(1);
		
		queue.push(2);
		
		// System.out.println(queue.toString());
		
		System.out.println("Peek: " + queue.peek());
		System.out.println("Pop: " + queue.pop());
		System.out.println("Peek: " + queue.peek());
		System.out.println("Pop: " + queue.pop());
		System.out.println("Peek: " + queue.peek());
		// queue.pop();
		
	}
	
	
}


class MyQueue {

	private Stack<Integer> data;

    /** Initialize your data structure here. */
    public MyQueue() {
		
		this.data = new Stack<Integer>();
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
		
		Stack<Integer> temp = new Stack<Integer>();
		
		while (!empty()) {
			temp.push(this.data.pop());
		}
		this.data.push(x);
		while (!temp.isEmpty()) {
			this.data.push(temp.pop());
		}
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
		return this.data.pop();
        // return -1;
    }
    
    /** Get the front element. */
    public int peek() {
		return this.data.peek();
        // return -1;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
		return this.data.isEmpty();
        // return false;
    }
}

 