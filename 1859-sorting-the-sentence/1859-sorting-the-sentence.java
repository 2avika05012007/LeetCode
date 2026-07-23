class Solution {
    public String sortSentence(String s) {
        String[] arr = s.split(" ");
        String[] ans = new String[arr.length];
        for(String str: arr){
            int len = str.length()-1;
            int i = str.charAt(len) -'0';
            ans[i-1] = str.substring(0, len);
        }
        StringBuilder sb = new StringBuilder();
        int i = ans.length;
        for(String st : ans){
            if(ans[i-1] == st){
                sb.append(st);
            }
            else{
                sb.append(st+" ");
            }
        }
        return sb.toString();
    }
}