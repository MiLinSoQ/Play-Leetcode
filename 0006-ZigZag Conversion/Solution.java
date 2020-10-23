/**
	Url: https://leetcode.com/problems/zigzag-conversion/
	Author: MiLinSoQ
	Time: 2020-10-23
	Title: ZigZag Conversion
	No: 6
*/

/**
	傳入一個 String (s) & Integer (numRows)
	將 s 字串以 numRow 為高度轉換排序。
	
	EX: 
		
		1	A				E
			
			↓			↗	↓
		
		2	B		D		F
	
			↓	↗			↓
			
		3	C				G
		
		
		Input: s = "ABCDEFG", numRows = 3
		Output: "AEBDFCG"
	
*/
public class Solution {
	
	public static void main(String args[]) {
		
		String s = "ABCDEFG";
		int rows = 3;
		
		(new Solution()).convert(s, rows);
	}
	
    public String convert(String s, int numRows) {
		if (numRows <= 1) return s;
		System.out.println(s + ", " + numRows);
		
		String[] tempStrings = new String[numRows];
		for (int i = 0; i < numRows; i++) tempStrings[i] = "";
		
		int r = 1; 
		boolean isDown = true;
		for (int i = 0; i < s.length(); i++) {
						
			String tempS = s.substring(i, i +1);
			tempStrings[r - 1] += tempS;

			if (isDown) {
				r++;
				isDown = (r != numRows);
			} else {
				r--;
				isDown = (r == 1);
			}
		}
		
		String res = "";
		for (int i = 0; i < tempStrings.length; i++) {
			System.out.println((i + 1) + " -> " + tempStrings[i]);
			res += tempStrings[i];
		}
		
		System.out.println(res);
		
		return res;
    }
}


