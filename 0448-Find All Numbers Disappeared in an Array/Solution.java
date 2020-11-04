/**
	Url: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
	Author: MiLinSoQ
	Time: 2020-11-03
	Title: Find All Numbers Disappeared in an Array
	No: 448
*/

import java.util.*;
/**
	傳入一個 Integer Attays (nums)，這個 nums 會是 1 <= nums[i] <= n ， n 是 size。
	
	
	EX:	
		Input:[4,3,2,7,8,2,3,1]
		Output:[5,6]
*/
public class Solution {
	
	public static void main(String args[]) {
		int[] nums = { 4,3,2,7,8,2,3,1 };
		
		(new Solution()).findDisappearedNumbers(nums);
		
		printArray(nums);
	}
	
	
	public List<Integer> findDisappearedNumbers(int[] nums) {
		
		int index = 0;
		while (index < nums.length) {
			int number = nums[index];
			if (nums[index] != (index + 1) && nums[index] != nums[number - 1]) {
				int tmp = nums[index];
				nums[index] = nums[number - 1];
				nums[number - 1] = tmp;
			}
			if (nums[index] == (index + 1) || nums[index] == nums[number - 1]) index ++;
		}
		
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != (i + 1)) list.add(i + 1);
		}
		
        return list;
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