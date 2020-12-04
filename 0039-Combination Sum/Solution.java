/**
	Url: https://leetcode.com/problems/combination-sum/
	Author: MiLinSoQ
	Time: 2020-12-04
	Title: Combination Sum
	No: 39
*/
import java.util.*;
/**
	
	給一個元素不重複的 Integer Array (candidates) & Integer (target)，
	設計一個函數，返回這個陣列中和等於 target 的組合，可以重複使用同一個元素。
	
	EX:
		Input: candidates = [2,3,6,7], target = 7
		Output: [[2,2,3],[7]]
		Explanation:
		2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
		7 is a candidate, and 7 = 7.
		These are the only two combinations.
		
		
		Input: candidates = [2,3,5], target = 8
		Output: [[2,2,2,2],[2,3,3],[3,5]]
		

*/
public class Solution {
	
	public static void main(String args[]) {
		int[] candidates = { 2, 3, 6, 7 };
		int target = 7;
		List<List<Integer>> result = (new Solution()).combinationSum(candidates, target);
		
		System.out.println("size: " + result.size());
		
		
		for (int i = 0; i < result.size(); i ++) {
			for (Integer num : result.get(i)) {
				System.out.print(num + ", ");
			}
			System.out.println();
		}
		
	}
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
		
		combination(result, new ArrayList<Integer>(), candidates, target, 0);
		return result;
    }
	
	private void combination(List<List<Integer>> result, List<Integer> list, int[] candidates, int target, int index) {
		
		if (target > 0) {
			
			for (int i = index; i < candidates.length && target >= candidates[i]; i ++) {
				
				list.add(candidates[i]);
				combination(result, list, candidates, target - candidates[i], i);
				
				list.remove(list.size() - 1);
			}
			
		} else if (target == 0) {
			result.add(new ArrayList<Integer>(list));
		}
	}
}

 