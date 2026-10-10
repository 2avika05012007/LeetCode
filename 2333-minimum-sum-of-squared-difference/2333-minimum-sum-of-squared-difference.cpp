class Solution{
public:
    long long minSumSquareDiff(vector<int>& nums1, vector<int>& nums2, int k1, int k2) {
        long long k = (long long)k1 + k2;
        vector<long long> diff;
        long long total = 0;
        int mx = 0;
        for(int i = 0; i < nums1.size(); i++){
            long long d = abs(nums1[i] - nums2[i]);
            diff.push_back(d);
            total += d;
            mx = max(mx, (int)d);
        }
        if(total <= k){
            return 0;
        }
        int low = 0, high = mx;
        while(low < high){
            int mid = low + (high - low) / 2;
            long long operations = 0;
            for(long long d : diff){
                if(d > mid){
                    operations += d - mid;
                }
            }
            if(operations <= k){
                high = mid;
            }
            else{
                low = mid + 1;
            }
        }
        long long ans = 0;
        long long remaining = k;
        for(long long d : diff){
            if(d > low){
                remaining -= d - low;
                d = low;
            }
            ans += d * d;
        }
        for(int i = 0; i < diff.size() && remaining > 0; i++){
            if (diff[i] >= low && diff[i] > 0) {
                ans -= 1LL * low * low;
                ans += 1LL * (low - 1) * (low - 1);
                remaining--;
            }
        }
        return ans;
    }
};