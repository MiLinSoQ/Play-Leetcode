/**
	Url: https://leetcode.com/problems/maximum-subarray/
	Author: MiLinSoQ
	Time: 2020-11-26
	Title: Maximum Subarray
	No: 53
*/

/**
	給一個 Integer Array (nums)，找出連續和的最大值 (最少必須包含一個元素)。
	
	EX: 
		Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
		Output: 6
		Explanation: 4 + (-1) + 2 + 1 = 6

*/
public class Solution {
	
	public static void main(String args[]) {
		int[] nums = { -2, -1, -3 };
		int result = (new Solution()).maxSubArray(nums);
		
		System.out.println(String.format("Max: [ %d ]", result));
	}
	
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length <= 0) return 0;
		
		int max = nums[0];
		int sum = 0;
		int cur = 0;
		for (int i = 0; i < nums.length; i ++) {
			cur = nums[i];
			if ((sum + cur) < 0) {
				sum = 0;
				max = (max < cur ? cur : max);
				continue;
			} else {
				sum += cur;
				max = (max < sum ? sum : max);
			}
		}
		return max;
    }
}