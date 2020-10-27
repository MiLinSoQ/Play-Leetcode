/**
	Url: https://leetcode.com/problems/merge-two-binary-trees/
	Author: MiLinSoQ
	Time: 2020-10-27
	Title: Merge Two Binary Tree
	No: 617
*/

/**

	給兩個 Binary tree 判斷是否相等。

	EX:
		Tree 1     	 Tree 2                  
          1        	    1 
         / \       	   / \      
        3   2     	  1   3     	Output: false 
		
	------------------------------------------------
	 
		Tree 1     	 Tree 2                  
          1        	    1 
         / \       	   / \      
	 null   2     	  2  null       Output: false
	 
	------------------------------------------------
	 
		Tree 1     	 Tree 2                  
          1        	    1 
         / \       	   / \      
		2	3     	  2   3       	Output: true
*/


public class Solution {
	
	public static void main(String args[]) {
		
		TreeNode node1 = new TreeNode(0);
		node1.left = new TreeNode(2);
		node1.right = new TreeNode(3);
		
		TreeNode node2 = new TreeNode(0);
		node2.left = new TreeNode(2);
		node2.right = new TreeNode(3);
		
		boolean isSame = (new Solution()).isSameTree(node1, node2);
		System.out.println(String.format("Is same tree: [ %b ]", isSame));
	}
	
	public boolean isSameTree(TreeNode p, TreeNode q) {
		return isSameTree(p, q, true);
    }
	
	private boolean isSameTree(TreeNode p, TreeNode q, boolean ret) {
		
		if (p == null && q != null) return false;
		if (p != null && q == null) return false;
		
		if (p != null && q != null) {
			if (p.val != q.val) return false;
			
			ret = isSameTree(p.left, q.left);
			if (!ret) return ret;
			
			ret = isSameTree(p.right, q.right);
		}
		return ret;
	}
}




