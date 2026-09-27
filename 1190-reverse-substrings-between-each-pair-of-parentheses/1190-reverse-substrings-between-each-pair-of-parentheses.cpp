class Solution {
public:
    string reverseParentheses(string s) {
        stack<string> st;
        string a = "";
        for(char ch: s){
            if(ch == '('){
                st.push(a);
                a = "";
            }
            else if (ch == ')') {
                reverse(a.begin(), a.end());
                a = st.top() + a;
                st.pop();
            }
            else {
                a += ch;
            }

        }
        return a;
    }
};