class Solution {
    public int smallestIndex(int[] nums) {

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {

            int a = nums[i];
            int temp = 0;

            while (a != 0) {
                temp += a % 10;
                a /= 10;
            }

            if (temp == i) {
                ans = Math.min(i, ans);
            }
        }

        if (ans == Integer.MAX_VALUE) {
            return -1;
        }

        return ans;
    }
}