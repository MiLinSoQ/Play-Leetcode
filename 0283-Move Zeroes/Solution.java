/**
	Url: https://leetcode.com/problems/move-zeroes/
	Author: MiLinSoQ
	Time: 2020-11-03
	Title: Move Zeroes
	No: 283
*/
/**
	傳入一個 Integer Attays (nums)，將 0 移動到最後面。
	
	EX:	
		Input: [0,1,0,3,12]
		Output: [1,3,12,0,0]
*/
public class Solution {
	
	public static void main(String args[]) {
		int[] nums = {0,1,0,3,12};
		printArray(nums);
		(new Solution()).moveZeroes(nums);
	}
	
	
	public void moveZeroes(int[] nums) {
		
		if (nums == null || nums.length <= 0) return;
		
		int index = 0;
		int cIndex = index + 1;
		while (cIndex < nums.length && index < nums.length) {
			
			if (nums[index] == 0) {
				while (nums[cIndex] == 0 && cIndex < nums.length - 1) cIndex ++;
				int tmp = nums[index];
				nums[index] = nums[cIndex];
				nums[cIndex] = tmp;
			}
			index++;
			cIndex++;
			System.out.println("-----------");
			System.out.println("index: " + index + ", c: " + cIndex);
			printArray(nums);
		}
    }
	
	private static void printArray(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
			if (i == nums.length - 1) {
				System.out.println();
			} else {
				System.out.print(", ");
			}
		}
	}
}