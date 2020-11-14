/**
	Url: https://leetcode.com/problems/house-robber/
	Author: MiLinSoQ
	Time: 2020-11-03
	Title: House Robber
	No: 198
*/
/**
	你是一個專業的小偷，今天你打算偷遍一整條街的房子，每間房子都一定有錢可以偷。
	不過有一個問題，就是房子之間有設警報系統，如果你連偷兩間相鄰的房子，警報系統就會引來警察，你就會被抓。
	這邊會給一個list，裡面每個元素都代表這間房子內可以偷到的錢，你要怎麼安排你的偷竊計畫才能偷到最多的錢而且不會驚動警察。
	
	EX:
		Input: nums = [1,2,3,1]
		Output: 4
		Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3). Total amount you can rob = 1 + 3 = 4.
*/
public class Solution {
	
	public static void main(String args[]) {
		int[] nums = { 1, 2, 4, 1, 7, 8, 3 };
		
		int result = (new Solution()).rob(nums);
		
		System.out.println(result);
	}
	

	public int rob(int[] nums) {
		if (nums == null || nums.length <= 0) return 0;
		if (nums.length == 1) return nums[0];
		if (nums.length == 2) return (nums[0] > nums[1]) ? nums[0] : nums[1];

		int[] opt = new int[nums.length];
		opt[0] = nums[0];
		opt[1] = (nums[0] > nums[1]) ? nums[0] : nums[1];

		for (int i = 2; i < nums.length; i ++) {
			int A = opt[i - 2] + nums[i];
			int B = opt[i - 1];
			opt[i] = (A > B) ? A : B;
		}

		return opt[opt.length - 1];
	}


	 // public int rob(int[] nums) {
		//  if (nums == null || nums.length <= 0) return 0;
		 
		//  int max1 = 0;
		//  int max2 = 0;
		//  for (int i = 0; i < nums.length; i++) {
		// 	 if ((i % 2) == 0) {
		// 		 max1 += nums[i];
		// 	 } else {
		// 		 max2 += nums[i];
		// 	 }
		//  }
		 
  //       return (max1 > max2 ? max1 : max2);
  //   }
	
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