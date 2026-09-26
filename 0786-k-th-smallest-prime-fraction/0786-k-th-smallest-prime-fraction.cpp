class Solution {
public:
    vector<int> kthSmallestPrimeFraction(vector<int>& arr, int k) {
        vector<pair<double, pair<int, int>>> fractions;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                double value = (double)arr[i] / arr[j];

                fractions.push_back({
                    value,
                    {arr[i], arr[j]}
                });
            }
        }

        sort(fractions.begin(), fractions.end());
        int num = fractions[k - 1].second.first;
        int den= fractions[k - 1].second.second;

        return {num, den};
    }
};