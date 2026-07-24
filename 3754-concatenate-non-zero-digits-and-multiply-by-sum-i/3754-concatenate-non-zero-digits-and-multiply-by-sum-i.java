class Solution {
    public long sumAndMultiply(int n) {
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            int digit = n % 10;
            if (digit != 0) {
                sum += digit;
                sb.append((char)(digit + '0'));
            }
            n /= 10;
        }
        if (sb.length() == 0) {
            return 0;
        }
        sb.reverse();
        int x = Integer.parseInt(sb.toString());
        return (long) x * sum;
    }
}