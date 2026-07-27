class Solution {
    public int uniqueXorTriplets(int[] nums) {
        Arrays.sort(nums);
        int maxele = nums[nums.length - 1];
        int i = 2;
        if(nums.length == 1 ){
            return nums[0];
        }
        if(nums.length == 2 ){
            return nums[1];
        }
        while (i <= maxele) {
            i *= 2;
        }
        return i;
    }
}