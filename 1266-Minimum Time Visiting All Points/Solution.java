/**
	Url: https://leetcode.com/problems/minimum-time-visiting-all-points/
	Author: MiLinSoQ
	Time: 2020-12-03
	Title: Minimum Time Visiting All Points
	No: 1266
*/
import java.util.*;
/**
	
	有 n 個整數座標，任務是以最點的方式走訪所有座標。
	
	EX:
		Input: points = [[1,1],[3,4],[-1,0]]
		Output: 7
		Explanation: One optimal path is [1,1] -> [2,2] -> [3,3] -> [3,4] -> [2,3] -> [1,2] -> [0,1] -> [-1,0]   
		Time from [1,1] to [3,4] = 3 seconds 
		Time from [3,4] to [-1,0] = 4 seconds
		Total time = 7 seconds						

*/
public class Solution {
	
	public static void main(String args[]) {
		int[][] points = { 
			{1, 1},
			{3, 4},
			{-1, 0}
		};
		
		
		int seconds = (new Solution()).minTimeToVisitAllPoints(points);
		
		System.out.println(String.format("time: %d ", seconds));
		
	}
	
	 public int minTimeToVisitAllPoints(int[][] points) {
		 int seconds = 0;
		 int[] pointA, pointB;
		 for (int i = 0; i < points.length - 1; i ++) {
			 pointA = points[i];
			 pointB = points[i + 1];
			 int x = pointA[0] - pointB[0];
			 int y = pointA[1] - pointB[1];
			 
			 int xp = ( x < 0 ? x * -1 : x );
			 int yp = ( y < 0 ? y * -1 : y );
			 
			 seconds += xp > yp ? xp : yp;
		 }
        return seconds;
    }
}

 