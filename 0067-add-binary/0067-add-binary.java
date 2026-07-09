class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder ans = new StringBuilder();
        
        while (i >= 0 || j >= 0 || carry == 1) {
            int sum = carry;

            if (i >= 0 && a.charAt(i) == '1') sum++;
            if (j >= 0 && b.charAt(j) == '1') sum++;

            ans.append(sum % 2);
            carry = sum / 2;

            i--;
            j--;
        }

        return ans.reverse().toString();
    }
}