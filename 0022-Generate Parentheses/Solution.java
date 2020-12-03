/**
	Url: https://leetcode.com/problems/generate-parentheses/
	Author: MiLinSoQ
	Time: 2020-12-02
	Title: Generate Parentheses
	No: 22
*/
import java.util.*;
/**
	給一個 Integer (n)，設計一個函數，生成 n 對括號可以產生所有的組合。
	
	
	EX: 
		Input: n = 1
		Output: ["()"]
		
		Input: n = 3
		Output: ["((()))","(()())","(())()","()(())","()()()"]

*/
public class Solution {
	
	public static void main(String args[]) {
		
		int n = 3;
		
		List<String> result = (new Solution()).generateParenthesis(n);
		
		for (int i = 0; i < result.size(); i ++) {
			System.out.println(result.get(i));
		}
		
	}
	
	public List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<String>();
		int left = n;
		int right = n;
		generate(list, left, right, "");
        return list;
    }
	
	private void generate(List<String> list, int left, int right, String curP) {
		if (left == 0 && right == 0) {
			list.add(curP);
			return;
		}
		if (left > 0) {
			generate(list, left - 1, right, curP + '(');
		}
		
		if (right > left) {
			generate(list, left, right - 1, curP + ')');
		}
	}
	
}


 