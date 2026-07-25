class Solution {
    public int maxProduct(int n) {
        String t = String.valueOf(n);
        int[] arr = new int[t.length()];
        int i = 0;
        while(n!=0){
            arr[i] = n%10;
            n/=10;
            i++;
        }
        Arrays.sort(arr);
        return arr[arr.length-1]*arr[arr.length-2];
    }
}