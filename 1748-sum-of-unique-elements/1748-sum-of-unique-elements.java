class Solution {
    public int sumOfUnique(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        for(int i: map.keySet()){
            if(map.get(i) == 1){
                ans+= i;
            }
        }
        return ans;
    }
}