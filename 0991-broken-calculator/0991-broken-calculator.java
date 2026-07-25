class Solution {
    public int brokenCalc(int startValue, int target) {
        int ans = 0;
        while(target!=startValue){
            if(target%2==0 && target>startValue){
                target/=2;
                ans++;
            }
            else{
                target++;
                ans++;
            }
        }
        return ans;
    }
}