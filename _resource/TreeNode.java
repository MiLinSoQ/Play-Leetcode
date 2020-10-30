
// Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
	
	public static TreeNode createTree(int[] nums) {
		
		TreeNode root = null;
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < 0) continue;
			root = addTreeNode(root, nums[i]);
		}
		
		return root;
	}
	
	
	private static TreeNode addTreeNode(TreeNode node, int val) {
		
		if (node == null) {
			return new TreeNode(val);
		}
		
		if (val < node.val) {
			node.left = addTreeNode(node.left, val);
		} else if (val > node.val) {
			node.right = addTreeNode(node.right, val);
		}
		
		return node;
	}
}