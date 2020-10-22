/**
	Url: https://leetcode.com/problems/remove-element/
	Author: MiLinSoQ
	Time: 2020-10-21
	Title: Remove Element
	No: 27
*/
/**
	�ǤJ�@�� Integers (nums) & Integer (val)�C
	�N nums ���� val �����R���A
	�^�� nums �s�����סC
	�`�N���n�}�s���}�C�Ŷ��A���������ǥi�H���C �W�X�s���׫�ѤU�����L�ҿסC
	
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