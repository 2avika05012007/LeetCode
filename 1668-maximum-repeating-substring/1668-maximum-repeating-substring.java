class Solution {
    public int maxRepeating(String sequence, String word) {
        int ans = 0;
        String rep = word;
        while (sequence.contains(rep)) {
            ans++;
            rep += word;
        }

        return ans;
    }
}