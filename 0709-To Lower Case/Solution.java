/**
	Url: https://leetcode.com/problems/to-lower-case/
	Author: MiLinSoQ
	Time: 2020-12-02
	Title: To Lower Case
	No: 709
*/

/**
	實現一個 ToLowerCase()，回傳小寫的英文字母。
	
	Example 1:

		Input: "Hello"
		Output: "hello"
		
	Example 2:

		Input: "here"
		Output: "here"
		
	Example 3:

		Input: "LOVELY"
		Output: "lovely"

*/
public class Solution {
	
	public static void main(String args[]) {
		String str = "HELLO";
		String result = (new Solution()).toLowerCase(str);
		
		System.out.println(result);
	}
	
	public String toLowerCase(String str) {
		char[] cs = str.toCharArray();
		for (int i = 0; i < str.length(); i ++) {
			if (cs[i] >= 'A' && cs[i] <= 'Z') {
				cs[i] = ((char) (cs[i] + 32));
			}
		}
		return new String(cs);
    }
}


 