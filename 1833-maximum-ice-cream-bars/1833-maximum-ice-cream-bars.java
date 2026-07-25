class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int ans = 0;
        int i = 0;
        while(i<costs.length && costs[i]<=coins){
            coins-=costs[i];
            ans++;
            i++;
        }
        return ans;
    }
}