class Solution {
    public int[] separateDigits(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i: nums){
           int a = i;
            Stack<Integer> st = new Stack<>();
            while(a!=0){
               if(a%10 == 0){
                st.push(0);
               }
               else{st.push(a%10);}
                a/=10;
            }
            while(!st.isEmpty()){
                list.add(st.peek());
                st.pop();
            }

        }
        int[] arr = list.stream().mapToInt(Integer::intValue).toArray();
        return arr;

    }
}