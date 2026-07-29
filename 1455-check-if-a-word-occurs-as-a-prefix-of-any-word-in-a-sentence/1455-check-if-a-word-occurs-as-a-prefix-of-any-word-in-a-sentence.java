class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] arr = sentence.split(" ");
        int i = 1;
        for(String str: arr){
            String a = str;
            if(a.startsWith(searchWord)){
                return i;
            }
            else{
                i++;
            }
        }
        return -1;
    }
}