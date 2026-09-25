class Solution {
public:
    set<string> solve(string &s, int &i) {

        set<string> result;

        result.insert("");

        while (i < s.length() && s[i] != '}') {

            set<string> current;

            if (s[i] == '{') {
                
                i++;

                current = solve(s, i);

                i++;
            }
            else if (s[i] == ',') {
                i++;

                set<string> next = solve(s, i);

                result.insert(next.begin(), next.end());

                return result;
            }
            else {
                
                current.insert(string(1, s[i]));
                i++;
            }

            set<string> temp;

            for (string a : result) {
                for (string b : current) {
                    temp.insert(a + b);
                }
            }

            result = temp;
        }

        return result;
    }

    vector<string> braceExpansionII(string expression) {

        int i = 0;

        set<string> result = solve(expression, i);

        return vector<string>(result.begin(), result.end());
    }
};