class Solution {
    public int pivotIndex(int[] nums) {
        int tots = 0;
        for(int i = 0; i<nums.length; i++){
            tots += nums[i];
       }
       int ls = 0;
       int rs = 0;
       for(int i = 0; i<nums.length; i++){
        rs = tots - ls - nums[i];
        if(ls == rs){
            return i;
        }
        ls += nums[i];
       }
       return -1;
    }
}