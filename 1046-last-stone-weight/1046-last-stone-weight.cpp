class Solution {
public:
    int lastStoneWeight(vector<int>& stones) {
        if(stones.size() == 1){
            return stones[0];
        }
        priority_queue<int> pq;
        for(int i: stones){
            pq.push(i);
        }
        while(pq.size()>=2){
            int a = pq.top();
            pq.pop();
            int b = pq.top();
            pq.pop();
            if(a!=b){
                pq.push(abs(a-b));
            }
        }
        if(pq.empty()){
            return 0;
        }
        return pq.top();
    }
};