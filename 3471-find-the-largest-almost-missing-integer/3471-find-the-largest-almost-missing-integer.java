class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        if (k == 1) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            int ans = -1;

            for (int num : map.keySet()) {
                if (map.get(num) == 1) {
                    ans = Math.max(ans, num);
                }
            }

            return ans;
        }
        if (k == n) {
            int ans = nums[0];

            for (int num : nums) {
                ans = Math.max(ans, num);
            }

            return ans;
        }
        int ans = -1;
        boolean firstUnique = true;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[0]) {
                firstUnique = false;
                break;
            }
        }

        if (firstUnique) {
            ans = Math.max(ans, nums[0]);
        }
        boolean lastUnique = true;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[n - 1]) {
                lastUnique = false;
                break;
            }
        }

        if (lastUnique) {
            ans = Math.max(ans, nums[n - 1]);
        }

        return ans;
    }
}