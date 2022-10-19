/**
	Url: https://leetcode.com/problems/integer-to-roman/
	Author: MiLinSoQ
	Time: 2020-10-20
	Title: Container With Most Water 
	No: 11
*/
/**
	給一個數字 (num)，將數字轉換成羅馬數字。
	
	  1 <= num <= 3999
	
	Symbol       Value
	I             1
	II			  2
	IV			  4
	V             5
	IX			  9
	X             10
	XL			  40
	L             50
	XC			  90
	C             100
	CD			  400
	D             500
	CM			  900
	M             1000
	
	
	
	EX:
		Input: num = 3
		Output: "III"
		Explanation: 3 is represented as 3 ones.
		
		Input: num = 58
		Output: "LVIII"
		Explanation: L = 50, V = 5, III = 3.
		
		Input: num = 1994
		Output: "MCMXCIV"
		Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
		
*/
import java.util.*;

public class Solution {
	
	public static void main(String args[]) {
		int num = 2996;
		
		String res = Solution.intToRoman(num);
		
		System.out.println("res: " + res);
		
		// System.out.println("num: " + num);
	}
	
	
	public static String intToRoman(int num) {
		String roman = new String();
		
		String M[] = { "", "M", "MM", "MMM"};
		String C[] = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
		String X[] = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
		String I[] = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
		
		int max = 1000;
		while (max > 0) {
			int v = num / max % 10;
			
			if (max == 1000) {
				roman += M[v];
			} else if (max == 100) {
				roman += C[v];
			} else if (max == 10) {
				roman += X[v];
			} else {
				roman += I[v];
			}
			
			max /= 10;
		}
		
        return roman;
    }
	
}