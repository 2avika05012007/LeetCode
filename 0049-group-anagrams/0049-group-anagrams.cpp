class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {

        unordered_map<string, vector<string>> map;
        for(string str : strs){

            string s = str;

            sort(s.begin(), s.end());

            if(map.find(s) == map.end()){
                map[s] = vector<string>();
            }

            map[s].push_back(str);
        }

        vector<vector<string>> ans;

        for(auto x : map){
            ans.push_back(x.second);
        }

        return ans;
    }
};