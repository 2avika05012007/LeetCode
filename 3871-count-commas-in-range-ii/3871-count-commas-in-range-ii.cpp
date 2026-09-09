class Solution {
public:
    long long countCommas(long long n) {
        long long ans = 0;
        long long mini = 1000;
        while (mini <= n) {
            ans += n - mini + 1;
            mini *= 1000;
        }
        return ans;
    }
};