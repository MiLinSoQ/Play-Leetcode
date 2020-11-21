/**
	Url: https://leetcode.com/problems/symmetric-tree/
	Author: MiLinSoQ
	Time: 2020-11-21
	Title: Symmetric Tree
	No: 101
*/

/**

	給兩個 Binary tree 判斷樹是否對稱。

	EX:
		                  
          1        	   
         / \       	         
        2   2   	Output: true 
	   / \ / \ 
      3  4 4  3
	------------------------------------------------
	 
          1        	   
         / \       	         
        2   2   	Output: false 
	   / \ / \ 
         3    3
	------------------------------------------------
	 
*/


public class Solution {
	
	public static void main(String args[]) {
		
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(2);
		
		node.left.left = new TreeNode(3);
		node.left.right = new TreeNode(4);

		node.right.left = new TreeNode(4);
		node.right.right = new TreeNode(3);


		boolean isSymmetric = (new Solution()).isSymmetric(node);
		System.out.println(String.format("Is symmtric tree: [ %b ]", isSymmetric));
	}

	public boolean isSymmetric(TreeNode root) {
		if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode node1, TreeNode node2) {
    	if (node1 == null && node2 == null) return true;
    	if (node1 == null || node2 == null) return false;
    	if (node1.val != node2.val) return false;
    	
    	return isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left);
    }
}




