/**
	Url: https://leetcode.com/problems/roman-to-integer/
	Author: MiLinSoQ
	Time: 2020-10-20
	Title: Roman To Integer
	No: 13
*/
import java.util.*;
/**
	傳入一個 String (s)， 此 s 是羅馬數字，
	將羅馬數字轉換成阿拉伯數字。
	
	羅馬       	阿拉伯	
	I             1
	V             5
	X             10
	L             50
	C             100
	D             500
	M             1000
	IV			  4
	IX			  9
	XL			  40
	XC			  90
	CD			  400
	CM			  900
	

*/
public class Solution {
	
	public static void main(String args[]) {
		String romString = "MCMXCIV";
		int result = (new Solution()).romanToInt(romString);
		System.out.println(String.format("Roman [ %s ] = [ %d ]", romString, result));
	}
	
	public int romanToInt(String s) {
		// if (s == null || s.length() < 1 || s.length() > 15) throw new IllegalArgumentException("Error, s is illegal.");
		Map<Character, Integer> rMap = new HashMap<>();
		rMap.put('I', 1);
		rMap.put('V', 5);
		rMap.put('X', 10);
		rMap.put('L', 50);
		rMap.put('C', 100);
		rMap.put('D', 500);
		rMap.put('M', 1000);
		
		int result = 0; 
		for (int i = 0; i < s.length(); i++) {
			if ((i + 1) < s.length() && rMap.get(s.charAt(i)) < rMap.get(s.charAt(i + 1))) {
				result += rMap.get(s.charAt(i + 1)) - rMap.get(s.charAt(i));
				i++;
			} else {
				result += rMap.get(s.charAt(i));
			}
		}
        return result;
    }
}