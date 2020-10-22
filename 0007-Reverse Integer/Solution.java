/**
	Url: https://leetcode.com/problems/reverse-integer/
	Author: MiLinSoQ
	Time: 2020-10-21
	Title: Reverse Integer
	No: 6
*/
/**
	將 Integer 翻轉，如果溢位回傳 0。
	EX: 321 -> 123
	EX: -120 -> -21
	EX: 1534236469 -> 0
*/

public class Solution {
	
	public static void main(String args[]) {
		
		int t = 1534236469;
		int res = (new Solution()).reverse(t);
		System.out.println(res);
	}
	
	public int reverse(int x) {
		
		if (x == 0) return 0;
		
		int res = 0;
		int cur = x;
		while (cur != 0) {
			
			int oRes = res;
			
			res *= 10;
			int temp = (cur % 10);
			res += temp;
			cur -= temp;
			cur /= 10;
			
			
			if (oRes != (res - temp) / 10) return 0;
			
		}
		
        return res;
    }
}