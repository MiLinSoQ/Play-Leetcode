/**
	Url: https://leetcode.com/problems/daily-temperatures/
	Author: MiLinSoQ
	Time: 2020-12-03
	Title: Daily Temperatures
	No: 739
*/
import java.util.*;
/**
	
	給一個溫度列表 Integer Array (T)，設計一個函數回傳一個 Integer Array，array 內容是還有多少天溫度會回升，如果沒有為 0
	
	EX:
		Input:  T = [73, 74, 75, 71, 69, 72, 76, 73]
		Output: [1, 1, 4, 2, 1, 1, 0, 0]
		
		第一天 73 度，還有 1 天天氣會回升至 74 度。
		第二天 74 度，還有 1 天天氣會回升至 75 度。
		第三天 75 度，還有 4 天天氣會回升至 76 度。 ....

*/
public class Solution {
	
	public static void main(String args[]) {
		int[] T = { 73, 74, 75, 71, 69, 72, 76, 73 };
		
		// int[] T = {  };
		
		int[] result = (new Solution()).dailyTemperatures(T);
		
		for (int i = 0; i < result.length; i ++) {
			System.out.println(result[i]);
		}
		
	}
	
	public int[] dailyTemperatures(int[] T) {
		Stack<Integer> stack = new Stack<>();
		int[] result = new int[T.length];
		for (int i = 0; i < T.length; i ++) {
			while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
				int idx = stack.pop();
				result[idx] = i - idx;
			}
			stack.push(i);
		}
        return result;
    }
}

 