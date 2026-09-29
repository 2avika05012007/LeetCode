class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < tokens.length; i++){

            if(tokens[i].equals("+") ||
                tokens[i].equals("-") ||
                tokens[i].equals("*") ||
                tokens[i].equals("/")) {

                int b = st.pop();
                int a = st.pop();
                int ans = 0;

                if(tokens[i].equals("+")){
                    ans = a + b;
                }
                else if(tokens[i].equals("-")){
                    ans = a - b;
                }
                else if(tokens[i].equals("*")){
                    ans = a * b;
                }
                else{
                    ans = a / b;
                }
                st.push(ans);
            }
            else{
                st.push(Integer.parseInt(tokens[i]));
            }
        }
        return st.pop();
    }
}