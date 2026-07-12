import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int current : asteroids) {

            while (!st.isEmpty() && st.peek() > 0 && current < 0) {

                if (st.peek() < -current) {
                    
                    st.pop();
                } 
                else if (st.peek() == -current) {
                    
                    st.pop();
                    current = 0;
                    break;
                } 
                else {
                    
                    current = 0;
                    break;
                }
            }

            if (current != 0) {
                st.push(current);
            }
        }
        int[] ans = new int[st.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }

        return ans;
    }
}