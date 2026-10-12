class Solution {
public:
    int numBusesToDestination(vector<vector<int>>& routes, int source, int target) {
        unordered_map<int, vector<int>> stopToRoutes;
        if(source == target){
            return 0;
        }
        for(int i = 0; i < routes.size(); i++){
            for(int stop : routes[i]){
                stopToRoutes[stop].push_back(i);
            }
        }
        int b = 0;
        queue<int> q;
        unordered_set<int> visitedStops;
        vector<bool> visitedRoutes(routes.size(), false);
        q.push(source);
        visitedStops.insert(source);

        while(!q.empty()){
            int size = q.size();
            b++;
            while(size--){
                int s = q.front();
                q.pop();

                for(int route : stopToRoutes[s]){
                    if(visitedRoutes[route]){
                        continue;
                    }
                    visitedRoutes[route] = true;
                    for(int nextStop : routes[route]){
                        if(nextStop == target){
                            return b;
                        }

                        if(!visitedStops.count(nextStop)){
                            visitedStops.insert(nextStop);
                            q.push(nextStop);
                        }
                    }
                }
            }
        }
        return -1;
    }
};