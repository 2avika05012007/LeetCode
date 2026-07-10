class Solution {
    public boolean isPerfectSquare(int num) {
        int start = 0;
        int end = num;
        while(start<=end){
            
            int mid = start + (end-start)/2;
            long square = (long) mid * mid;
            if(num == square){
                return true;
            }
            if(num>square){
                start = mid + 1;
            }
            if(num<square){
                end = mid - 1;
            }
        }
        return false;
    }
}