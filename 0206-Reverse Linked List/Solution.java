/**
	Url: https://leetcode.com/problems/reverse-linked-list/
	Author: MiLinSoQ
	Time: 2020-10-30
	Title: Reverse Linked List
	No: 206
*/
/**
	
	反轉一個 Linked List
	
	EX:
		Input:  1->2->3->4->5->NULL
		Output: 5->4->3->2->1->NULL
*/
public class Solution {
	
	public static void main(String args[]) {
		int[] nums = { 1, 2, 3, 4, 5 };
		ListNode node = ListNode.createLinkedList(nums);
		ListNode.printList(node);
		
		
		node = (new Solution()).reverseList(node);
		ListNode.printList(node);
	}
	
	
	// 另開一個鏈結，將原本的鏈結一個一個串接到新的鏈結，串接完後，原本的最後一個節點會在新鏈結的最前面。
	public ListNode reverseList(ListNode head) {
		return reverseList(head, null);
    }
	
	private ListNode reverseList(ListNode node, ListNode newHead) {
		if (node == null) return newHead;
		
		ListNode tempNext = node.next;
		node.next = newHead;
		
		newHead = node;
		node = tempNext;
		
		return reverseList(node, newHead);
	}
}