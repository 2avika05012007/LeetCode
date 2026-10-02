class Solution {
public:
    vector<string> buildArray(vector<int>& target, int n) {
        vector<string> ans;
        int k = 0;

        for(int num = 1; num <= n && k < target.size(); num++){
            ans.push_back("Push");

            if(num == target[k]){
                k++;
            }
            else{
                ans.push_back("Pop");
            }
        }

        return ans;
    }
};