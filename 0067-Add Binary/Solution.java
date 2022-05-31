/**
	Url: https://leetcode.com/problems/add-binary/
	Author: MiLinSoQ
	Time: 2022-05-31
	Title: Add Binary
	No: 67
*/
import java.util.*;
/**
	
	給兩個二進制 String，將兩個二進制相加。
	
	EX: 
		Input: a = "11", b = "1"
		Output: "100"
		
		Input: a = "1010", b = "1011"
		Output: "10101"	
		

*/
public class Solution {
	
	public static void main(String args[]) {
		String a = "1010";
		String b = "1011";
		
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		String result = addBinary(a, b);
		
		System.out.println(result);
	}
	
	public static String addBinary(String a, String b) {
		if (a == "" || b == "") return "";
		int i = a.length() - 1;
		int j = b.length() - 1;
		int num = 0;
		
		StringBuilder ans = new StringBuilder();
		while (i >= 0 || j >= 0 || num > 0) {
			
			if (i >= 0) {
				char c = a.charAt(i);
				if (c == '1') {
					num += 1;
				}
				i --;
			}
			
			if (j >= 0) {
				char c = b.charAt(j);
				if (c == '1') {
					num += 1;
				}
				j --;
			}
		
			ans.insert(0, num % 2);
			num = (num / 2);
		}
		
		return ans.toString();
		
	}
	
	public static String addBinary2(String a, String b) {
		if (a == "" || b == "") return "";
		int numA = Integer.parseInt(a, 2);
		int numB = Integer.parseInt(b, 2);
        return Integer.toBinaryString((numA + numB));
    }
	
}

 