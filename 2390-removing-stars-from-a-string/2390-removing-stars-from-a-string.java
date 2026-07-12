import java.util.*;
class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch: s.toCharArray()){
            if(ch!='*'){
                st.push(ch);
            }
            else{
                st.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        
        for(char c: st){
            sb.append(c);
        }
        return sb.toString();
    }
}