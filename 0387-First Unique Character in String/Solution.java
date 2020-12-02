/**
	Url: https://leetcode.com/problems/first-unique-character-in-a-string/
	Author: MiLinSoQ
	Time: 2020-12-02
	Title: Design HashSet
	No: 387
*/

/**
	給一個 String (s)，找出第一個不重複的字，回傳index
	
	
	
	EX: 
		s = "leetcode"
		return 0.

		s = "loveleetcode"
		return 2.

*/
public class Solution {
	
	public static void main(String args[]) {
		String s = "loveleetcode";
		int result = (new Solution()).firstUniqChar(s);
		System.out.println("The uniq index is : " + result);
	}
	
	public int firstUniqChar(String s) {
		int[] nums = new int[26];
		
		for (int i = 0; i < s.length(); i ++) {
			int index = s.charAt(i) - 'a';
			nums[index]++;
		}
		
		for (int i = 0; i < s.length(); i ++) {
			int index = s.charAt(i) - 'a';
			if (nums[index] == 1) return i;
		}
		
        return -1;
    }
}