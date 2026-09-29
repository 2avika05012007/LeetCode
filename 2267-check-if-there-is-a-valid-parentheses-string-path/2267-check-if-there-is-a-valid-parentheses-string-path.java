class Solution {
    int m, n;
    Boolean[][][] memo;

    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        if ((m + n - 1) % 2 != 0) {
            return false;
        }

        if (grid[0][0] == ')') {
            return false;
        }

        memo = new Boolean[m][n][m + n];

        return dfs(grid, 0, 0, 1);
    }

    boolean dfs(char[][] grid, int i, int j, int balance) {

        if (balance < 0) {
            return false;
        }

        int remaining = (m - 1 - i) + (n - 1 - j);

        if (balance > remaining) {
            return false;
        }

        if (i == m - 1 && j == n - 1) {
            return balance == 0;
        }

        if (memo[i][j][balance] != null) {
            return memo[i][j][balance];
        }

        boolean ans = false;

        if (i + 1 < m) {
            int newb = balance +
                    (grid[i + 1][j] == '(' ? 1 : -1);

            ans = dfs(grid, i + 1, j, newb);
        }

        if (!ans && j + 1 < n) {
            int newb = balance +
                    (grid[i][j + 1] == '(' ? 1 : -1);

            ans = dfs(grid, i, j + 1, newb);
        }

        memo[i][j][balance] = ans;

        return ans;
    }
}