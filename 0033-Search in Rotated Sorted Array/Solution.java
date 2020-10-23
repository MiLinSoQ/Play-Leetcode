/**
	Url: https://leetcode.com/problems/search-in-rotated-sorted-array/
	Author: MiLinSoQ
	Time: 2020-10-23
	Title: Search in Rotated Sorted Array
	No: 33
*/

/**
	傳入一個 Intreger array (nums) & Integer (target)
	在這個陣列中找到 target 。
	使用二分搜尋法，且這個陣列是"旋轉排序數組"。
	一般排序組合： [0,1,2,4,5,6,7]，旋轉排序組合:  [4,5,6,7,0,1,2]。
	如果找不到 target 回傳 -1。
	
	EX:
		Input: nums = [4,5,6,7,0,1,2], target = 0
		Output: 4
*/

public class Solution {
	
	public static void main(String args[]) {
		
		int[] nums = {4,5,6,7,0,1,2};
		int target = 4;
		
		int res = (new Solution()).search(nums, target);
		System.out.println("search index: " + res);
		
	}
	
    public int search(int[] nums, int target) {
		
		int lIndex = 0;
		int rIndex = nums.length - 1;
		int mIndex = 0;
		while (lIndex <= rIndex) {
			
			mIndex = (lIndex + rIndex) / 2;
			
			if (nums[mIndex] == target) return mIndex;
			
			// 如果左邊指標的值 <= 中間指標的值，表示陣列的左標指標到中間指標是有排序的。
			if (nums[lIndex] <= nums[mIndex]) {
				
				// target 是否在這個排序之間，如果是就在這個區間找 target。
				if (nums[lIndex] <= target && nums[mIndex] > target) {
					rIndex = mIndex - 1;
				} else {
					lIndex = mIndex + 1;
				}
			} else {	// 中間指標到右邊指標是有排序的
				
				if (nums[rIndex] >= target && nums[mIndex] < target) {
					lIndex = mIndex + 1;
				} else {
					rIndex = mIndex - 1;
				}
			}
		}
		
        return -1;
    }
}