class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int left = 0;
        int one = 0;
        String ans = "";
        for (int right = 0; right < s.length(); right++) {
            if (s.charAt(right) == '1') {
                one++;
            }
            while (one > k) {
                if (s.charAt(left) == '1') {
                    one--;
                }
                left++;
            }

            if (one == k) {
                while (s.charAt(left) == '0') {
                    left++;
                }
                String current = s.substring(left, right + 1);
                if (ans.equals("") || current.length() < ans.length() || (current.length() == ans.length()&& current.compareTo(ans) < 0)) {

                    ans = current;
                }
            }
        }

        return ans;
    }
}