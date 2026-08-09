class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] suffix = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }
        int[][] dp = new int[n][n + 1];
        return solve(piles, suffix, 0, 1, dp);
    }
    private int solve(int[] piles, int[] suffix, int i, int M, int[][] dp) {
        int n = piles.length;
        if (i + 2 * M >= n) {
            return suffix[i];
        }
        if (dp[i][M] != 0) {
            return dp[i][M];
        }
        int best = 0;
        for (int X = 1; X <= 2 * M; X++) {
            int opponent = solve(
                piles,
                suffix,
                i + X,
                Math.max(M, X),
                dp
            );
            int current = suffix[i] - opponent;

            best = Math.max(best, current);
        }
        dp[i][M] = best;
        return best;
    }
}