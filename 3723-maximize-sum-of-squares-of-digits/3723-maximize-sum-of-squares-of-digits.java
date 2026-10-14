class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder sb = new StringBuilder();
        if(sum > 9 * num || sum < 1)
            return "";

        for(int i = 0; i < num; i++){
            int digit = Math.min(9, sum);
            sb.append((char)('0' + digit));
            sum -= digit;
        }

        if(sum != 0)
            return "";

        return sb.toString();
    }
}