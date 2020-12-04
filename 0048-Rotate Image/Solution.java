/**
	Url: https://leetcode.com/problems/rotate-image/
	Author: MiLinSoQ
	Time: 2020-12-04
	Title: Rotate Image
	No: 48
*/
import java.util.*;
/**
	
	給一個 n * n 的 2D 矩陣，請選轉這個矩陣 (順時針)。
	
	EX:
		Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
		Output: [[7,4,1],[8,5,2],[9,6,3]]
		
		[						[
			[1, 2, 3],				[7, 4, 1],
			[4, 5, 6],      =>  	[8, 5, 2],
			[7, 8, 9]				[9, 6, 3]
		]						]	
		

*/
public class Solution {
	
	public static void main(String args[]) {
		
		// int[][] matrix = { 
			// {1, 2, 3},
			// {4, 5, 6},
			// {7, 8, 9}
		// };
		
		int[][] matrix = { 
			{5, 1, 9, 11},
			{2, 4, 8, 10},
			{13, 3, 6, 7},
			{15, 14, 12, 16}
		};
		
		for (int i = 0; i < matrix.length; i ++) {
			for (int j = 0; j < matrix[i].length; j ++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		(new Solution()).rotate(matrix);
		
		for (int i = 0; i < matrix.length; i ++) {
			for (int j = 0; j < matrix[i].length; j ++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
		
	}
	
	public void rotate(int[][] matrix) {
        int indexL = 0;
		int indexR = matrix.length - 1;
		
		while (indexL < indexR) {
			int[] temp = matrix[indexL];
			matrix[indexL] = matrix[indexR];
			matrix[indexR] = temp;
			indexL ++;
			indexR --;
		}
		
		for (int i = 0; i < matrix.length; i ++) {
			for (int j = i + 1; j < matrix.length; j ++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
    }
	
}

 