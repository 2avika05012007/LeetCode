class Solution {
public:
int t = 0;
    void dfs(int u, int parent, vector<vector<int>>& adj, vector<int>& disc, vector<int>& low,vector<vector<int>>& ans){
        disc[u] = low[u] = t++;

        for(int v : adj[u]){
            if(v == parent){
                continue;
            }
            if(disc[v] == -1){
                dfs(v, u, adj, disc, low, ans);
                low[u] = min(low[u], low[v]);
                if(low[v] > disc[u]){
                    ans.push_back({u, v});
                }
            }
            else{
                low[u] = min(low[u], disc[v]);
            }
        }
    }
    vector<vector<int>> criticalConnections(
        int n, vector<vector<int>>& connections) {
        vector<vector<int>> adj(n);

        for(auto& edge : connections){
            int u = edge[0];
            int v = edge[1];

            adj[u].push_back(v);
            adj[v].push_back(u);
        }

        vector<int> disc(n, -1);
        vector<int> low(n, -1);
        vector<vector<int>> ans;

        for(int i = 0; i < n; i++){
            if(disc[i] == -1){
                dfs(i, -1, adj, disc, low, ans);
            }
        }
        
        return ans;
    }
};