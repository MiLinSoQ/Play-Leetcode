/**
	Url: https://leetcode.com/problems/jump-game/
	Author: MiLinSoQ
	Time: 2022-05-30
	Title: Jump Game
	No: 55
*/
import java.util.*;
/**
	給一個 Integer Array (nums)，每個數字表示在當前位置的最大跳力（這裡的跳力指的是在當前位置為基礎上能到達的最遠位置）
	，求判斷能不能到達最後一個位置。
	
	EX: 
		Input: nums = [ 2, 3, 1, 1, 4 ]
		Output: true
		Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
	
	EX:
		Input: nums = [3,2,1,0,4]
		Output: false
		Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

*/
public class Solution {
	
	public static void main(String args[]) {
		int[] nums = { 0,2,3 };

		boolean result = canJump(nums);		
		
		System.out.println("result: " + result);
	}
	
    public static boolean canJump(int[] nums) {

		int size = nums.length;
		System.out.println("size: " + size);
		
		int index;
		int step = nums[0];
		if ((step + 1) >= size) return true;
		if (step == 0) return false;
		for (int i = 1; i < (size - 1); i ++) {
			step --;
			int value = nums[i];
			if (step < value) step = value;
			if (step == 0) return false;
			if ((value + i + 1) >= size) return true;
		}
		
        return false;
    }
}



