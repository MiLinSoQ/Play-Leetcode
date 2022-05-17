/**
	Url: https://leetcode.com/problems/longest-common-prefix/
	Author: MiLinSoQ
	Time: 2022-05-17
	Title: Longest Common Prefix
	No: 14
*/

import java.util.*;

public class Solution {
	
	public static void main(String args[]) {
			
			String strs[] = { "fleax", "fle" };
			
			
			Solution solution = new Solution();
			
			String common = solution.longestCommonPrefix2(strs);
			
			System.out.println("common: " + common);
			
			
	}
	
	public String longestCommonPrefix2(String[] strs) {
		if (strs.length == 0) return "";
		
		String prefix = strs[0];
		for (int i = 1; i < strs.length; i ++) {
			while (strs[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
				if (prefix.isEmpty()) return prefix;
			}
		}
		return prefix;
	}
	
	public String longestCommonPrefix(String[] strs) {
		String ret = new String();
		if (strs.length == 0) return ret;
		if (strs.length == 1) return strs[0];
		
		String minString = strs[0];
		for (String str : strs) {
			if (str.length() < minString.length()) {
				minString = str;
			}
		}
		int minIndex = minString.length();
		
		System.out.println("min length:" + minIndex);
		int arrayLength = strs.length;
        for (int i = 1; i < arrayLength; i++) {
			String compareStringA = strs[0].substring(0, minIndex);
			String compareStringB = strs[i].substring(0, minIndex);
			if (compareStringA.equals(compareStringB)) {
				if (i == (arrayLength - 1)) {
					ret	 = compareStringA;
				}
				continue;
			} else {
				minIndex --;
				i = 0;
			}
		}
        return ret;
    }
}