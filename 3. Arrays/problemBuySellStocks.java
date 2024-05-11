//Problem:
//Given an array where prices[i] is the price of a given stock on the ith day. You want to maximize your profit by choosing a single day to buy your stock and a different day to sell your stock in the future. Return MaxProfit
//prices[] = {7,1,5,3,6,4}

public class problemBuySellStocks { //Time Complexity = O(n) & Space Complexity = O(1)
    public static void main(String args[]) {
        int prices[] = {7,1,5,3,6,4};
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;

        for(int i = 0; i < prices.length; i++ ) {
            if (prices[i] > buyPrice) {
                int profit = prices[i] - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buyPrice = prices[i];
            }
        }
        System.out.println("Max Profit: " + maxProfit);
    }
}
