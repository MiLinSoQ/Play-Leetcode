/**
	Url: https://leetcode.com/problems/3sum-closest/
	Author: MiLinSoQ
	Time: 2020-10-27
	Title: 3Sum Closest
	No: 16
*/
import java.util.*;

/**
	傳入一個 Integers (nums) & Integer (target)
	在 nums 中找出三個值相加最接近 target 的
	
	Input: nums = [-1,2,1,-4], target = 1
	Output: 2
	Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
	
*/
public class Solution {
	
	public static void main(String args[]) {
		
		int[] arr = { -1, 2, 1, -4, 5 };
		int target = 3;
		
		int res = (new Solution()).threeSumClosest(arr, target);
		System.out.println(String.format("The closest is: [ %d ]", res));
	}
	
	public int threeSumClosest(int[] nums, int target) {
		if (nums.length < 3) return 0;
		int clo = nums[0] + nums[1] + nums[2];
		int diff = target - clo;
		diff *= (diff < 0 ? -1 : 1);
		
		Arrays.sort(nums);
		
		for (int i = 0; i < nums.length - 2; i++) {
			
			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				int newDiff = sum - target;
				newDiff *= (newDiff < 0 ? -1 : 1);
				
				if (newDiff < diff) {
					diff = newDiff;
					clo = sum;
				}
				
				if (sum < target) {
					left++;
				} else {
					right--;
				}
			}
		}
        return clo;
    }
}


