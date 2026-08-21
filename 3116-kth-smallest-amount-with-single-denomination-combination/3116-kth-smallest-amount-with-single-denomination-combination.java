class Solution {

    long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    public long findKthSmallest(int[] coins, int k) {

        long low = 1;
        long high = (long) 1e11;

        while (low < high) {

            long mid = low + (high - low) / 2;

            if (count(mid, coins) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    long count(long x, int[] coins) {

        long ans = 0;
        int n = coins.length;

        for (int mask = 1; mask < (1 << n); mask++) {

            long LCM = 1;

            for (int i = 0; i < n; i++) {

                if ((mask & (1 << i)) != 0) {

                    LCM = lcm(LCM, coins[i]);

                    if (LCM > x) {
                        break;
                    }
                }
            }

            
            if (LCM > x) {
                continue;
            }

            long value = x / LCM;

            if (Integer.bitCount(mask) % 2 == 1) {
                ans += value;
            } else {
                ans -= value;
            }
        }

        return ans;
    }
}