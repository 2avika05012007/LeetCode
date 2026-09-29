class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] freq = new int[n + 1];

        for(int nu : nums){
            freq[nu]++;
        }
        int d = -1;
        int m= -1;

        for(int i = 1; i <= n; i++){
            if(freq[i] == 2){
                d = i;
            }

            if(freq[i] == 0){
                m = i;
            }
        }
        int[] ans = {d, m};
        return  ans;
    }
}