/**
	Url: https://leetcode.com/problems/longest-substring-without-repeating-characters/
	Author: MiLinSoQ
	Time: 2020-12-09
	Title: Longest Substring Without Repeating Characters
	No: 3
*/
import java.util.*;
/**
	
	給一個 String (s)，找到字母不重複最長的字串組合，並回傳長度。
	
	EX:
		Input: s = "abcabcbb"
		Output: 3
		Explanation: The answer is "abc", with the length of 3.
		

*/
public class Solution {
	
	public static void main(String args[]) {
		String s = "abcabcbb";
		int result = (new Solution()).lengthOfLongestSubstring(s);
		System.out.println(String.format("The longer without repeating: %d.", result));
	}
	
	public int lengthOfLongestSubstring(String s) {
		
		HashMap<Character, Integer> map = new HashMap();
		
		int result = 0;
		int index = 0;
		for (int i = 0; i < s.length(); i ++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				index = Math.max(index, map.get(c) + 1);
			}
			map.put(c, i);
			
			result = Math.max(result, i - index + 1);
		}
		return result;
    }
	
	public int lengthOfLongestSubstring2(String s) {
		String longest = "", current = "";
		for (int i = 0; i < s.length(); i ++) {
			char c = s.charAt(i);
			if (!current.contains(c + "")) {
				current += (c + "");
			} else {
				current = current.substring(current.indexOf(c) + 1, current.length());
				current += (c + "");
			}
			if (longest.length() < current.length())
				longest = current;
			
		}
		return longest.length();
    }
	
}

 