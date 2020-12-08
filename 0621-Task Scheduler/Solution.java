/**
	Url: https://leetcode.com/problems/task-scheduler/
	Author: MiLinSoQ
	Time: 2020-12-08
	Title: Task Scheduler
	No: 621
*/
import java.util.*;
/**
	
	給一個 Char Array (tasks) & Integer (n)，n 為正整數
	task 內的元素代表電腦需要執行的任務，
	n 代表相同的任務之間需要冷卻的時間，也就是說想個相同任務之間至少有 n 的任務或是時間單位。
	
	EX:
		Input: tasks = ["A","A","A","B","B","B"], n = 2
		Output: 8
		Explanation: 
			A -> B -> idle -> A -> B -> idle -> A -> B
			There is at least 2 units of time between any two same tasks.
		

*/
public class Solution {
	
	public static void main(String args[]) {
		char[] tasks = { 'A', 'A', 'A', 'B', 'B', 'B' };
		int n = 2;
		int result = (new Solution()).leastInterval(tasks, n);
		System.out.println(String.format("Use time: [ %d ].", result));
	}
	
	public int leastInterval(char[] tasks, int n) {
		int[] num = new int[26];
		for (char c : tasks) {
			num[c - 'A'] ++;
		}
		
		Arrays.sort(num);
		int i = 25;
		while (i >= 0 && num[i] == num[25]) i --;
        return Math.max(tasks.length, (num[25] - 1) * (n + 1) + 25 - i);
    }
}

 