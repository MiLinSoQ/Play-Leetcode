/**
	Url: https://leetcode.com/problems/maximum-depth-of-binary-tree/
	Author: MiLinSoQ
	Time: 2020-10-29
	Title: Maximum Depth of Binary Tree
	No: 104
*/

/**

	傳入一個 Binary tree (root) ， 找出深度。

    3
   / \
  9  20
    /  \
   15   7
	
	Output: 3
*/
public class Solution {
	
	public static void main(String args[]) {
		
		
		TreeNode node = new TreeNode(3);
		node.left = new TreeNode(9);
		node.right = new TreeNode(20);
		
		node.right.left = new TreeNode(15);
		node.right.right = new TreeNode(7);
		
		
		int depth = (new Solution()).maxDepth(node);
		
		System.out.println(String.format("The depth is: [ %d ].", depth));
	}
	
	public int maxDepth(TreeNode root) {
        return maxDepth(root, 0, 0);
    }
	
	private int maxDepth(TreeNode node, int curDepth, int maxDepth) {
		if (node == null) return maxDepth;
		
		curDepth++;
		
		maxDepth = maxDepth(node.left, curDepth, maxDepth);
		maxDepth = maxDepth(node.right, curDepth, maxDepth);
		
		if (curDepth > maxDepth) maxDepth = curDepth;
		return maxDepth;
	}
	
}







