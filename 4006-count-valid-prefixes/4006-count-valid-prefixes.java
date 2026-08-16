class Solution {
    public int countValidPrefixes(String s) {
        int zero = 0;
        int nonZero = 0;
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {

            if(s.charAt(i) == '0') {
                zero++;
            }
            else {
                nonZero++;
            }
            if (Math.abs(zero - nonZero) <= 1) {
                ans++;
            }
        }

        return ans;
    }
}