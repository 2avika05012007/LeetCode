class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<strs[0].length(); i++){
            char a = strs[0].charAt(i);
            for(int j = 0; j<strs.length; j++){
                if (i >= strs[j].length() || strs[j].charAt(i) != a) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}