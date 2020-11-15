/**
	Url: https://leetcode.com/problems/intersection-of-two-linked-lists/
	Author: MiLinSoQ
	Time: 2020-11-15
	Title: Intersection of Two Linked Lists
	No: 160
*/

/**
	
	給兩個 ListNode ，這兩個 ListNode 會有交點，請找出交點並回傳。
	假設沒有交點回傳 null。
	
		 4 -> 1 - 
				↓
				 → 8 -> 4 -> 5
				↑
	5 -> 6 -> 1 -
	
	
	EX:
		Input: [4,1,8,4,5], [5,6,1,8,4,5]
		Output: 8
*/
public class Solution {
	
	public static void main(String args[]) {
		
		ListNode intersection = new ListNode(8, new ListNode(4, new ListNode(5)));
		
		ListNode headA = new ListNode(4, new ListNode(1, intersection));
		ListNode headB = new ListNode(5, new ListNode(6, new ListNode(1, intersection)));
		
		ListNode interSection = (new Solution()).getIntersectionNode(headA, headB);
		System.out.println("Intersection: " + interSection.val);
		
	}
	
	// 同時走訪兩個 LisNode 走到底，指標就換到另一個 ListNode 的 head，最終兩個指標會指向同一個 ListNode，指向的 ListNode 就是交點。
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) return null;
        return getIntersectionNode(headA, headB, headA, headB);
    }
	
	private ListNode getIntersectionNode(ListNode headA, ListNode headB, ListNode nodeA, ListNode nodeB) {
		if (nodeA == null && nodeB == null) return null;
		if (nodeA == nodeB) return nodeA;
		
		if (nodeA == null) {
			nodeA = headB;
		} else {
			nodeA = nodeA.next;
		}
		
		if (nodeB == null) {
			nodeB = headA;
		} else {
			nodeB = nodeB.next;
		}
		
		return getIntersectionNode(headA, headB, nodeA, nodeB);
	}
}



