/**
	Url: https://leetcode.com/problems/length-of-last-word/
	Author: MiLinSoQ
	Time: 2020-12-10
	Title: Length of Last Word
	No: 58
*/
import java.util.*;
/**
	
	給一個 String (s)，取得最後一個單字的長度。
	
	EX: 
		Input: s = "Hello World"
		Output: 5
		

*/
public class Solution {
	
	public static void main(String args[]) {
		String s = "Hello World";
		int result = (new Solution()).lengthOfLastWord(s);
		System.out.println(String.format("The last word length: [ %d ]", result));
	}
	
	public int lengthOfLastWord(String s) {
		int result = 0;
		s = s.trim();
		for (int i = s.length() - 1; i >= 0; i --) {
			if (s.charAt(i) == ' ') return result;
			result ++;
		}
        return result;
    }
	
}

 