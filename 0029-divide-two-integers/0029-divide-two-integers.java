class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == -2147483648&&divisor == -1){
            return 2147483647;
        }
        int count = 0;
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        if (divisor == -1){
            return -dividend;
        }
        while(a>=b){
            count ++;
            a-=b;
        }
        if(dividend<0&&divisor<0){
            return count;
        }
        if(dividend<0||divisor<0){
            return -count;
        }
        return count;
    }
}