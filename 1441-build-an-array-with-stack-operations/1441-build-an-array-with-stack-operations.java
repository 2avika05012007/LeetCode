class Solution {
    public List<String> buildArray(int[] target, int n){
        List<String> ans = new ArrayList<>();
        int k = 0;

        for(int num = 1; num <= n && k < target.length; num++){
            ans.add("Push");

            if(num == target[k]){
                k++;
            }
            else {
                ans.add("Pop");
            }
        }

        return ans;
    }
}