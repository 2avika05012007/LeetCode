class Solution {
    public int pivotIndex(int[] nums) {
       int start = 0;
       int end = nums.length;
       for(int i = 0; i<end; i++){
        int sum1 = 0;
        for(int j = 0; j<i; j++){
            sum1+=nums[j];
        } 
        int sum2 = 0;
        for(int j = i+1; j<end; j++){
            sum2+=nums[j];
        }   
        if(sum1 == sum2){
            return i;
        }  
       } 
       return -1;
    }
}