class Solution {
    public int gcd(int a, int b) {
    if (b == 0)
        return a;
    return gcd(b, a % b);
    }
    public int gcdOfOddEvenSums(int n) {
        int sumOdd = 0;
        int sumEven = 0;
        for(int i = 1; i<=n+n; i++){
            if(i%2==0){
                sumEven+=i;
            }
            if(i%2!=0){
                sumOdd+=i;
            }
        }
        return gcd(sumEven, sumOdd);
    }
}