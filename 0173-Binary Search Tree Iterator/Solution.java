/**
	Url: https://leetcode.com/problems/binary-search-tree-iterator/
	Author: MiLinSoQ
	Time: 2020-12-10
	Title: Binary Search Tree Iterator
	No: 173
*/
import java.util.*;
/**
	
	設計一個 Iterator，來走訪 Tree 結構。
	需要實作以下方法：
	1. int next()
	2. boolean hasNext()
	
	
	EX:
			7
		   /  \
		  3   15
			 /   \
		    9     20
	 
		Input
		["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
		[[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
		Output
		[null, 3, 7, true, 9, true, 15, true, 20, false]

		Explanation
		BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
		bSTIterator.next();    // return 3
		bSTIterator.next();    // return 7
		bSTIterator.hasNext(); // return True
		bSTIterator.next();    // return 9
		bSTIterator.hasNext(); // return True
		bSTIterator.next();    // return 15
		bSTIterator.hasNext(); // return True
		bSTIterator.next();    // return 20
		bSTIterator.hasNext(); // return False
		

*/
public class Solution {
	
	public static void main(String args[]) {
		
		TreeNode node = new TreeNode(7);
		node.left = new TreeNode(3);
		node.right = new TreeNode(15);
		node.right.left = new TreeNode(9);
		node.right.right = new TreeNode(20);
		
		BSTIterator iterator = new BSTIterator(node);
		
		System.out.println("Next: " + iterator.next());
		
		System.out.println(iterator.toString());
		
	}
}

class BSTIterator {

	private List<Integer> data;
	private int position;

    public BSTIterator(TreeNode root) {
		if (root == null) throw new IllegalArgumentException("The arg can't be null.");
		this.data = new ArrayList<>();
		this.position = 0;
		init(root);
    }
	
	private void init(TreeNode node) {
		if (node == null) return;
		init(node.left);
		this.data.add(node.val);
		init(node.right);
	}
	
	
    /** @return the next smallest number */
    public int next() {
		int result = this.data.get(this.position ++);
		return result;
    }
	
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return this.data.size() > this.position;
    }
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		
		res.append("BST Iterator.\n");
		res.append(String.format("Size: [ %d ].\n", this.data.size()));
		res.append(String.format("Position: [ %d ].\n", this.position));
		
		for (int i : this.data) {
			res.append(i + ", ");
		}
		
		return res.toString();
	}
}
 