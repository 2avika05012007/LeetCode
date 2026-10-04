class Solution {
    public boolean checkValidString(String s) {
        int open = 0;
        int close = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                open++;
                close++;
            }
            else if(ch == ')'){
                open--;
                close--;
            }
            else{
                open--;
                close++;
            }

            if(close<0){
            return false;
        }
        if(open<0){
            open = 0;
        }
        }

        return open == 0;
    }
}