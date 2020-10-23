/**
	Url: https://leetcode.com/problems/search-in-rotated-sorted-array/
	Author: MiLinSoQ
	Time: 2020-10-23
	Title: Search in Rotated Sorted Array
	No: 33
*/

/**
	�ǤJ�@�� Intreger array (nums) & Integer (target)
	�b�o�Ӱ}�C����� target �C
	�ϥΤG���j�M�k�A�B�o�Ӱ}�C�O"����ƧǼƲ�"�C
	�@��ƧǲզX�G [0,1,2,4,5,6,7]�A����ƧǲզX:  [4,5,6,7,0,1,2]�C
	�p�G�䤣�� target �^�� -1�C
	
	EX:
		Input: nums = [4,5,6,7,0,1,2], target = 0
		Output: 4
*/

public class Solution {
	
	public static void main(String args[]) {
		
		int[] nums = {4,5,6,7,0,1,2};
		int target = 4;
		
		int res = (new Solution()).search(nums, target);
		System.out.println("search index: " + res);
		
	}
	
    public int search(int[] nums, int target) {
		
		int lIndex = 0;
		int rIndex = nums.length - 1;
		int mIndex = 0;
		while (lIndex <= rIndex) {
			
			mIndex = (lIndex + rIndex) / 2;
			
			if (nums[mIndex] == target) return mIndex;
			
			// �p�G������Ъ��� <= �������Ъ��ȡA��ܰ}�C�����Ы��Ш줤�����ЬO���ƧǪ��C
			if (nums[lIndex] <= nums[mIndex]) {
				
				// target �O�_�b�o�ӱƧǤ����A�p�G�O�N�b�o�Ӱ϶��� target�C
				if (nums[lIndex] <= target && nums[mIndex] > target) {
					rIndex = mIndex - 1;
				} else {
					lIndex = mIndex + 1;
				}
			} else {	// �������Ш�k����ЬO���ƧǪ�
				
				if (nums[rIndex] >= target && nums[mIndex] < target) {
					lIndex = mIndex + 1;
				} else {
					rIndex = mIndex - 1;
				}
			}
		}
		
        return -1;
    }
}