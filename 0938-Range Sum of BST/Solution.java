/**
	Url: https://leetcode.com/problems/range-sum-of-bst/
	Author: MiLinSoQ
	Time: 2020-10-27
	Title: Range Sum of BST
	No: 938
*/

/**
	給一個樹結構 (root) & Integer (L) & Integer (R)
	回傳 L 與 R 之間的相加值
	
	EX: 
		Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
		Output: 32 because 10 + 15 + 7 = 32
		
	
*/
public class Solution {
	
	public static void main(String args[]) {
		
		int[] nums = { 10, 5, 15, 3, 7, -1, 18 };
		int L = 7;
		int R = 15;
		
		// int[] nums = { 10,5,15,3,7,13,18,1,-1,6 };
		// int L = 6;
		// int R = 10;
		
		TreeNode node = TreeNode.createTree(nums);
		
		int ans = (new Solution()).rangeSumBST(node, L, R);
		System.out.println(String.format("Sum: [ %d ]", ans));
		
	}
	
    public int rangeSumBST(TreeNode root, int L, int R) {
		
		int sum = 0;
        return rangeSumBST(root, L, R, sum);
    }
	
	 public int rangeSumBST(TreeNode node, int L, int R, int ret) {
		 
		 if (node == null) return ret;
		 if (node.val >= L && node.val <= R) {
			 System.out.println(String.format("sum: [ %d ], node: [ %d ]", ret, node.val));
			 ret += node.val;
		 }
		 
		 if (node.val > L) {
			ret = rangeSumBST(node.left, L, R, ret);
		 }
		 
		 if (node.val < R) {
			 ret = rangeSumBST(node.right, L, R, ret);
		 }
		 
		 return ret;
    }
	
	
	
}