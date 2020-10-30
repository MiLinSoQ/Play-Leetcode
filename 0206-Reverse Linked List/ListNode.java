
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	
	
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

