package com.venkat.dsa.arrays.medium;

public class StockBuyAndSell {

	public static void main(String[] args) {
		int[] stockPrices = {7, 1, 5, 3, 6, 4};
		// Time Complexity: O(n²) Because for each element, we are checking every future element nested loops.
		// Space Complexity: O(1) No extra space used, only variables for storing max profit.
		// int maxProfit = stockBuySellBrute(stockPrices);
		// System.out.println(maxProfit);
		// Time Complexity: O(n),This is because we are iterating through the array of prices exactly once. There are no nested loops or recursive calls.
		// Space Complexity: O(1),Only two variables are used to store the minimum price and maximum profit, regardless of the input size.
		int maxProfit = stockBuySellOptimal(stockPrices);
		System.out.println(maxProfit);
	}
	
	// Function to calculate maximum profit using single pass
	private static int stockBuySellOptimal(int[] prices) {
		// Initialize the mini with starting value
		int mini = prices[0]; // mini = 7
		// Initialize the maximum profit to 0
		int maxProfit = 0;
		// Traverse each price in the array
		for (int i = 1; i < prices.length; i++) {
			// Find the profit of that day
			int profit = prices[i] - mini;
			// Update the max profit
			maxProfit = Math.max(maxProfit, profit);
			// find the minimum from that day to start
			mini = Math.min(mini, prices[i]);
		}

		// Return the maximum profit found
		return maxProfit;
	}
	
	// Function to calculate max profit using brute force
	private static int stockBuySellBrute(int[] stockPrices) {
		// Initialize max profit to 0
		int maxProfit = 0;
		// Loop through each day as a potential buy day
		for (int i = 0; i < stockPrices.length; i++) {
			// Loop through each future day as a potential sell day
			for (int j = i + 1; j < stockPrices.length; j++) {
				// Calculate profit
				int profit = stockPrices[j] - stockPrices[i];
				// Update max profit if higher
				maxProfit = Math.max(maxProfit, profit);
			}
		}

		// Return the maximum profit
		return maxProfit;
	}

}
