class Solution {
public:
    int longestMonotonicSubarray(vector<int>& nums) {
        int n = nums.size();
        int ans = 1, in = 1, d = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                in++;
                d = 1;
            } 
            else if (nums[i] < nums[i - 1]) {
                d++;
                in = 1;
            } 
            else {
                in = 1;
                d = 1;
            }

            ans = max(ans, max(in, d));
        }

        return ans;
    }
};