/**
	Url: https://leetcode.com/problems/counting-bits/
	Author: MiLinSoQ
	Time: 2020-11-26
	Title: Counting Bits
	No: 338
*/

/**
	給一個正整數 (num)， 計算從 0 開始到這個數相應的二進位制數中有多少個 1。
	
	EX: 
		Input: 2
		Output: [0,1,1]
		
		Input: 5
		Output: [0,1,1,2,1,2]

*/
public class Solution {
	
	
	public static void main(String args[]) {
		
		
		int num = 0;
		int[] result = (new Solution()).countBits(num);
		
		for (int i = 0; i < result.length; i ++) {
			System.out.print(result[i]);
			if (i != result.length - 1)
				System.out.print(", ");
		}
 		
	}
	
    public int[] countBits(int num) {
		
		if (num <= 0) return new int[1];
		
		int[] result = new int[num + 1];
		result[0] = 0;
		
		for (int i = 1; i <= num; i++) {
			if ((i % 2) == 0) {
				result[i] = result[i / 2];
			} else {
				result[i] = result[i / 2] + 1;
			}
		}
		return result;
    }
}






