/**
	Url: https://leetcode.com/problems/container-with-most-water/
	Author: MiLinSoQ
	Time: 2020-10-20
	Title: Container With Most Water 
	No: 11
*/

public class Solution {
	
	public static void main(String args[]) {
		
		int[] arr = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		
		int[] arr2 = { 2, 5, 3, 4, 20, 6, 20, 6 };
		
		int res = (new Solution()).maxArea(arr);
		
		System.out.println(String.format("Max area: [ %d ]", res));
	}
	
	
	public int maxArea(int[] height) {
		
		if (height == null || height.length <= 0) throw new IllegalArgumentException("Error, height is illegal.");
		
		int maxCon = 0;
		int front = 0;
		int tail = height.length - 1;
		int con = 0;
		
		while (front != tail) {
			con = (height[front] <= height[tail] ? height[front]: height[tail]);
			
			int tempCon = (tail - front) * con;
			if (tempCon > maxCon) maxCon = tempCon;
			
			
			if (height[front] <= height[tail]) {
				front++;
			} else {
				tail--;
			}
		}
        return maxCon;
    }
	
}