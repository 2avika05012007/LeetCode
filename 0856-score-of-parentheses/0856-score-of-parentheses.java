class Solution {
    public int scoreOfParentheses(String s) {

        Stack<Integer> st = new Stack<>();
        st.push(0);

        for(char c : s.toCharArray()){
            if(c == '('){
                st.push(0);

            }
            else {
                int in = st.pop();
                int sc;

                if(in == 0){
                    sc = 1;
                }
                else{
                    sc = 2 * in;
                }

                st.push(st.pop()+sc);
            }
        }

        return st.peek();
    }
}