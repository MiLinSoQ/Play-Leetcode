/**
	Url: https://leetcode.com/problems/longest-palindromic-substring/
	Author: MiLinSoQ
	Time: 2020-12-14
	Title: Longest Pailindromic Substring
	No: 5
*/
import java.util.*;
/**
	
	給一個 String (s)，回傳最長的回文字串。
	
	EX:
		Input: s = "babad"
		Output: "bab"
		Note: "aba" is also a valid answer.
		

*/
public class Solution {
	
	public static void main(String args[]) {
		String s = "abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa";
		String result = (new Solution()).longestPalindrome(s);
		System.out.println(String.format("The longer palindromic string is : [ %s ].", result));
		
		boolean b = (new Solution()).isPalindrome(s);
		System.out.println("Is palindromic: " + b);
		
	}
	
	// public String longestPalindrome(String s) {
		// if (s.length() < 2) return s;
		// int indexL = 0;
		// int indexR = 0;
		// String result = "";
		
		// return "";
	// }
	
	public String longestPalindrome(String s) {
		if (s.length() < 2) return s;
		int index = 0;
		String result = s.substring(0, 1);
		for (int i = 0; i < s.length(); i ++){
			for (int j = s.length(); j > i; j --) {
				String temp = s.substring();
				if (isPalindrome(s, i, j) && temp.length() > result.length()) {
						result = temp;
				}
			}
		}
        return result;
    }
	
	
	private boolean isPalindrome(String s) {
		if (s.length() < 2) return false;
		
		char[] ch = s.toCharArray();
		int indexR = s.length() - 1;;
		int indexL = 0;
		while (indexL < indexR) {
			if (ch[indexL ++] != ch[indexR --]) return false;
		}
		return true;
	}
}

 