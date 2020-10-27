/**
	Url: https://leetcode.com/problems/binary-tree-inorder-traversal/
	Author: MiLinSoQ
	Time: 2020-10-27
	Title: Binary Tree Inorder Traversal
	No: 94
*/
import java.util.*;
/**

	利用中序走訪 Binary tree (root)。

	EX:
	
	Tree
		1
		  ↘
			 2
		  ↙
		3
		
	Output: [1, 3, 2]
	
*/
public class Solution {
	
	public static void main(String args[]) {
		
		TreeNode node = new TreeNode(1);
		node.right = new TreeNode(2);
		node.right.left = new TreeNode(3);
		
		List<Integer> list = (new Solution()).inorderTraversal(node);
		System.out.println("list size: " + list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(String.format("list index %d: [ %d ]", i, list.get(i)));
		}
	}
	
	public List<Integer> inorderTraversal(TreeNode root) {
        return inorderTraversal(new ArrayList<>(), root);
    }
	
	public List<Integer> inorderTraversal(List<Integer> list, TreeNode root) {
        if (root == null) return list;
		inorderTraversal(list, root.left);
		list.add(root.val);
		inorderTraversal(list, root.right);
		return list;
    }
	
}







