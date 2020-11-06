/**
	Url: https://leetcode.com/problems/sort-list/
	Author: MiLinSoQ
	Time: 2020-11-04
	Title: Sort List
	No: 148
*/

/**
	
	給一個 ListNode (head) ，排序這個 List
	
	4 -> 2 -> 1 -> 3
	
		   ↓
	
	1 -> 2 -> 3 -> 4
	
	
	EX:
		Input: head = [4,2,1,3]
		Output: [1,2,3,4]
*/
public class Solution {
	
	public static void main(String args[]) {
		int[] nums = { 16493,9642,-6427,5904,5245,13260,6910,-7364,-7509,-4270,-4137,9665,7861,12242,17925,7630,-6069,-7791,-2826,421,16650,586,16338,18435,-4715,-9660,16382,12599,13925,15297,-3584,-1851,7572,-7500,14378,1823,14695,4424,18629,-4136,7116,-665,12326,1143,-5711,17845,-9508,12172,8539,14423,17633,1081,2726,7671,-6384,1139,14219,16056,11995,1021,-1729,15750,16498,-7639,5458,-2977,8407,19963,3270,3161,-4018,8242,-822,14460,261,19699,9160,2338,-6966,13274,19723,12414,6125,-9461,9375,-9203,-8311,16511,-7753,3679,-1932,-105,16365,-7184,9127,14451,-3886,15121,12833,14299,5861,-4000,15822,-574,-1900,7613,18868,18395,10472,5604,-653,1377,13002,3789,-4266,1281,19283,728,5718,-6139,-367,18203,-4488,14748,18569,8081,-366,-6231,-8563,-2968,7957,11759,-5605,7103,3200,3771,4047,16175,-4585,5321,6133,-5840,2572,6518,3964,3566,11783,6043,-5769,19159,-8832,13486,7156,16466,-1552,-4958,8946,5685,-3515,-6346,-1171,-337,2885,11930,16761,16446 };
		ListNode node = ListNode.createLinkedList(nums);
		ListNode.printList(node);
		
		
		// ListNode.printList(node);
		// ListNode lastNode = ListNode.getLast(node);
		
		// lastNode.next = node;
		
		
		ListNode sortedNode = (new Solution()).sortList(node);
		
		ListNode.printList(sortedNode);
		// System.out.println("Is cycle: " + isCycle);
	}
	
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) return head;
		sortList(head, head.next);
        return head;
    }
	
	private void sortList(ListNode cNode, ListNode nNode) {
		if (cNode.val > nNode.val) {
			int tmp = cNode.val;
			cNode.val = nNode.val;
			nNode.val = tmp;
		}
		if (nNode.next != null) {
			sortList(cNode, nNode.next);
		} else if (cNode.next != null && cNode.next.next != null) {
			sortList(cNode.next, cNode.next.next);
		}
	}
}



