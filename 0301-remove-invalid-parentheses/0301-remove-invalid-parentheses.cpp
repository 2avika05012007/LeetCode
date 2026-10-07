class Solution {
public:
    vector<string> ans;
    unordered_set<string> visited;
    bool isValid(string s){
        int count = 0;

        for(char ch : s){
            if(ch == '('){
                count++;
            }
            else if (ch == ')') {
                count--;

                if (count < 0)
                    return false;
            }
        }
        return count == 0;
    }

    void solve(string s, int index, int removals, int minRemovals){

        if(removals > minRemovals)
            return;

        if(index == s.length()){

            if(removals == minRemovals && isValid(s)){
                ans.push_back(s);
            }
            return;

        }
        if(s[index] == '(' || s[index] == ')'){

            string temp = s.substr(0, index) + s.substr(index + 1);

            if (visited.find(temp) == visited.end()) {
                visited.insert(temp);
                solve(temp, index, removals + 1, minRemovals);
            }
        }
        solve(s, index + 1, removals, minRemovals);
    }

    vector<string> removeInvalidParentheses(string s) {

        int minRemovals = 0;
        int balance = 0;

        for(char ch : s){

            if(ch == '('){
                balance++;
            }
            else if(ch == ')'){

                if(balance > 0){
                    balance--;
                }
                else{
                    minRemovals++;
                }
            }
        }

        minRemovals += balance;

        visited.insert(s);

        solve(s, 0, 0, minRemovals);

        return ans;
    }
};