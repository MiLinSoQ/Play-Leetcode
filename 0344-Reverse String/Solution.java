/**
	Url: https://leetcode.com/problems/reverse-string/
	Author: MiLinSoQ
	Time: 2020-11-04
	Title: Reverse String
	No: 344
*/

/**
	傳入 Char Array (s) ， 將這個 Array 反轉。
	
	EX: 
		Input: ["h","e","l","l","o"]
		Output: ["o","l","l","e","h"]
		
		
*/
public class Solution {
	
	public static void main(String args[]) {
		// char[] s = { 'h', 'e', 'l', 'l', 'o' };
		char[] s = { 'h','a','n','n','a','H' };
		(new Solution()).reverseString(s);
		
		for (int i = 0; i < s.length; i++) {
			System.out.println("c: " + s[i]);
		}
	}
	
    public void reverseString(char[] s) {
        
		int lIndex = 0;
		int rIndex = s.length - 1;
		
		
		while (lIndex < rIndex) {
			char c = s[lIndex];
			s[lIndex] = s[rIndex];
			s[rIndex] = c;
			
			lIndex ++;
			rIndex --;
		}
    }
}