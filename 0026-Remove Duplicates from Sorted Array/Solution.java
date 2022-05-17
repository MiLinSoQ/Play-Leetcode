/**
	Url: https://leetcode.com/problems/remove-duplicates-from-sorted-array/submissions/
	Author: MiLinSoQ
	Time: 2022-05-17
	Title: Remove Duplicates from Sorted Array
	No: 26
*/
import java.util.*;

/**
	傳入一個 Integers (nums)，
	在 nums 找出重複的數字，並刪除。
	
	EX: 
		Input: nums = [ 1, 1, 2]
		Output: 2, nums = [1, 2, _]

		Input: nums = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]
		Output: 5, nums = [ 0, 1, 2, 3, 4, _, _, _, _, _ ]
*/
public class Solution {
	
	public static void main(String args[]) {
		
		int nums[] = { 0, 1, 1, 1, 2, 2, 4, 4, 5};
		
		System.out.println("size: " + removeDuplicates(nums));
		
	}
	
	public static int removeDuplicates(int[] nums) {
		if (nums.length == 0) return 0;
		
		int moveIndex = 0;
		for (int index = 1; index < nums.length; index ++) {
			
			if (nums[index] != nums[moveIndex]) {
				moveIndex ++;
				nums[moveIndex] = nums[index];
			}
		}
		
		return ++moveIndex;
    } 
	
}