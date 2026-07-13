class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        int left = 0;
        while (left < nums.length && nums[left] != target) {
            left++;
        }
        if (left == nums.length) {
            return ans;   
        }
        ans[0] = left;
        int right = nums.length - 1;
        while (right >= 0 && nums[right] != target) {
            right--;
        }
        ans[1] = right;
        return ans;
    }
}