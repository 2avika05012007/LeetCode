class Solution {
    public String convertToBase7(int num) {
        StringBuilder sb = new StringBuilder();
        if(num == 0){
            return "0";
        }
        boolean a = num<0;
        num = Math.abs(num);
        while(num!=0){
            int rem = num%7;
            sb.append((char)(rem + '0'));
            num/=7;
        }
        if(a){
            sb.append('-');
        }
        String ans = sb.reverse().toString();
        return ans;
    }
}