class Solution {

    public boolean bool(StringBuilder s) {
        int zero = 0;
        int nonZero = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                zero++;
            } else {
                nonZero++;
            }
        }

        return Math.abs(nonZero - zero) <= 1;
    }

    public int countValidPrefixes(String s) {
        int ans = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));

            if (bool(sb)) {
                ans++;
            }
        }

        return ans;
    }
}