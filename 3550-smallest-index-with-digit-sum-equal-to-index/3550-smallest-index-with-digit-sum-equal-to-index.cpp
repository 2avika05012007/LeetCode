class Solution {
public:
    int smallestIndex(vector<int>& nums) {
        int ans = INT_MAX;

        for(int i = 0; i<nums.size(); i++){
            int a = nums[i];
            int temp = 0;
            while(a!=0){
                temp+=a%10;
                a/=10;
            }
            if(temp == i){
                ans = min(temp, ans);
            }
        }

        if(ans == INT_MAX){
            return -1;
        }
        return ans;
    }
};