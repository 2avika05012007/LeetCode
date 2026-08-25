class Solution {
    public int missingMultiple(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i: nums){
            list.add(i);
        }
        Arrays.sort(nums);
        int j = k;
        while(j<=nums[nums.length-1]){
            if(!list.contains(j)){
                return j;
            }
            else{
                j+=k;
            }
        }

        return j;
    }
}