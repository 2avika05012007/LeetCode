class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[nums.length-1];
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == min){
                min++;
                continue;
            }
            else{
                ans.add(min);
                min++;
                i--;
            }
        }
        return ans;
    }
}