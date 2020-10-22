 /**
	Url: https://leetcode.com/problems/add-two-numbers/
	Author: MiLinSoQ
	Time: 2020-10-19
	Title: Add Two Numbers
	No: 2
*/

/**
	EX	
	
	Input: l1 = [2,4,3], l2 = [5,6,4]
	Output: [7,0,8]
	
			l1:	  2 -> 4 -> 3 -> NULL
			l2:	+ 5 -> 6 -> 4 -> NULL
				------------------------
				  7 -> 0 -> 8 -> NULL
	
*/
class Solution { 
    
	public static void main(String args[]) {
		
		int[] arr1 = {2,4,3};
		int[] arr2 = {5,6,4};
		
		ListNode l1 = createLinkedList(arr1);
		
		printList(l1);
		
		ListNode l2 = createLinkedList(arr2);
		
		printList(l2);
		
		ListNode resultNode = (new Solution()).addTwoNumbers(l1, l2);
		printList(resultNode);
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		if (l1 == null || l2 == null) throw new IllegalArgumentException("Failed, la | l2 is null.");
		
		// 虛擬頭節點，方便加入新的鏈結。
		ListNode dummyHead = new ListNode(-1);
		ListNode curr;
		// 進位值
		int carry = 0;
		curr = dummyHead;
		while (l1 != null || l2 != null) {
			
			int x = (l1 != null ? l1.val : 0);
			int y = (l2 != null ? l2.val : 0);
			int sum = x + y + carry;
			
			carry = sum / 10;
			curr.next = new ListNode(sum % 10);
			curr = curr.next;
			
			if (l1 != null) l1 = l1.next;
			if (l2 != null) l2 = l2.next;
		}
		
		// 檢查是否還有進位，如果有進位，最後還需要再添加一個節點。
		if (carry > 0) {
			curr.next = new ListNode(carry);
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
		
		if (head == null) throw new IllegalArgumentException("Print failed, head is null.");
		
		ListNode cur = head;
		while (cur != null) {
			
			System.out.print(String.format("%d -> ", cur.val));
			
			cur = cur.next;
		}
		
		System.out.println("NULL.");
	}
	
}