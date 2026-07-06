class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();
        if(n==1){
            return true;
        }
        int sum = 0;
        while(n!=1 && !seen.contains(n)){
            seen.add(n);
            sum = 0;
            while(n>0){
                sum+= (n%10)*(n%10);
                n = n/10;
            }
            n = sum;
        
        }
        return n == 1;
    }
}