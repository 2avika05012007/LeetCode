class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();

        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        int i = 0;

        while (i < n && count[target.charAt(i) - 'a'] > 0) {
            count[target.charAt(i) - 'a']--;
            i++;
        }
        for (int pos = i; pos >= 0; pos--) {

            if (pos < n) {
                for (int c = target.charAt(pos) - 'a' + 1; c < 26; c++) {

                    if (count[c] > 0) {

                        StringBuilder ans = new StringBuilder();

                        ans.append(target.substring(0, pos));

                        ans.append((char) ('a' + c));
                        count[c]--;

                        for (int x = 0; x < 26; x++) {
                            while (count[x] > 0) {
                                ans.append((char) ('a' + x));
                                count[x]--;
                            }
                        }

                        return ans.toString();
                    }
                }
            }
            if (pos > 0) {
                count[target.charAt(pos - 1) - 'a']++;
            }
        }

        return "";
    }
}