class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        vector<vector<int>> adj(numCourses);
        vector<int> indegree(numCourses, 0);
        queue<int> q;
        vector<int> o;
        for(auto& p : prerequisites){
            int a = p[0];
            int b = p[1];
            adj[b].push_back(a);
            indegree[a]++;
        }

        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.push(i);
            }
        }

        while(!q.empty()){
            int course = q.front();
            q.pop();
            o.push_back(course);
            for(int n : adj[course]){
                indegree[n]--;
                if(indegree[n] == 0){
                    q.push(n);
                }
            }
        }

        if(o.size() == numCourses){
            return o;
        }

        return {};
    }
};
