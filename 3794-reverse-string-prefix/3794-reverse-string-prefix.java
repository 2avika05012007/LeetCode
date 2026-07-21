class Solution {
    public String reversePrefix(String s, int k) {
        char[] arr = new char[s.length()];
        for(int i = 0; i<s.length(); i++){
            arr[i] = s.charAt(i);
        }
        if(k == 1){
            return s;
        }
        int left = 0;
        int right = k-1;
        while(left<=right){
            char temp =arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        StringBuilder sb = new StringBuilder();
        for(char c: arr){
            sb.append(c);
        }
        return sb.toString();
    }
}