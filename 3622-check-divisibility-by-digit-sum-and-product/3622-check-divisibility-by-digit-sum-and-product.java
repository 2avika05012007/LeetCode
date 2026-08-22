class Solution {
    public int s(int a){
        int sum = 0;
        int prod = 1;
        while(a!=0){
            int b = a%10;
            sum+= b;
            prod*= b;
            a/=10;

        }
        return sum+prod;
    }
    public boolean checkDivisibility(int n) {
        if(n%s(n)==0){
            return true;
        }
        return false;
    }
}