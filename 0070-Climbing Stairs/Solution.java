/**
	Url: https://leetcode.com/problems/climbing-stairs/
	Author: MiLinSoQ
	Time: 2020-11-14
	Title: Climbing Stairs
	No: 70
*/

/**
	
	給一個樓梯的階數 (n)，回傳可以用幾種方式爬樓梯
	每次走樓梯只能走 1 階或 2 階。
	
	EX:
		
		Input: n = 2
		Output: 2
		1. 1 step + 1 step
		2. 2 strp
		
		Input: n = 3
		Output: 3
		1. 1 step + 1 step + 1 step
		2. 1 step + 2 steps
		3. 2 steps + 1 step

*/
public class Solution {
	
	
	public static void main(String args[]) {
		int n = 3;
		int ways = (new Solution()).climbStairs2(n);
		System.out.println("Distnct ways: " + ways);
	}
	
	// 遞迴的寫法。
    public int climbStairs(int n) {
        if (n == 1) return 1;
		if (n == 2) return 2;
		return climbStairs(n - 1) + climbStairs(n - 2);
    }
	
	// 非遞迴寫法。
	public int climbStairs2(int n) {
		if (n <= 0) return 0;
		if (n == 1 || n == 2) return n;
		
		int[] nums = new int[n];
		nums[0] = 1;
		nums[1] = 2;
		
		for (int i = 2; i < n; i ++) {
			nums[i] = nums[i - 1] + nums[i - 2];
		}
		return nums[n - 1];
	}
}