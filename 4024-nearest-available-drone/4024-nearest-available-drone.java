class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int min = Integer.MAX_VALUE;
        int ind = -1;
        for (int i = 0; i < drones.length; i++) {
            int ans = Math.abs(drones[i][0] - target[0])
                    + Math.abs(drones[i][1] - target[1]);
            if (ans <= drones[i][2] && ans < min) {
                min = ans;
                ind = i;
            }
        }
        return ind;
    }
}