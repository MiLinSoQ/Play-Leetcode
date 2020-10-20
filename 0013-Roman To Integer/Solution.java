/**
	Url: https://leetcode.com/problems/roman-to-integer/
	Author: MiLinSoQ
	Time: 2020-10-20
	Title: Roman To Integer
	No: 13
*/
import java.util.*;

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