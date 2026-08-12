class Solution {
    public int missingInteger(int[] nums) {
        int sum = nums[0];
        for(int i = 1; i<nums.length; i++){
            if(nums[i] == nums[i-1]+1){
                sum+=nums[i];
            }
            else{
                break;
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i: nums){
            set.add(i);
        }
        int ans = 0;
        while(ans==0){
            if(set.contains(sum)){
                sum++;
            }
            else{
                ans = sum;
                return ans;
            }
        }
        return -1;
    }
}