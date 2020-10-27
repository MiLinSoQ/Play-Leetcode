/**
	Url: https://leetcode.com/problems/merge-two-binary-trees/
	Author: MiLinSoQ
	Time: 2020-10-27
	Title: Merge Two Binary Tree
	No: 617
*/

/**

	將兩個樹結構相加合併，(題目的二叉樹不是二元搜尋樹...)

		Tree 1     	 Tree 2                  
          1        	    2                             
         / \       	   / \                            
        3   2    + 	  1   3      
       /           	   \   \                      
      5            	    4   7      
	  
	  Merged tree:
	     3
	    / \
	   4   5
	  / \   \ 
	 5   4   7
	
*/
public class Solution {
	
	public static void main(String args[]) {
		
		// int[] nums1 = { 1, 3, 2, 5 };
		// int[] nums2 = { 2, 1, 3, 4, 7 };
		
		
		// TreeNode node1 = TreeNode.createTree(nums1);
		// TreeNode node2 = TreeNode.createTree(nums2);
		
		TreeNode node1 = new TreeNode(1);
		node1.left = new TreeNode(3);
		node1.left.left = new TreeNode(5);
		node1.right = new TreeNode(2);
		
		TreeNode node2 = new TreeNode(2);
		node2.left = new TreeNode(1);
		node2.left.right = new TreeNode(4);
		node2.right = new TreeNode(3);
		node2.right.right = new TreeNode(7);
		
		TreeNode res = (new Solution()).mergeTrees(node1, node2);
		
		System.out.println("Merge: " + res.val);
		
		System.out.println("Merge: " + res.left.val);
		
		System.out.println("Merge: " + res.left.left.val);
		
		System.out.println("Merge: " + res.left.right.val);
		
		System.out.println("Merge: " + res.right.val);
		
		System.out.println("Merge: " + res.right.right.val);
	}
	
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		TreeNode root = null;
        return mergeTrees(root, t1, t2);
    }
	
	
	public TreeNode mergeTrees(TreeNode node, TreeNode t1, TreeNode t2) {
		
		if (t1 == null && t2 == null) return node;
		
		if (node == null) {
			node = new TreeNode();
		}
		
		if (t1 != null) {
			System.out.println("val  t1: " + node.val + " + " + t1.val);
			node.val += t1.val;
		}
		
		if (t2 != null) {
			System.out.println("val  t2: " + node.val + " + " + t2.val);
			node.val += t2.val;
		}
		System.out.println("-------------");
		
		if (t1 != null && t2 != null) {
			node.left = mergeTrees(node.left, t1.left, t2.left);
		} else if (t1 != null && t2 == null) {
			node.left = mergeTrees(node.left, t1.left, t2);	
		} else if (t1 == null && t2 != null){
			node.left = mergeTrees(node.left, t1, t2.left);
		}
		
		if (t1 != null && t2 != null) {
			node.right = mergeTrees(node.right, t1.right, t2.right);
		} else if (t1 != null && t2 == null) {
			node.right = mergeTrees(node.right, t1.right, t2);	
		} else if (t1 == null && t2 != null){
			node.right = mergeTrees(node.right, t1, t2.right);
		}
		return node;
    }
	
}







