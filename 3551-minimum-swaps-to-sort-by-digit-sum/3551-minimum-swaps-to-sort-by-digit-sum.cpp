class Solution {
public:
    int ds(int n) {
        int s = 0;
        while(n > 0){
            s +=n % 10;
            n /= 10;
        }
        return s;
    }

    int minSwaps(vector<int>& nums) {
        int n = nums.size();
        vector<int> sorted = nums;
        sort(sorted.begin(), sorted.end(), [&](int a, int b) {
            int sA = ds(a);
            int sB = ds(b);
            if(sA == sB){
                return a < b;
            }

            return sA < sB;
        });
        unordered_map<int, int> targetIndex;

        for(int i = 0; i < n; i++){
            targetIndex[sorted[i]] = i;
        }
        vector<bool> visited(n, false);
        int swap = 0;
        for(int i = 0; i < n; i++){
            if (visited[i] || targetIndex[nums[i]] == i)
                continue;

            int j = i;
            int cycleSize = 0;

            while(!visited[j]){
                visited[j] = true;
                j = targetIndex[nums[j]];
                cycleSize++;
            }
            swap += cycleSize - 1;
        }

        return swap;
    }
};
