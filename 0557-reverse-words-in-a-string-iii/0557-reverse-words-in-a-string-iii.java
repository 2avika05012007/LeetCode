class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        String[] ans = new String[arr.length];
        for(int i = 0; i < arr.length; i++){
            char[] brr = arr[i].toCharArray();
            int left = 0;
            int right = brr.length - 1;
            while(left < right){
                char temp = brr[left];
                brr[left] = brr[right];
                brr[right] = temp;
                left++;
                right--;
            }
            ans[i] = new String(brr);
        }
        return String.join(" ", ans);
    }
}