class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int[] pair : reservedSeats) {
            int row = pair[0];
            int seat = pair[1];

            if (seat >= 2 && seat <= 9) {
                map.put(row, map.getOrDefault(row, 0) | (1 << seat));
            }
        }

        int ans = (n - map.size()) * 2;

        int left = (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5);
        int middle = (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7);
        int right = (1 << 6) | (1 << 7) | (1 << 8) | (1 << 9);

        for (int mask : map.values()) {

            if ((mask & left) == 0 && (mask & right) == 0) {
                ans += 2;
            }
            else if ((mask & left) == 0 ||
                     (mask & middle) == 0 ||
                     (mask & right) == 0) {
                ans += 1;
            }
        }

        return ans;
    }
}