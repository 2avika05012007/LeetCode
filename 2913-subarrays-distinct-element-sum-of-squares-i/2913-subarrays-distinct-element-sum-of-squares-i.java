class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        long ans = 0;
        int mod = 1000000007;

        for(int i = 0; i < n; i++){
            HashSet<Integer> set = new HashSet<>();
            for(int j = i; j < n; j++){
                set.add(nums.get(j));
                long d = set.size();
                ans = (ans + d * d) % mod;
            }
        }
        return (int) ans;
    }
}
