class Solution {
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for(char ch: s.toCharArray()){
            if(Character.isUpperCase(ch)){
                sb.append(Character.toLowerCase(ch));
            }
            else{
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}