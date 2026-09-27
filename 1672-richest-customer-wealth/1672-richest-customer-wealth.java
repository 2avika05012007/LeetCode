class Solution {
    public int maximumWealth(int[][] accounts) {
        int sum = 0;
        for(int i = 0; i<accounts.length; i++){
            int wel = 0;
            for(int j = 0; j < accounts[i].length; j++){
                wel += accounts[i][j];
            }
            sum = Math.max(wel, sum);
        }
        return sum;
    }
}