class Solution {
    public int mirrorDistance(int n) {
        int t = String.valueOf(n).length();
        int[] arr = new int[t];
        int i = t-1;
        int a = n;
        while(n!=0){
            arr[i] = n%10;
            n/=10;
            i--;
        }
        n = a;
        int an = 0;
        for(int j =0; j<arr.length; j++){
            an+=arr[j]*Math.pow(10, j);
        }
        return Math.abs(an-n);
        
    }
}