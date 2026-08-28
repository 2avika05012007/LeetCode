class Solution {
    public String lexPalindromicPermutation(String s, String target) {

        int n = s.length();
        int[] cnt = new int[26];

        // Count characters
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        // Find middle character
        char middle = 0;
        boolean hasMiddle = false;

        for (int i = 0; i < 26; i++) {
            if (cnt[i] % 2 == 1) {
                if (hasMiddle) {
                    return "";
                }

                hasMiddle = true;
                middle = (char) ('a' + i);
            }
        }

        /*
         * cnt now represents the characters available
         * for both halves.
         */
        if (hasMiddle) {
            cnt[middle - 'a']--;
        }

        /*
         * Try to make the left half equal to target's
         * left half.
         */
        int half = n / 2;

        boolean possible = true;

        for (int i = 0; i < half; i++) {
            int x = target.charAt(i) - 'a';

            cnt[x] -= 2;

            if (cnt[x] < 0) {
                possible = false;
            }
        }

        /*
         * Special case:
         * If target's left half can be used exactly,
         * construct the palindrome having the same
         * left half and check its right half.
         */
        if (possible) {

            String left = target.substring(0, half);

            StringBuilder right = new StringBuilder();

            if (hasMiddle) {
                right.append(middle);
            }

            right.append(new StringBuilder(left).reverse());

            String candidate = left + right;

            if (candidate.compareTo(target) > 0) {
                return candidate;
            }
        }

        /*
         * Now we need to make the left half larger.
         *
         * Start from the rightmost position and try
         * increasing it.
         */
        for (int i = half - 1; i >= 0; i--) {

            int x = target.charAt(i) - 'a';

            // Restore the pair used at position i
            cnt[x] += 2;

            /*
             * Check whether target[0...i-1] can still
             * be kept unchanged.
             */
            boolean valid = true;

            for (int c = 0; c < 26; c++) {
                if (cnt[c] < 0) {
                    valid = false;
                    break;
                }
            }

            if (!valid) {
                continue;
            }

            /*
             * Find the smallest character greater than
             * target[i].
             */
            for (int j = x + 1; j < 26; j++) {

                if (cnt[j] >= 2) {

                    // Use this larger character
                    cnt[j] -= 2;

                    StringBuilder left = new StringBuilder();

                    // Prefix stays the same
                    left.append(target, 0, i);

                    // Current character becomes larger
                    left.append((char) ('a' + j));

                    // Fill remaining positions as small as possible
                    for (int c = 0; c < 26; c++) {
                        while (cnt[c] >= 2) {
                            left.append((char) ('a' + c));
                            cnt[c] -= 2;
                        }
                    }

                    String leftPart = left.toString();

                    StringBuilder ans = new StringBuilder();

                    ans.append(leftPart);

                    if (hasMiddle) {
                        ans.append(middle);
                    }

                    ans.append(
                        new StringBuilder(leftPart).reverse()
                    );

                    return ans.toString();
                }
            }
        }

        return "";
    }
}