/**
	Url: https://leetcode.com/problems/shuffle-the-array/
	Author: MiLinSoQ
	Time: 2020-11-28
	Title: Shuffle the Array
	No: 1470
*/

/**
	給一個 Integer Array (nums) & Integer (n)
	這個 nums 的長度為 2n，這個陣列的內容為 [ x1, x2, x3, y1, y2, y3 ]
	回傳一個新的陣列，陣列的內容為 [ x1, y1, x2, y2, x3, y3 ]

	
	EX: 
		Input: nums = [2,5,1,3,4,7], n = 3
		Output: [2,3,5,4,1,7] 
		Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].
		
	
*/
public class Solution {
	
	public static void main(String args[]) {
		
		int[] nums = { 2,5,1,3,4,7 };
		int n = 3;

		int[] ans = (new Solution()).shuffle(nums, n);

		for (int i = 0; i < ans.length; i ++) {
			System.out.print(ans[i]);
			if (i != ans.length - 1) {
				System.out.print(", ");
			}
		}

		// System.out.println(String.format("Shuffle: [ %d ]", ans));
		
	}

	public int[] shuffle(int[] nums, int n) {
		int[] result = new int[2 * n];
		int index = 0;
		int index1 = 0;
		int index2 = n;

		while (index2 != (2 * n)) {
			result[index ++] = nums[index1 ++];
			result[index ++] = nums[index2 ++];
		}
        return result;
    }
}