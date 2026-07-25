class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int[] ne = new int[n];
        for (int i = 0; i < n; i++) {
            ne[i] = capacity[i] -rocks[i];
        }
        Arrays.sort(ne);
        int ans = 0;
        for (int x : ne) {
            if (x <= additionalRocks) {
                additionalRocks -= x;
                ans++;
            }
            else {
                break;
            }
        }
        return ans;
    }
}