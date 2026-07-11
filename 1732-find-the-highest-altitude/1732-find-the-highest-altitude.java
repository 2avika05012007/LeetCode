class Solution {
    public int largestAltitude(int[] gain) {
        int[] ans = new int[gain.length+1];
        ans[0] = 0;
        for(int i = 1; i<=gain.length; i++){
            ans[i] = ans[i-1] + gain[i-1];
        }
        int max = 0;
        for(int i = 0; i<ans.length; i++){
            int ms = ans[i];
            max = Math.max(ms, max);
        }
        return max;
    }
}