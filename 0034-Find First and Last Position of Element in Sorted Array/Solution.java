/**
	Url: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
	Author: MiLinSoQ
	Time: 2020-10-23
	Title: Find First and Last Position of Element in Sorted Array
	No: 34
*/

/**
	給一個 Integer array (nums) & Integer (target)。
	在這個 nums 中找到 target 的 第一個與最後一個 index。
	如果沒有 taget 回傳 -1。
	
	EX: 
		Input: nums = [5,7,7,8,8,10], target = 8
		Output: [3,4]
		
		Input: nums = [5,7,7,8,8,10], target = 6
		Output: [-1,-1]

*/
public class Solution {
	
	
	public static void main(String args[]) {
		
		int[] nums = { 5,7,7,8,8,10 };
		int target = 8;
		
		int[] res = (new Solution()).searchRange(nums, target);
		
		System.out.print("Find: " );
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i]);
			if (i != res.length - 1) System.out.print(", ");
		}
		System.out.println("");
 		
	}
	
    public int[] searchRange(int[] nums, int target) {
		
		int[] res = { -1, -1 };
		int lIndex = 0;
		int rIndex = nums.length - 1;
		
		while (lIndex <= rIndex) {
			System.out.println("l: " + lIndex + ", r: " + rIndex);
			
			
			if (nums[lIndex] == target && nums[rIndex] == target) {
				res[0] = lIndex;
				res[1] = rIndex;
				return res;
			}
			
			if (nums[lIndex] != target) lIndex++;
			if (nums[rIndex] != target) rIndex--;
			
		}
		
		// System.out.println("l: " + lIndex + ", r: " + rIndex);
		
        return res;
    }
}