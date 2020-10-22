/**
	Url: https://leetcode.com/problems/valid-parentheses/
	Author: MiLinSoQ
	Time: 2020-10-22
	Title: Valid Parentheses
	No: 20
*/
import java.util.*;

/**
	傳入 String (s)，確認 "()[]{}" 是否成對。
	成對回傳 true
	不成對回傳 false
	
	EX: 
		Input: s = "()[]{}"
		Output: true
		
		Input: s = "([)]"
		Output: false
*/
public class Solution {
	
	public static void main(String args[]) {
		String s = "(({{{}}}))";
		System.out.println(s);
		boolean b = (new Solution()).isValid(s);
		System.out.println("Is valid: " + b);
	}
	
    public boolean isValid(String s) {
		
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			
			char c = s.charAt(i);
			if (c == '(' || c == '[' || c == '{') stack.push(c);
			if (c == ')' || c == ']' || c == '}') {
				if (stack.isEmpty()) return false;
				char c2 = stack.pop();
				if (c2 == '(' && c != ')') return false;
				if (c2 == '[' && c != ']') return false;
				if (c2 == '{' && c != '}') return false;
			}
		}
        return stack.isEmpty();
    }
}