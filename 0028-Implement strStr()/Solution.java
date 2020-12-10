/**
	Url: https://leetcode.com/problems/implement-strstr/
	Author: MiLinSoQ
	Time: 2020-12-10
	Title: Length of Last Word
	No: 28
*/
import java.util.*;
/**
	
	給兩個 String (haystack) & (needle)，
	在 haystack 中找出 needle，如果找不到回傳 -1，找到回傳 index
	
	
	EX: 
		Input: haystack = "hello", needle = "ll"
		Output: 2
		
		Input: haystack = "aaaaa", needle = "bba"
		Output: -1
		

*/
public class Solution {
	
	public static void main(String args[]) {
		String haystack = "Hello";
		String needle = "ll";
		int result = (new Solution()).strStr(haystack, needle);
		System.out.println(String.format("The contains index is: [ %d ]", result));
	}
	
	public int strStr(String haystack, String needle) {
		for (int i = 0; i < haystack.length() - needle.length() + 1; i ++) {
			if (haystack.substring(i, i + needle.length()).equals(needle)) return i;
		}
		return -1;
    }
	
}

 