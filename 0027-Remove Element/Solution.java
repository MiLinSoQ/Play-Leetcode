/**
	Url: https://leetcode.com/problems/remove-element/
	Author: MiLinSoQ
	Time: 2020-10-21
	Title: Remove Element
	No: 27
*/
/**
	傳入一個 Integers (nums) & Integer (val)。
	將 nums 中的 val 全部刪除，
	回傳 nums 新的長度。
	注意不要開新的陣列空間，元素的順序可以更改。 超出新長度後剩下的都無所謂。
	
	EX: 
		Input: nums = [3,2,2,3], val = 3
		Output: 2, nums = [2,2]
		
		Input: nums = [0,1,2,2,3,0,4,2], val = 2
		Output: 5, nums = [0,1,4,0,3]
*/
public class Solution {
	
	public static void main(String args[]) {
		
		
		 int[] arr = { 3, 2, 2, 3 };
		// int[] arr = { 0,1,2,2,3,0,4,2 };
		int val = 2;
		
		int result = (new Solution()).removeElement(arr, val);
		
		System.out.println(result);
		
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
	}
	
	
	public int removeElement(int[] nums, int val) {
		
		
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			
			if (nums[i] != val) {
				nums[result++] = nums[i];
			}
		}
		return result;
		
    }
	
}