/**
	Url: https://leetcode.com/problems/merge-sorted-array/
	Author: MiLinSoQ
	Time: 2022-06-01
	Title: Merge Sorted Array
	No: 88
*/

/**
	給定兩個整數數組 nums1 和 nums2，按非遞減順序排序，以及兩個整數 m 和 n，分別表示 nums1 和 nums2 中的元素個數。
	
	EX: 
		Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
		Output: [1,2,2,3,5,6]
		Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
		The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
		
		Input: nums1 = [1], m = 1, nums2 = [], n = 0
		Output: [1]
		Explanation: The arrays we are merging are [1] and [].
		The result of the merge is [1].

*/
public class Solution {
	
	public static void main(String args[]) {
		int[] nums1 = { 4,5,6,0,0,0 };
		int[] nums2 = { 1,2,3 };
		int m = 3;
		int n = 3;
		
		
		merge(nums1, m , nums2, n);
		for (int i : nums1) {
			System.out.println("num1: " + i);
		}
		System.out.println("--");
		for (int i : nums2) {
			System.out.println("num2: " + i);
		}
	}
    
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		
		if (nums1.length != (m + n)) return;
		
		
		int i = 0;
		int j = 0;
		while (i < (m + n) && j < n) {
			
			if (i >= m) {
				nums1[i] = nums2[j];
				j ++;
			} else if (nums1[i] > nums2[j]) {
				int tmp = nums1[i];
				nums1[i] = nums2[j];
				nums2[j] = tmp;
				
				int p = j;
				for (int k = 1; k < n; k ++) {
					if (nums2[p] > nums2[k]) {
						tmp = nums2[p];
						nums2[p] = nums2[k];
						nums2[k] = tmp;
						p ++;
					} else {
						break;
					}
				}
			}
			i ++;
			
		}
		
		
		
	}
}