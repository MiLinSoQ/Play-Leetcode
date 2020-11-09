/**
	Url: https://leetcode.com/problems/palindrome-linked-list/
	Author: MiLinSoQ
	Time: 2020-11-09
	Title: Palindrome Linked List
	No: 234
*/
/**
	
	給一個 Linked List ， 檢查是否回文。
	
	EX:
		Input: 1->2
		Output: false
		
		Input: 1->2->2->1
		Output: true
		
*/
public class Solution {
	
	public static void main(String args[]) {
		int[] nums = { 1,2,2,1 };
		ListNode node = ListNode.createLinkedList(nums);
		ListNode.printList(node);
		
		
		boolean result = (new Solution()).isPalindrome(node);
		
		System.out.println("Is palindrom: " + result);
	}
	
	public boolean isPalindrome(ListNode head) {
		ListNode walker = head;
		ListNode runner = head;
		ListNode dummyHead = null;
		while (runner != null && runner.next != null) {
			runner = runner.next.next;
			ListNode tmp = walker;
			walker = walker.next;
			tmp.next = dummyHead;
			dummyHead = tmp;
		}
		
		if (runner != null) {
			walker = walker.next;
		}
		
		ListNode.printList(walker);
		ListNode.printList(dummyHead);
		
		while (walker != null) {
			if (walker.val != dummyHead.val) return false;
			walker = walker.next;
			dummyHead = dummyHead.next;
		}
		
        return true;
    }
}