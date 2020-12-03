/**
	Url: https://leetcode.com/problems/group-anagrams/
	Author: MiLinSoQ
	Time: 2020-12-03
	Title: Group Anagrams
	No: 49
*/
import java.util.*;
/**
	
	給一個 String Array (strs)，收集並整理回傳 Array 中的 String 有錯位詞，
	錯位詞定義 abc、bac、cba 它們出現的字母相同，只是位置不同
	
	EX:
		Input: strs = ["eat","tea","tan","ate","nat","bat"]
		Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
		
		Input: strs = [""]
		Output: [[""]]
		
		Input: strs = ["a"]
		Output: [["a"]]

*/
public class Solution {
	
	public static void main(String args[]) {
		String[] s1 = { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> result = (new Solution()).groupAnagrams(s1);
		for (List<String> list : result) {
			System.out.println("----");
			for (String s : list) {
				System.out.println(s);
			}
		}
	}
	
	 public List<List<String>> groupAnagrams(String[] strs) {
		 if (strs == null || strs.length == 0) return new ArrayList<>();
		 Map<String, List<String>> map = new HashMap<>();
		 for (String s : strs) {
			 char[] cs = new char[26];
			 for (char c : s.toCharArray()) cs[c - 'a'] ++;
			 String key = String.valueOf(cs);
			 if (!map.containsKey(key)) map.put(key, new ArrayList());
			 map.get(key).add(s);
		 }
        return new ArrayList(map.values());
    }
}

 