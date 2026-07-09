class Solution {

    private boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i'
            || c == 'o' || c == 'u';
    }
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length - 1;
           while (left < right) {

            while (left < right && !isVowel(arr[left])) {
                left++;
            }

            while (left < right && !isVowel(arr[right])) {
                right--;
            }

            char t = arr[left];
            arr[left] = arr[right];
            arr[right] = t;

            left++;
            right--;
        }
        String ans = new String(arr);
        return ans;
    }
}