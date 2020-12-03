/**
	Url: https://leetcode.com/problems/check-if-it-is-a-straight-line/
	Author: MiLinSoQ
	Time: 2020-12-03
	Title: Check If It Is a Straight Line
	No: 1232
*/
import java.util.*;
/**
	
	給一個數組座標，設計一個函數，判斷這個數組是否在同一個直線上。
	
	EX:
		Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
		Output: true
		
		Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
		Output: false

*/
public class Solution {
	
	public static void main(String args[]) {
		int[][] points = { 
			{1, 2},
			{2, 3},
			{3, 4},
			{4, 5},
			{5, 6},
			{6, 7}
		};
		
		// int[][] points = { 
			// {0, 0},
			// {0, 1},
			// {0, -1}
		// };
		
		// int[][] points = { 
			// {1, 1},
			// {2, 2},
			// {2, 0}
		// };
		boolean result = (new Solution()).checkStraightLine(points);
		System.out.println("Is a line: " + result);
	}
	
	public boolean checkStraightLine(int[][] coordinates) {
		if (coordinates.length == 2) return true;
		int x0 = coordinates[0][0], y0 = coordinates[0][1], 
			x1 = coordinates[1][0], y1 = coordinates[1][1];
			
		int dx = x1 - x0, dy = y1 - y0;
        for (int[] co : coordinates) {
            int x = co[0], y = co[1];
            if (dx * (y - y1) != dy * (x - x1)) return false;
        }
        return true;
    }
}

 