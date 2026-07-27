class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int l = 0;
        
        int max = 0;
        for(char ch: moves.toCharArray()){
            if(ch == 'L'){
                l++;
            }
            if(ch == 'R'){
                l--;
            }
            if (ch == '_'){
                max ++;
            }
        }
        return Math.abs(l)+max;
    }
}