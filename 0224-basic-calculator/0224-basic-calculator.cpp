class Solution {
public:
    int calculate(string s) {
        stack<long long> st;
        long long ans = 0;
        int sign = 1;
        long long num = 0;

        for (int i = 0; i < s.size(); i++) {
            char c = s[i];

            if (isdigit(c)) {
                num = num * 10 + (c - '0');
            }
            else if (c == '+') {
                ans += sign * num;
                num = 0;
                sign = 1;
            }
            else if (c == '-') {
                ans += sign * num;
                num = 0;
                sign = -1;
            }
            else if (c == '(') {
                st.push(ans);
                st.push(sign);
                ans = 0;
                sign = 1;
            }
            else if (c == ')') {
                ans += sign * num;
                num = 0;

                ans *= st.top();
                st.pop();

                ans += st.top();
                st.pop();
            }
        }

        ans += sign * num;
        return (int)ans;
    }
};
