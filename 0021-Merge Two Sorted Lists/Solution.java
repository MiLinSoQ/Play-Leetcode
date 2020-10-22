/**
	Url: https://leetcode.com/problems/merge-two-sorted-lists/
	Author: MiLinSoQ
	Time: 2020-10-20
	Title: Merge Two Sorted Lists
	No: 21
*/

/**
	合併兩個已完成排序的鏈結。
	
	EX:
			1 -> 2 -> 4 -> NULL
			
			1 -> 3 -> 4 -> NULL
			
		-----------------------------	
		
			1 -> 1 -> 2 -> 3 -> 4 -> 4 -> NULL
	
*/

public class Solution {
	
	public static void main(String args[]) {
		
		
		int[] arr1 = {1, 2, 4};
		int[] arr2 = {1, 3, 4};
		
		ListNode node1 = createLinkedList(arr1);
		ListNode node2 = createLinkedList(arr2);

		

		ListNode resultNode = (new Solution()).mergeTwoLists(node1, node2);
		printList(resultNode);

	}
	
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		
		ListNode dummyHead = new ListNode(-1);
		ListNode cur = dummyHead;
		while (l1 != null || l2 != null) {
			
			if (l1 == null) {
				cur.next = l2;
				break;
			} else if (l2 == null) {
				cur.next = l1;
				break;
			}
			
			if (l1.val <= l2.val) {
				cur.next = l1;
				l1 = l1.next;
				cur = cur.next;
				cur.next = null;
			} else {
				cur.next = l2;
				l2 = l2.next;
				cur = cur.next;
				cur.next = null;
			}
		}
        return dummyHead.next;
    }
	
	public static ListNode createLinkedList(int[] arr) {
		
		if (arr == null || arr.length < 0) throw new IllegalArgumentException("Create linked list failed, array is empty.");
		
		ListNode dummyHead = new ListNode(-1);
		ListNode curr;
		
		curr = dummyHead;
		for(int i = 0; i < arr.length; i++) {
			curr.next = new ListNode(arr[i]);
			curr = curr.next;
		}
		return dummyHead.next;
	}
	
	public static void printList(ListNode head) {
		
		// if (head == null) throw new IllegalArgumentException("Print failed, head is null.");
		
		ListNode cur = head;
		while (cur != null) {
			
			System.out.print(String.format("%d -> ", cur.val));
			
			cur = cur.next;
		}
		
		System.out.println("NULL.");
	}
	
}