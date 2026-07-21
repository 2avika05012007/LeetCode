class Solution {
    public int alternateDigitSum(int n) {
        int sum = 0;
        String str = String.valueOf(n);
        for(int i = 0; i<str.length(); i++){
            if(i%2 == 0){
                sum+=(int)str.charAt(i)-'0';
            }
            else{
                sum-=(int)str.charAt(i)-'0';
            }
        }


        return sum;
    }
}