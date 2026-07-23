class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<>();
        for(String str: words){
            for(String s: words){
                if(s!=str && s.contains(str)){
                    if(!ans.contains(str)){
                        ans.add(str);
                    }
                    
                }
            }
        }
        return ans;
    }
}