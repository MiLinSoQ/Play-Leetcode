/**
	Url: https://leetcode.com/problems/single-number/
	Author: MiLinSoQ
	Time: 2020-10-30
	Title: Single Number
	No: 136
*/

import java.util.*;

/**
	給一個 Array (nums)，這個 Array 的元素都是成對的，
	其中有一個元素是只有單一一個的，找出並回傳。
	
	EX: 
		Input: nums = [2,2,1]
		Output: 1
		
		Input: nums = [4,1,2,1,2]
		Output: 4
*/
public class Solution {
	
	public static void main(String atgs[]) {
		int[] nums = { 2 ,2 ,1 ,1 ,3};
		
		int res = (new Solution()).singleNumber(nums);
		
		System.out.println("The single number is: " + res);
	}
	
    public int singleNumber(int[] nums) {
		
		Arrays.sort(nums);
		
		for (int i = 0; i < nums.length; i += 2) {
			if ((i + 1) >= (nums.length)) {
				return nums[nums.length - 1];
			}
			
			System.out.println(i + ": " + nums[i]);
			System.out.println(i + 1 + ": " + nums[i + 1]);
			System.out.println("----");
			
			if (nums[i] != nums[i + 1]) return nums[i];
		}
		
        return -1;
    }
}