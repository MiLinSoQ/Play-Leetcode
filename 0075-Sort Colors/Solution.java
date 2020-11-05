/**
	Url: https://leetcode.com/problems/sort-colors/
	Author: MiLinSoQ
	Time: 2020-11-05
	Title: Sort Colors
	No: 75
*/

/**
	給一個 Integer Array (nums)，其中的數字代表顏色，
	0 -> 紅色
	1 -> 白色
	2 -> 藍色
	請將 nums 由小到大排序。
	
	EX: 
		Input: nums = [2,0,2,1,1,0]
		Output: [0,0,1,1,2,2]

*/
public class Solution {
	
	
	public static void main(String args[]) {
		
		int[] nums = { 2,0,2,1,1,0,2,1,2,1,0,1,0,0,0};
		
		
		(new Solution()).sortColors(nums);
		
		for (int i = 0; i < nums.length; i ++) {
			System.out.print(nums[i]);
		}
		// System.out.println("index: " + result);
	}
	
	// 這邊練習計數排序 counting sort。
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 0) return;
		
		int red = 0;
		int white = 0;
		int blue = 0;
		
		for (int i = 0; i < nums.length; i ++) {
			if (nums[i] == 0) red ++;
			if (nums[i] == 1) white ++;
			if (nums[i] == 2) blue ++;
		}
		
		for (int i = 0; i < nums.length; i ++) {
			if (red > 0) {
				nums[i] = 0;
				red --;
			} else if (white > 0) {
				nums[i] = 1;
				white --;
			} else { // blue > 0
				nums[i] = 2;
				blue --;
			}
		}
    }
}