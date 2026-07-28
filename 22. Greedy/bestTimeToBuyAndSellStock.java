public class bestTimeToBuyAndSellStock {
    // Given an array prices[] of length N, representing the prices of the stocks on different days, the task is to find the maximum profit possible for buying and selling the stocks on different days using transactions where at most one transaction is allowed.
    // [Note: Stock must be bought before being sold]

    public static int solution(int[] prices) {
        if(prices == null || prices.length < 2) {
            return 0;
        }

        int n = prices.length;

        int buy = prices[0], maxProfit = 0;

        for(int i = 1;  i < n; i++) {
            if(prices[i] < buy) {
                buy = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, (prices[i] - buy));
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(solution(prices));
    }
}
