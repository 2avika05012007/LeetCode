class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int zero = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zero = i;
                break;
            }
        }

        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 0; i < n; i++) {
            int next = (i + 1) % n;

            if(nums[next] != (nums[i] + 1) % n) {
                increasing = false;
            }

            if (nums[i] != (nums[next] + 1) % n) {
                decreasing = false;
            }
        }

        if(!increasing && !decreasing){
            return -1;
        }

        if(increasing){
            return Math.min(zero, n - zero + 2);
        }

        return Math.min(zero + 2, n - zero);
    }
}