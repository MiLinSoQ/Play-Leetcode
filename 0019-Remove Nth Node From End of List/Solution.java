 /**
	Url: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
	Author: MiLinSoQ
	Time: 2020-10-21
	Title: Remove Nth Node From End of List
	No: 19
*/
/**
	�ǤJ�@�Ӹ`�I�Y ListNode (head) & Integer (n)�A
	�R���o���쵲���˼� n �`�I�C
	
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
	
	// 1. �����o��� List �����סC
	// 2. �A�Q�Ϊ��פϦV��X�n�R�����`�I�C
	// 3. ����R���ʧ@�C
    public ListNode removeNthFromEnd(ListNode head, int n) {
		
		int size = 0;
		int target = 0;
		ListNode cur = head;
		
		// �Ĥ@�B
		while (cur != null) {
			cur = cur.next;
			size ++;
		}
		
		cur = head;
		target = size - n;
		// �ĤG�B
		if (target == 0) {
			head = head.next;
			return head;
		}
		
		// �ĤT�B
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