class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long b = Math.min(need1, need2);

        long costA = b * costBoth + (long)(need1 - b) * cost1 + (long)(need2 - b) * cost2;

        long costB = (long) need1 * cost1 + (long) need2 * cost2;

        long costC = (long) Math.max(need1, need2) * costBoth;

        return Math.min(costA, Math.min(costB, costC));
    }
}
