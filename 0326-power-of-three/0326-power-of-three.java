class Solution {
    public boolean isPowerOfThree(int n) {
        int i = 0;
         if (n <= 0) {
            return false;
        }
        while(i<20){
            if(Math.pow(3, i) == n){
                return true;
            }
            i++;

        }
        return false;
    }
}