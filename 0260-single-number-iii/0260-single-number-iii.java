import java.util.*;
class Solution {
    public int[] singleNumber(int[] nums) {
        Stack<Integer> st = new Stack<>();
        for(int i: nums){
            if(st.contains(i)){
                st.remove(Integer.valueOf(i));
            }
            else{st.push(i);}
        }
        int[] ans = new int[st.size()];
        int size = st.size();

for(int i = 0; i < size; i++){
    ans[i] = st.pop();
}
        return ans;
    }
}