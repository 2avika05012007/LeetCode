class Solution {
    public boolean judgeCircle(String moves) {
        Stack<Character> st = new Stack<>();
        if(moves.length() == 1){
            return false;
        }
        for(char ch: moves.toCharArray()){
            if(ch == 'L'){
                if(st.contains('R')){
                    st.remove(Character.valueOf('R'));
                }
                else{
                    st.push('L');
                }
            }
            if(ch == 'R'){
                if(st.contains('L')){
                    st.remove(Character.valueOf('L'));
                }
                else{
                    st.push('R');
                }
            }
            if(ch == 'U'){
                if(st.contains('D')){
                    st.remove(Character.valueOf('D'));
                }
                else{
                    st.push('U');
                }
            }
            if(ch == 'D'){
                if(st.contains('U')){
                    st.remove(Character.valueOf('U'));
                }
                else{
                    st.push('D');
                }
            }
        }
        return st.isEmpty();
    }
}