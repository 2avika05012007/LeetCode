class Solution {
    public int minElement(int[] nums) {
        for(int i = 0; i<nums.length; i++){
            int a = nums[i];
            int sum = 0;
            while(a!=0){
                sum+= a%10;
                a/=10;
            }
            nums[i] = sum;
        }
        Arrays.sort(nums);
        return nums[0];
    }
}