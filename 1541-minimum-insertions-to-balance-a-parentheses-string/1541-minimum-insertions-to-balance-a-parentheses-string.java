class Solution {
    public int minInsertions(String s) {
        int ans = 0;
        int o = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                o++;
            }
            else{
                if(i + 1 < s.length() && s.charAt(i + 1) == ')'){
                    if(o > 0){
                        o--;
                    }
                    else{
                        ans++;
                    }
                    i++;
                }
                else{
                    if(o > 0){
                        o--;
                        ans++;
                    }
                    else{
                        ans += 2;
                    }
                }
            }
        }
        ans += o * 2;
        return ans;
    }
}

