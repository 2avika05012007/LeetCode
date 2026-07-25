class Solution {
    public int maximum69Number (int num) {
        int n = String.valueOf(num).length();
        int[] arr = new int[n];
        int j = n-1;
        while(num!=0){
            arr[j] = num%10;
            num/=10;
            j--;
        }
        for(int i = 0; i<arr.length; i++){
            if(arr[i] == 6){
                arr[i] = 9;
                break;
            }
        }
        int ans = 0;
        for(int i = 0; i<arr.length; i++){
            ans+= arr[i]*Math.pow(10, n-i-1);
        }
        return ans;
    }
}