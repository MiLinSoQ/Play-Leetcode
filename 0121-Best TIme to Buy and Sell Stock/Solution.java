/**
	Url: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
	Author: MiLinSoQ
	Time: 2020-11-21
	Title: Best Time to Buy and Sell Stock
	No: 121
*/

/**
	
	股票問題，給一個Integer Array (prices)，每一個元素代表價格 index 代表天數，
	例如 index = 0 ，prices[index] = 7，第一天股票的價格為 7。
	index = 1 ，prices[index] = 5，第二天股票的價格為 5。
	找出最適合買進股票與賣出股票的價格來保證利潤最高。
	
	EX:
		Input: [7,1,5,3,6,4]
		Output: 5
		Explanation: 在第二天股票為 1 時買進，第五天股票價格最高時賣出。 利潤為 5。
	
*/
public class Solution {
	
	public static void main(String args[]) {
		
		int[] prices = { 7,1,5,3,6,4 };
		int result = (new Solution()).maxProfit(prices);
		
		System.out.println(String.format("The max profit: [ %d ]", result));
	}
	
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) return 0;
		int maxProfit = 0;
		int buyStock = prices[0];
		int currentPrice = 0;
		for (int i = 0; i < prices.length; i ++) {
			currentPrice = prices[i];
			if (currentPrice < buyStock) {
				buyStock = currentPrice;
				System.out.println("buy stock: " + buyStock);
			} else if (currentPrice - buyStock > maxProfit) {
				maxProfit = currentPrice - buyStock;
			}
		}
		return maxProfit;
    }
}



