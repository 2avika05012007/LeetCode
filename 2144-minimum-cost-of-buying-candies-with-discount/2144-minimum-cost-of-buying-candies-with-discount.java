class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int ans = 0;
        if(cost.length == 1){
            return cost[0];
        }
        if(cost.length == 2){
            return cost[0]+cost[1];
        }
        if(cost.length == 3){
            return cost[1]+cost[2];
        }
        for (int i = cost.length - 1; i >= 0; i -= 3) {
            ans += cost[i];
            if (i - 1 >= 0) {
                ans += cost[i - 1];
            }
        }
        return ans;
    }
}