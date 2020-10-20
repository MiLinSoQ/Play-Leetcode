/**
	Url: https://leetcode.com/problems/3sum/
	Author: MiLinSoQ
	Time: 2020-10-20
	Title: 3Sum
	No: 15
*/
import java.util.*;

public class Solution {
	
	public static void main(String args[]) {
		
		// int[] arr = { -1,0,1,2,-1,-4 };
		
		// int[] arr = { 0,0,0 };
		
		// int[] arr = {  };
		
		// int[] arr = { 0 };
		
		// int[] arr = { 0, 0, 0, 0 };
		
		// int[] arr = { 1, -1, -1, 0 };
		
		int[] arr = { -2,0,0,2,2 };
		
		List<List<Integer>> list = (new Solution()).threeSum(arr);
		
		for (int i = 0; i < list.size(); i++) {
			List<Integer> tempList = (List<Integer>) list.get(i);
			for (int j = 0; j < tempList.size(); j++) {
				System.out.print(tempList.get(j));
				if (j != tempList.size() - 1) System.out.print(", ");
			}
			System.out.println();
		}
	}
	
	public List<List<Integer>> threeSum(int[] nums) {
		
		if (nums == null || nums.length <= 0) return new ArrayList<>();
		
		// 先排序，由小到大。
		int temp;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] < nums[j]) continue;
				temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			}
		}
		
		// 如果陣列中最小值 > 0 | 最大值 < 0，直接回傳。
		if (nums[0] > 0 || nums[nums.length - 1] < 0) return new ArrayList<>();
		
		List<List<Integer>> resultList = new ArrayList<>();
		List<Integer> tempList;
		int sum = 0;
		for (int index = 0; index < nums.length; ++index) {
			
			if (nums[index] > 0) break;
			
			// 與上一個值一樣，不需要再做一次，直接跳過。
			if (index > 0 && nums[index] == nums[index - 1]) continue;
			
			int leftIndex = index + 1;
			int rightIndex = nums.length - 1;
			
			while (leftIndex < rightIndex) {
				// System.out.println("leftIndex: " + nums[leftIndex]);
				// System.out.println("rightIndex: " + nums[rightIndex]);
				
				sum = nums[index] + nums[leftIndex] + nums[rightIndex];
				
				if (sum == 0) {
					// System.out.println(nums[index] + ", " + nums[leftIndex] + "," + nums[rightIndex]);
					
					tempList = new ArrayList<>();
					tempList.add(nums[index]);
					tempList.add(nums[leftIndex]);
					tempList.add(nums[rightIndex]);
					resultList.add(tempList);
					
					// 有連續重複的數值，可以跳過，不需要再多做一次。
					while (leftIndex < rightIndex && nums[leftIndex] == nums[leftIndex + 1]) ++leftIndex;
					while (leftIndex < rightIndex && nums[rightIndex] == nums[rightIndex - 1]) --rightIndex;
					
					leftIndex++;
					rightIndex--;
					
				} else if (sum > 0) {
					rightIndex--;
				} else { // sum < 0
					leftIndex++;
				}
			}
		}
		return resultList;
    }
}