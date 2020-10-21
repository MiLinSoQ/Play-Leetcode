/**
	Url: https://leetcode.com/problems/palindrome-number/
	Author: MiLinSoQ
	Time: 2020-10-21
	Title: Palindrome Numbers
	No: 9
*/
import java.util.*;

public class Solution {
	
	public static void main(String args[]) {
		int x = 10;
		System.out.println((new Solution()).isPalindrome(x));
	}
	
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
		
		int carry = 10;
		int res = x;
		List<Integer> arr = new ArrayList<>();
		while (res != 0) {
			int rem = (res % carry);
			res -= rem;
			res /= 10;
			// System.out.println("res: " + res + ", carry: " + carry);
			arr.add(rem / (carry / 10));
		}
		
		carry = 1;
		for (int i = arr.size() - 1; i >= 0; i--) {
			System.out.println("arry: " + arr.get(i) + " * " + carry);
			res += arr.get(i) * carry;
			carry *= 10;
		}
		
		System.out.println("res: " + res + ", x: " + x);
		
		return res == x;
    }
}