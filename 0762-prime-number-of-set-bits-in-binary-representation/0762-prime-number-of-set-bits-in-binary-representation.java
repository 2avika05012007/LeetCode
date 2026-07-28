class Solution {
    public boolean isPrime(int n) {
    if(n <= 1){
        return false;  
    } 
    if(n == 2){
        return true; 
    }     
    if(n % 2 == 0){
        return false; 
    }
    for (int i = 3; i * i <= n; i += 2) {
        if (n % i == 0) {
            return false;
        }
    }
    return true;
}
    public int countPrimeSetBits(int left, int right) {
        int i = left;
        int ans = 0;
        while(i<=right){
            int count = 0;
            int num = i;
            while (num != 0) {
                if((num & 1) == 1){
                    count++;
                }
                num >>= 1;
            }
            if(isPrime(count)){
                ans++;
            }
            i++;
        }
        return ans;
    }
}