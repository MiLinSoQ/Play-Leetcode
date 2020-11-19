/**
	Url: https://leetcode.com/problems/majority-element/
	Author: MiLinSoQ
	Time: 2020-11-19
	Title: Majority Element
	No: 169
*/

/**
	
	給一個Integer Array (nums) ， 這個 nums 會有一個元素為"多數"的元素，多數的元素出現次數會 > (nums.length / 2)
	
	
	EX:
		Input: [3,2,3]
		Output: 3
		
		Input: [2,2,1,1,1,2,2]
		Output: 2
*/
public class Solution {
	
	public static void main(String args[]) {
		
		int[] nums = { 2,2,1,1,1,2,2,1,1 };
		
		int result = (new Solution()).majorityElement(nums);
		
		System.out.println(String.format("The majority element is %d", result));
	}
	
	// 利用兩個變數，
	// 第一個變數 (count) 記住元素出現的次數
	// 第二個變數 (temp) 記住這個元素是誰
	// 當 temp 與下一個元素相同 count 會加一，不相同則減一，直到 count 為 0 。
	// 當 count 為 0 temp 會記住新的元素。
	// 當 nums 全部走訪完，temp 會是出現最多次的元素。
	public int majorityElement(int[] nums) {
		int count = 0;
		int temp = 0;
		for (int i = 0; i < nums.length; i ++) {
			if (count == 0) {
				temp = nums[i];
				count ++;
			} else {
				if (temp == nums[i]) {
					count ++;
				} else {
					count --;
				}
			}
		}
        return temp;
    }
}



