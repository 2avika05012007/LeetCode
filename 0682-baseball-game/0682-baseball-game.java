class Solution {
    public int calPoints(String[] operations) {
        int[] arr = new int[operations.length];
        int i = 0;

        for (String st : operations) {

            if (st.equals("+")) {
                arr[i] = arr[i - 1] + arr[i - 2];
                i++;
            }
            else if (st.equals("D")) {
                arr[i] = 2 * arr[i - 1];
                i++;
            }
            else if (st.equals("C")) {
                i--;
            }
            else {
                arr[i] = Integer.parseInt(st);
                i++;
            }
        }

        int ans = 0;
        for (int k = 0; k < i; k++) {
            ans += arr[k];
        }

        return ans;
    }
}