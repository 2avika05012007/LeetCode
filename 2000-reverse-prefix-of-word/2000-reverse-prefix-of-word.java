class Solution {
    public String reversePrefix(String word, char ch) {
        int right = 0;
        int count = 0;
        for(char c: word.toCharArray()){
            if(c==ch){
                right = count;
                break;
            }
            else{
                count++;
            }
        }
        int left = 0;
        char[] arr = new char[word.length()];
        for(int i = 0; i<word.length(); i++){
            arr[i] = word.charAt(i);
        }
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