class Solution {

    public double dis(int a, int b) {
        double d = (a * (100 - b)) / 100.0;
        return Math.round(d * 100000.0) / 100000.0;
    }

    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);

        int i = prices.length - 1;
        int j = discounts.length - 1;

        double ans = 0;

        while (i >= 0 && j >= 0) {
            ans += dis(prices[i], discounts[j]);
            i--;
            j--;
        }

        while (i >= 0) {
            ans += prices[i];
            i--;
        }

        return ans;
    }
}