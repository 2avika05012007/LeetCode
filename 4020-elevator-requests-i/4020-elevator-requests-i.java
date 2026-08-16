class Solution {
    public int elevatorRequests(int n, int[] requests) {
        int ans = 0;
        int floor = 0;
        for(int i = 0; i<requests.length; i++){
            int a = Math.abs(requests[i] - floor);
            ans+=a;
            floor = requests[i];
        }
        return ans;
    }
}