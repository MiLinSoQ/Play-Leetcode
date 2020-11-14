/**
	Url: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
	Author: MiLinSoQ
	Time: 2020-11-15
	Title: Convert Sorted Array to Binary Search Tree
	No: 108
*/

/**

	傳入一個已排序的 Integer Array (nums)，利用 nums 創建一個完全二叉樹。 
	節點深度不能相差超多 1。

      0
     / \
   -3   9
   /   /
 -10  5

*/
public class Solution {
	
	public static void main(String args[]) {
		
		
		int[] nums = { -10, -3, 0, 5, 9 };
		
		
		TreeNode root = (new Solution()).sortedArrayToBST(nums);
		
		System.out.println(String.format("The depth is: [ %s ].", root.toString()));
	}
	
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length <= 0) return null;
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int lIndex, int rIndex) {

    	if (lIndex > rIndex) return null;

    	int midIndex = (lIndex + rIndex) / 2;
    	TreeNode root = new TreeNode(nums[midIndex]);
    	root.left = sortedArrayToBST(nums, lIndex, midIndex - 1);
    	root.right = sortedArrayToBST(nums, midIndex + 1, rIndex);

    	return root;
    }
	
}







