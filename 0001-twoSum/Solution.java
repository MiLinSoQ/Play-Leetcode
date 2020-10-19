/**
	Url: https://leetcode.com/problems/two-sum/
	Author: MiLinSoQ
	Time: 2020-10-19
	Title: Two Sum
	No: 1
*/

public class Solution {
	
	public static void main(String args[]) {
		
		int[] arr = { 5, 2, 3, 8, 12, 11 };
		

		int[] res = (new Solution()).twoSum(arr, 0);		
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + ", ");
		}
	}
	
	
	public int[] twoSum(int[] nums, int target) {
        
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++ ) {
				
				if ((nums[i] + nums[j]) == target) {
					
					int[] res = {i, j};
					return res;
				}
			}
		}
		
		throw new IllegalArgumentException("No soluation.");
		// return null;
    }
}