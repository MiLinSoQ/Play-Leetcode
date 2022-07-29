/**
	Url: https://leetcode.com/problems/swap-nodes-in-pairs/
	Author: MiLinSoQ
	Time: 2022-07-27
	Title: Swap Nodes in Pairs
	No: 27
*/

/**
	
	給一個 ListNode (head)，交換每兩個相鄰節點並返回它的頭節點。
	
	1 → 2 → 3 → 4
			↓
	2 → 1 → 4 → 3	 
	
	EX:
		Input: head = [1,2,3,4]
		Output: [2,1,4,3]
*/
public class Solution {
	
	public static void main(String args[]) {
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
		ListNode.printList(head);
		head = Solution.swapPairs(head);
		
		ListNode.printList(head);
	}
	
	public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
		
		ListNode newHead = head.next;
		
		ListNode tmpNodeA = head;
		ListNode tmpNodeB = head.next;
		ListNode tmpNodeC = null;
		
		do {
			
			tmpNodeC = tmpNodeB.next;
			
			tmpNodeB.next = tmpNodeA;
			tmpNodeA.next = tmpNodeC;
			
			if (tmpNodeC == null || tmpNodeC.next == null)  break;
			
			tmpNodeA.next = tmpNodeC.next;
			tmpNodeA = tmpNodeC;
			tmpNodeB = tmpNodeC.next;
		
		} while (true);
		
		return newHead;
    }
}