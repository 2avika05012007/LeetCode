class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] pm = new int[n];
        int[] sm = new int[n];
        pm[0] = nums[0];

        for (int i = 1; i < n; i++) {
            pm[i] = Math.max(pm[i - 1], nums[i]);
        }
        sm[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            sm[i] = Math.min(sm[i + 1], nums[i]);
        }
        for (int i = 0; i < n; i++) {
            if (pm[i] - sm[i] <= k) {
                return i;
            }
        }
        return -1;
    }
}