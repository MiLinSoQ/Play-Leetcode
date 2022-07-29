/**
	Url: https://leetcode.com/problems/4sum/
	Author: MiLinSoQ
	Time: 2022-07-29
	Title: 4Sum
	No: 18
*/
import java.util.*;

/**
	給定一個包含 n 個整數的數組 nums，返回一個包含所有唯一四元組 [nums[a], nums[b], nums[c], nums[d]] 的數組，使得：
	
	1. 0 <= a, b, c, d < n
	2. a, b, c, and d are distinct.
	3. nums[a] + nums[b] + nums[c] + nums[d] == target
	
	EX: 
		Input: nums = [1,0,-1,0,-2,2], target = 0
		Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

		Input: nums = [2,2,2,2,2], target = 8
		Output: [[2,2,2,2]]
		
*/
public class Solution {
	
	public static void main(String args[]) {

// 		int nums[] = { 1, 0, -1, 0, -2, 2, 3 };
		int nums[] = { 2, 2, 2, 2, 2 };
		int target = 8;
		
		List<List<Integer>> list = Solution.fourSum(nums, target);
		
		for (int i = 0; i < list.size(); i ++) {
			System.out.println(list.get(i));
		}
	}
	
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> resList = new ArrayList<>();
		
		// 確定陣列長度超 4 
		if (nums.length < 4) return resList;
		
		// 小到大排序
		Arrays.sort(nums);
		
		// 再來是確定陣列中是有 4sum 的答案，
		// 如果最小數值大於 "目標數 / 4"，表示沒有答案
		// 反之最大數小於 "目標數 / 4" ，也表示陣列中沒有 4 個數字和等於目標數
		long averageValue = target / 4;
		if (nums[0] > averageValue || nums[nums.length - 1] < averageValue) return resList;
		

		// i, j, k, l 分別代表陣列中的 index 
		for (int i = 0; i < nums.length - 3; i ++) {
			
			// 如果 index i 的數字與 i - 1 一樣，就跳過，這樣才不會有重複的組合。
			if (i > 0 && nums[i] == nums[i - 1]) continue;
			for (int j = i + 1; j < nums.length - 2; j ++) {
				
				// 這邊與 i 一樣意思，要跳過重複的數字
				if (j > i + 1 && nums[j] == nums[j - 1]) continue;
				
				int k = j + 1;
				int l = nums.length - 1;
				
				// k 與 l index 是從陣列中的前後開始查詢，這樣數度比較快。
				while (k < l) {
					int sum = nums[i] + nums[j] + nums[k] + nums[l];
					// 如果總合小於目標數，表示 k 的數字太小，需要往前移動。
					if (sum < target) {
						k ++;
						while (k < l && nums[k] == nums[k - 1]) k ++;
						
					// 這邊總合大於目標數，表示 l 的數字太大了，要往後一個位置。
					} else if (sum > target) {
						l --;
						while (k < l && nums[l] == nums[l + 1]) l --;
					} else {
						// 總和剛好是目標數，加入到 list 中，k 與 l 分別要位移一個位置，繼續往下查詢。
						resList.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
						k ++;
						l --;
						
						// 跳過重複的數字
						while (k < l && nums[k] == nums[k - 1]) k ++;
						while (k < l && nums[l] == nums[l + 1]) l --;
					}
				}
			}
		}
		
		System.out.println("resList size: " + resList.size());
		
		return resList;
	}
	
	// public static List<List<Integer>> fourSum(int[] nums, int target) {
		
		// List<List<Integer>> resList = new LinkedList<>();
		// if (nums.length < 4) return resList;
		
		// sortInteger(nums);
		
		// long average_value = target / 4;
		// if (nums[0] > average_value || nums[nums.length - 1] < average_value) return resList;
		
		// if (nums[0] == nums[nums.length - 1]) {
			
			// List<Integer> list = new ArrayList<>();
			// list.add(nums[0]);
			// list.add(nums[1]);
			// list.add(nums[2]);
			// list.add(nums[3]);
			// resList.add(list);
			// return resList;
		// }
		
		// for (int i = 0; i < nums.length - 3; i ++) {
			// List<Integer> list = new ArrayList<>();
			
			// for (int j = i + 1; j < nums.length - 2; j ++) {
				
				// for (int k = j + 1; k < nums.length - 1; k ++) {
					
					// for (int m = k + 1; m < nums.length; m ++) {
						
						// if (nums[i] + nums[j] + nums[k] + nums[m] == target) {
							// list.add(nums[i]);
							// list.add(nums[j]);
							// list.add(nums[k]);
							// list.add(nums[m]);
							
							// if (resList.contains(list) == false) {
								// resList.add(list);
							// }
							// list = new ArrayList<>();
						// }
					// }
				// }
			// }
		// }
		// System.out.println();
		// System.out.println("result size: " + resList.size());
		// return resList;
    // }
	
	// public static void sortInteger(int[] nums) {
		// for (int i = 0; i < nums.length - 1; i ++) {
			// int tmp;
			// for (int j = i + 1; j < nums.length; j ++) {
				// if (nums[i] > nums[j]) {
					// tmp = nums[i];
					// nums[i] = nums[j];
					// nums[j] = tmp;
				// }
			// }
		// }
		
		// for (int i = 0; i < nums.length; i ++) {
			// System.out.print(nums[i] + ", ");
		// }
		
		// System.out.println();
	// }
}