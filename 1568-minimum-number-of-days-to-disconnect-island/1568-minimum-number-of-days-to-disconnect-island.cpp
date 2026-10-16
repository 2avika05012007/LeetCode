class Solution {
public:
    int m, n;
    int dir[5] = {-1, 0, 1, 0, -1};

    void dfs(int r, int c, vector<vector<int>>& grid, vector<vector<bool>>& visited) {
        visited[r][c] = true;

        for (int k = 0; k < 4; k++) {
            int nr = r + dir[k];
            int nc = c + dir[k + 1];

            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1 &&
                !visited[nr][nc]) {
                dfs(nr, nc, grid, visited);
            }
        }
    }

    int countIslands(vector<vector<int>>& grid) {
        vector<vector<bool>> visited(m, vector<bool>(n, false));

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j, grid, visited);
                    count++;
                }
            }
        }

        return count;
    }

    int minDays(vector<vector<int>>& grid) {
        m = grid.size();
        n = grid[0].size();

        if (countIslands(grid) != 1) {
            return 0;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;

                    if (countIslands(grid) != 1) {
                        grid[i][j] = 1;
                        return 1;
                    }
                    grid[i][j] = 1;
                }
            }
        }

        return 2;
    }
};
