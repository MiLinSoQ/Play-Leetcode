 /**
	Url: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
	Author: MiLinSoQ
	Time: 2020-10-21
	Title: Remove Nth Node From End of List
	No: 19
*/
/**
	傳入一個節點頭 ListNode (head) & Integer (n)，
	刪掉這個鏈結的倒數 n 節點。
	
	EX:
			1 -> 2 -> 3 -> 4 -> 5 -> NULL
			
			1 -> 2 -> 3 -> 5 -> NULL
		
		Input: head = [1,2,3,4,5], n = 2
		Output: [1,2,3,5]
	
*/
public class Solution {
	
	public static void main(String args[]) {
		
		int arr[] = {1,2,3,4,5};
		ListNode node = ListNode.createLinkedList(arr);
		ListNode.printList(node);
		
		ListNode result = (new Solution()).removeNthFromEnd(node, 2);
		
		ListNode.printList(result);
	}
	
	// 1. 先取得整個 List 的長度。
	// 2. 再利用長度反向算出要刪除的節點。
	// 3. 執行刪除動作。
    public ListNode removeNthFromEnd(ListNode head, int n) {
		
		int size = 0;
		int target = 0;
		ListNode cur = head;
		
		// 第一步
		while (cur != null) {
			cur = cur.next;
			size ++;
		}
		
		cur = head;
		target = size - n;
		// 第二步
		if (target == 0) {
			head = head.next;
			return head;
		}
		
		// 第三步
		for (int i = 0; i < target; i++) {
			if (i != target - 1) {
				cur = cur.next;
			} else {
				ListNode tmp = cur.next;
				cur.next = tmp.next;
				tmp = null;
			}
		}
		
		return head;
    }
}