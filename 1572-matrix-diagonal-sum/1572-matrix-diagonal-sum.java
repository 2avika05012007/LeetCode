class Solution {
    public int diagonalSum(int[][] mat) {
        
        int ans = 0;
        int n = mat.length;
        for(int i = 0; i<mat.length; i++){
            for(int j = 0; j<mat[0].length; j++){
                if(i == j || i + j == n - 1){
                    ans+=mat[i][j];
                }
            }
        }
        return ans;
    }
}