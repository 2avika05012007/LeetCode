class Solution {
    public boolean isGood(int[] nums) {
        if(nums.length == 1){
            return false;
        }
        Arrays.sort(nums);
        int max = nums[nums.length -1];
        if(nums.length!=max+1){
            return false;
        }
        if(nums[nums.length -2]!= max){
            return false;
        }
        int i = 1;
        int j = 0;
        while(j<=nums.length-3 && i<max){
            if(nums[j]!=i){
                return false;
            }
            j++;
            i++;
        }
        return true;
    }
}