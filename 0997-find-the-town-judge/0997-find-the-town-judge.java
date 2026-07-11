class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] ind = new int[n+1];
        int[] outd = new int[n+1];
        for(int[] i: trust){
            int a = i[0];
            int b = i[1];

            ind[b]++;
            outd[a]++;
        }
        for (int i = 1; i <= n; i++) {
            if (ind[i] == n - 1 && outd[i] == 0)
            return i;
        }
        return -1;
    }
}