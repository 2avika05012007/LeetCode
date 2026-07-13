class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[i].length; j++){
                int a = grid[i][j];
                if(a<0){
                    count++;
                }
            }
        }
        return count;
    }
}