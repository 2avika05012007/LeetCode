class Solution {

    int[][] dp;
    int[] prefix;

    public int stoneGameV(int[] stoneValue) {

        int n = stoneValue.length;

        dp = new int[n][n];
        prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(stoneValue, 0, n - 1);
    }

    public int solve(int[] arr, int left, int right) {

        if (left == right) {
            return 0;
        }

        if (dp[left][right] != -1) {
            return dp[left][right];
        }

        int ans = 0;

        for (int k = left; k < right; k++) {

            int leftSum = prefix[k + 1] - prefix[left];
            int rightSum = prefix[right + 1] - prefix[k + 1];

            if (leftSum < rightSum) {

                ans = Math.max(
                    ans,
                    leftSum + solve(arr, left, k)
                );

            } else if (rightSum < leftSum) {

                ans = Math.max(
                    ans,
                    rightSum + solve(arr, k + 1, right)
                );

            } else {

                ans = Math.max(
                    ans,
                    Math.max(
                        leftSum + solve(arr, left, k),
                        rightSum + solve(arr, k + 1, right)
                    )
                );
            }
        }

        return dp[left][right] = ans;
    }
}