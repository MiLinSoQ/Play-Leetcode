/**
	Url: https://leetcode.com/problems/search-insert-position/
	Author: MiLinSoQ
	Time: 2020-11-04
	Title: Search Insert Position
	No: 35
*/

/**
	給一個排序過的 Integer Array (nums) & Integer (target)
	找到 target 可以插入的位置(index)。
	
	EX: 
		Input: nums = [1,3,5,6], target = 5
		Output: 2

*/
public class Solution {
	
	
	public static void main(String args[]) {
		
		int[] nums = { 1,3,5,6,9 };
		int target = 8;
		
		int result = (new Solution()).searchInsert(nums, target);
		
		System.out.println("index: " + result);
 		
	}
	
    public int searchInsert(int[] nums, int target) {
		
		int lIndex = 0;
		int rIndex = nums.length - 1;
		int mIndex = 0;
		
		while (lIndex <= rIndex) {
			mIndex = (rIndex + lIndex) / 2;
			if (nums[mIndex] == target) return mIndex;
			if (lIndex == rIndex && nums[mIndex] < target) return rIndex + 1;
			if (lIndex == rIndex) return lIndex;
			
			if (nums[mIndex] < target) lIndex = mIndex + 1;
			if (nums[mIndex] > target) rIndex = mIndex - 1;
		}
		
        return lIndex;
    }
}