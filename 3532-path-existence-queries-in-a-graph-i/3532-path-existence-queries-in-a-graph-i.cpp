
class Solution {
public:
    vector<bool> pathExistenceQueries(int n, vector<int>& nums, int maxDiff, vector<vector<int>>& queries) {
        vector<int> component(n);
        int id = 0;

        component[0] = id;

        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] > maxDiff) {
                id++;
            }
            component[i] = id;
        }

        vector<bool> ans;

        for (auto &q : queries) {
            int u = q[0];
            int v = q[1];

            ans.push_back(component[u] == component[v]);
        }

        return ans;
    }
};
