/**
	Url: https://leetcode.com/problems/invert-binary-tree/
	Author: MiLinSoQ
	Time: 2020-10-30
	Title: Invert Binary Tree
	No: 226
*/

/**

	將兩個樹結構相加合併，(題目的二叉樹不是二元搜尋樹...)

	EX:
	
		Input:
		
		     4
		   /   \
		  2     7
		 / \   / \
		1   3 6   9
		
		
			 ↓
		
		Output:
		
		     4
		   /   \
		  7     2
		 / \   / \
		9   6 3   1

*/
public class Solution {
	
	public static void main(String args[]) {
		
		TreeNode node = new TreeNode(4);
		
		node.left = new TreeNode(2);
		node.right = new TreeNode(7);
		
		node.left.left = new TreeNode(1);
		node.left.right = new TreeNode(3);
		
		node.right.left = new TreeNode(6);
		node.right.right = new TreeNode(9);
		
		
		node = (new Solution()).invertTree(node);
		System.out.println(node.val);
		
		System.out.println(node.left.val);
		System.out.println(node.right.val);
		
		System.out.println(node.left.left.val);
		System.out.println(node.left.right.val);
		
		System.out.println(node.right.left.val);
		System.out.println(node.right.right.val);
	}
	
	public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
		
		TreeNode tempNode = root.left;
		root.left = root.right;
		root.right = tempNode;
		
		invertTree(root.left);
		invertTree(root.right);
		
		return root;
    }
	
}







