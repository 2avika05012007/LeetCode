class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        unordered_set<string> words(wordList.begin(), wordList.end());
        if(!words.count(endWord)){
            return 0;
        }
        queue<pair<string, int>> q;
        q.push({beginWord, 1});
        unordered_set<string> visited;
        visited.insert(beginWord);
        while(!q.empty()){
            string word = q.front().first;
            int steps = q.front().second;
            q.pop();
            if(word == endWord){
                return steps;
            }
            for(int i = 0; i < word.size(); i++){
                char original = word[i];
                for(char c = 'a'; c <= 'z'; c++){
                    word[i] = c;
                    if(words.count(word) && !visited.count(word)){
                        visited.insert(word);
                        q.push({word, steps + 1});
                    }
                }
                word[i] = original;
            }
        }
        return 0;
    }
};