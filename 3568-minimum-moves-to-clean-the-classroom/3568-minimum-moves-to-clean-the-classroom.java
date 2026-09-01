import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        int startX = 0;
        int startY = 0;
        int[][] litterId = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(litterId[i], -1);
        }

        int litterCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (classroom[i].charAt(j) == 'S') {
                    startX = i;
                    startY = j;
                }

                if (classroom[i].charAt(j) == 'L') {
                    litterId[i][j] = litterCount;
                    litterCount++;
                }
            }
        }

        
        if (litterCount == 0) {
            return 0;
        }

        
        int fullMask = (1 << litterCount) - 1;

        boolean[][][][] visited =
            new boolean[m][n][energy + 1][1 << litterCount];

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{
            startX,
            startY,
            energy,
            fullMask
        });

        visited[startX][startY][energy][fullMask] = true;

        int moves = 0;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size-- > 0) {

                int[] state = queue.poll();

                int x = state[0];
                int y = state[1];
                int currEnergy = state[2];
                int mask = state[3];

            
                if (mask == 0) {
                    return moves;
                }

                
                if (currEnergy == 0) {
                    continue;
                }

                
                for (int k = 0; k < 4; k++) {

                    int nx = x + dx[k];
                    int ny = y + dy[k];

                   
                    if (nx < 0 || nx >= m ||
                        ny < 0 || ny >= n) {
                        continue;
                    }

                    
                    if (classroom[nx].charAt(ny) == 'X') {
                        continue;
                    }

                    int newEnergy = currEnergy - 1;
                    int newMask = mask;

                   
                    if (classroom[nx].charAt(ny) == 'R') {
                        newEnergy = energy;
                    }

                    
                    if (classroom[nx].charAt(ny) == 'L') {

                        int bit = litterId[nx][ny];

                        newMask &= ~(1 << bit);
                    }

                   
                    if (!visited[nx][ny][newEnergy][newMask]) {

                        visited[nx][ny][newEnergy][newMask] = true;

                        queue.offer(new int[]{
                            nx,
                            ny,
                            newEnergy,
                            newMask
                        });
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}