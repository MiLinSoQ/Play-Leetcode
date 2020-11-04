/**
	Url: https://leetcode.com/problems/linked-list-cycle/
	Author: MiLinSoQ
	Time: 2020-11-04
	Title: Linked List Cycle
	No: 141
*/

/**
	
	給一個 ListNode (head) ，檢查這個 ListNode 是否為一個圓。
	
	3 -> 2 -> 0 -> -1 -> 4
		 ↑				 |
		 ----------------- 
	
	EX:
		Input: head = [3,2,0,-4], pos = 1
		Output: true
		Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
*/
public class Solution {
	
	public static void main(String args[]) {
		int[] nums = { 1, 2 };
		ListNode node = ListNode.createLinkedList(nums);
		ListNode.printList(node);
		
		ListNode lastNode = ListNode.getLast(node);
		
		lastNode.next = node;
		
		// System.out.println("last node: " + lastNode.next.val);
		// System.out.println(node.next.val);
		
		
		boolean isCycle = (new Solution()).hasCycle(node);
		System.out.println("Is cycle: " + isCycle);
	}
	
	public boolean hasCycle(ListNode head) {
		
		if (head == null) return false;
		
		ListNode walker = head;
		ListNode runner = head;
		while (runner.next != null && runner.next.next != null) {
			
			walker = walker.next;
			runner = runner.next.next;
			
			if (walker == runner) return true;
		}
        return false;
    }
	
}