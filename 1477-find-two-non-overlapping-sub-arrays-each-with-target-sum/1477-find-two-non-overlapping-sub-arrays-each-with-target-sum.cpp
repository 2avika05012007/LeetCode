class Solution {
public:
    int minSumOfLengths(vector<int>& arr, int target) {
        int n = arr.size();
        const int INF = 1e9;
        vector<int> best(n, INF);

        int left = 0;
        int sum = 0;
        int answer = INF;

        for (int right = 0; right < n; right++) {

            sum += arr[right];

            while (sum > target && left <= right) {
                sum -= arr[left];
                left++;
            }

            if (sum == target) {

                int length = right - left + 1;

                if (left > 0 && best[left - 1] != INF) {
                    answer = min(
                        answer,
                        length + best[left - 1]
                    );
                }

                if (right == 0) {
                    best[right] = length;
                } else {
                    best[right] = min(best[right - 1], length);
                }
            }
            else {
                if (right > 0) {
                    best[right] = best[right - 1];
                }
            }
        }

        return answer == INF ? -1 : answer;
    }
};