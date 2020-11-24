/**
	Url: https://leetcode.com/problems/diameter-of-binary-tree/submissions/
	Author: MiLinSoQ
	Time: 2020-11-23
	Title: Diameter of Binary Tree
	No: 543
*/

/**

	給一個 Binary Tree ，找出這顆樹最大的直徑，直徑代表節點對節點的長度。
	
          1                        
         / \                       
        2   3  
       / \
      4   5
	  
	Output: 3
	  
	5 ~ 3 length is 3  or 4 ~ 3 length is 3
	
	
*/
public class Solution {
	public static void main(String[] args) {
		
		// System.out.println("Hello world.");
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		
		node.left.left = new TreeNode(4);
		node.left.right = new TreeNode(5);
		
		int result = (new Solution()).diameterOfBinaryTree(node);
		
		System.out.println(String.format("Diameter is: [ %d ]", result));
		
	}
	
	int dia = 0;
	
	public int diameterOfBinaryTree(TreeNode root) {
		diameterTree(root);
        return dia;
    }
	
	private int diameterTree(TreeNode node) {
		if (node == null) return 0;
		
		
		int leftDepth = diameterTree(node.left);
		int rightDepth = diameterTree(node.right);
		
		dia = ((leftDepth + rightDepth) > dia ? (leftDepth + rightDepth) : dia);
		
		return (leftDepth > rightDepth ? leftDepth : rightDepth) + 1;
		
	}
}

