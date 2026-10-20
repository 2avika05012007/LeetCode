class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int ans = 0;
        for(int k = 1; k <= n; k++){
            if(n % k != 0){
                continue;
            }
            boolean valid = true;
            for(int start = 0; start < n; start += k){
                int[] a = Arrays.copyOfRange(nums, start, start + k);
                int[] b = Arrays.copyOfRange(sorted, start, start + k);
                Arrays.sort(a);
                Arrays.sort(b);
                if(!Arrays.equals(a, b)){
                    valid = false;
                    break;
                }
                int descents = 0;
                for(int j = start; j < start + k; j++){
                    int next = (j + 1 == start + k) ? start : j + 1;

                    if(nums[j] > nums[next]){
                        descents++;
                    }
                }
                if(descents > 1){
                    valid = false;
                    break;
                }
            }

            if(valid){
                ans += k;
            }
        }
        return ans;
    }
}