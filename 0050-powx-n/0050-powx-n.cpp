class Solution {
public:
    double myPow(double x, int n) {
        long long pow = n;
        double ans = 1.0;
        if(pow < 0){
            pow = -pow;
        }

        while(pow > 0){
            if(pow % 2 == 1){
                ans *= x;
            }
            x *= x;
            pow /= 2;
        }
        if(n < 0){
            return 1.0 / ans;
        }

        return ans;
    }
};